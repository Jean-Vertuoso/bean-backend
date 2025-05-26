package br.com.bean.business.services;

import br.com.bean.business.converters.UserConverter;
import br.com.bean.business.dto.in.UserDtoRequest;
import br.com.bean.business.dto.out.UserDtoResponse;
import br.com.bean.infrastructure.entities.User;
import br.com.bean.infrastructure.exceptions.ConflictException;
import br.com.bean.infrastructure.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserConverter userConverter, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDtoResponse saveUser(UserDtoRequest dto){
        emailExists(dto.getEmail());
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        User entity = userConverter.dtoToEntity(dto);

        return userConverter.entityToDto(userRepository.save(entity));
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
        return userRepository.existsByEmail(email);
    }
}
