package br.com.bean.business.services;

import br.com.bean.business.converters.UserConverter;
import br.com.bean.business.dto.UserDto;
import br.com.bean.business.dto.UserLoggedDto;
import br.com.bean.infrastructure.entities.Role;
import br.com.bean.infrastructure.entities.User;
import br.com.bean.infrastructure.exceptions.ConflictException;
import br.com.bean.infrastructure.exceptions.ResourceNotFoundException;
import br.com.bean.infrastructure.exceptions.IllegalArgumentException;
import br.com.bean.infrastructure.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService{

    private final UserRepository repository;
    private final UserConverter converter;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private EntityFinderService finder;

    public UserService(UserRepository repository, UserConverter converter, RoleService roleService, PasswordEncoder passwordEncoder, EntityFinderService finder) {
        this.repository = repository;
        this.converter = converter;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.finder = finder;
    }

    @Transactional
    public UserDto saveUser(UserDto dto){
        emailExists(dto.getEmail());
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));

        Set<Role> roles = roleService.findByAuthority(dto.getRoles());

        User entity = converter.dtoToEntity(dto, roles);

        return converter.entityToDto(repository.save(entity));
    }

    public User getReferenceByIdOrThrow(Long id){
        return finder.getReferenceByIdOrThrow(repository, id, "User");
    }

    @Transactional(readOnly = true)
    public UserLoggedDto getMe(){
        User user = authenticated();
        UserLoggedDto userLogged = new UserLoggedDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );

        userLogged.getRoles().addAll(
                user.getRoles().stream().map(Role::getAuthority).collect(Collectors.toSet())
        );

        return userLogged;
    }

    public void emailExists(String email){
        try {
            boolean exists = checkIfEmailExists(email);
            if(exists){
                throw new ConflictException("Email already exists " + email);
            }
        }catch(ConflictException e){
            throw new ConflictException("Email already exists ", e.getCause());
        }
    }

    public boolean checkIfEmailExists(String email){
        return repository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    protected User authenticated() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by email "+ email));

    }
}
