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

    public User toUserEntity(UserDtoRequest userDto){
        User userEntity = new User();

        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());

        return userEntity;
    }

    public Set<Role> toRoleEntityList(Set<RoleDto> rolesDto){
        return rolesDto.stream().map(this::toRoleEntity).collect(Collectors.toSet());
    }

    public Role toRoleEntity(RoleDto roleDto){
        Role entity = new Role();
        entity.setId(roleDto.getId());
        entity.setRole(roleDto.getRole());
        return entity;
    }

    public UserDtoResponse toUserDto(User userEntity){
        UserDtoResponse userDto = new UserDtoResponse();

        userDto.setName(userEntity.getName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());

        return userDto;
    }

    public Set<RoleDto> paraListaFuncaoDto(Set<Role> funcoes){
        return funcoes.stream().map(this::toRoleDto).collect(Collectors.toSet());
    }

    public RoleDto toRoleDto(Role role){
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setRole(role.getRole());
        return roleDto;
    }
}
