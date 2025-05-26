package br.com.bean.business.converters;

import br.com.bean.business.dto.RoleDto;
import br.com.bean.business.dto.in.UserDtoRequest;
import br.com.bean.business.dto.out.UserDtoResponse;
import br.com.bean.infrastructure.entities.Role;
import br.com.bean.infrastructure.entities.User;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    private final SaleConverter saleConverter;

    public UserConverter(SaleConverter saleConverter) {
        this.saleConverter = saleConverter;
    }

    public User dtoToEntity(UserDtoRequest dto){
        User entity = new User();

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());

        return entity;
    }

    public UserDtoResponse entityToDto(User entity){
        UserDtoResponse dto = new UserDtoResponse();

        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());

        return dto;
    }

    public Set<Role> toRoleEntityList(Set<RoleDto> dtoList){
        return dtoList.stream().map(this::RoleDtoToEntity).collect(Collectors.toSet());
    }

    public Role RoleDtoToEntity(RoleDto dto){
        Role entity = new Role();
        entity.setId(dto.getId());
        entity.setRole(dto.getRole());
        return entity;
    }

    public Set<RoleDto> toRoleDtoList(Set<Role> entityList){
        return entityList.stream().map(this::RoleEntityToDto).collect(Collectors.toSet());
    }

    public RoleDto RoleEntityToDto(Role entity){
        RoleDto dto = new RoleDto();
        dto.setId(entity.getId());
        dto.setRole(entity.getRole());
        return dto;
    }
}
