package br.com.bean.business.converters;

import br.com.bean.business.dto.UserDto;
import br.com.bean.infrastructure.entities.Role;
import br.com.bean.infrastructure.entities.User;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserConverter {

    public User dtoToEntity(UserDto dto, Set<Role> roles){
        User entity = new User();

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());

        if(roles != null){
            roles.forEach(entity::addRole);
        }

        return entity;
    }

    public UserDto entityToDto(User entity){
        UserDto dto = new UserDto();

        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());

        return dto;
    }
}
