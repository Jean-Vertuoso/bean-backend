package br.com.bean.business.services;

import br.com.bean.business.converters.UserConverter;
import br.com.bean.business.dto.LoginRequestDto;
import br.com.bean.business.dto.LoginResponseDto;
import br.com.bean.business.dto.UserDto;
import br.com.bean.business.dto.UserLoggedDto;
import br.com.bean.infrastructure.entities.Role;
import br.com.bean.infrastructure.entities.User;
import br.com.bean.infrastructure.exceptions.ConflictException;
import br.com.bean.infrastructure.exceptions.ResourceNotFoundException;
import br.com.bean.infrastructure.exceptions.UnauthorizedException;
import br.com.bean.infrastructure.repositories.UserRepository;
import br.com.bean.infrastructure.security.CookieUtil;
import br.com.bean.infrastructure.security.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private final EntityFinderService finder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CookieUtil cookieUtil;

    public UserService(UserRepository repository, UserConverter converter, RoleService roleService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil, CookieUtil cookieUtil, EntityFinderService finder) {
        this.repository = repository;
        this.converter = converter;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.cookieUtil = cookieUtil;
        this.finder = finder;
    }

    public LoginResponseDto authUser(LoginRequestDto loginDto, HttpServletResponse response) {
        try{
            Authentication authentication =
                authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
                );

            String jwt = jwtUtil.generateToken(authentication.getName());
            cookieUtil.addJwtToCookie(response, jwt);

            return new LoginResponseDto(
                    "Bearer "+ jwt,
                    loginDto.getEmail()
            );
        } catch (BadCredentialsException | UsernameNotFoundException | AuthorizationDeniedException ex) {
            throw new UnauthorizedException("Invalid user or password: ", ex.getCause());
        }
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
