package br.com.bean.business.services;

import br.com.bean.infrastructure.entities.Role;
import br.com.bean.infrastructure.exceptions.ResourceNotFoundException;
import br.com.bean.infrastructure.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Set<Role> findByAuthority(Set<String> roles){
        return roles.stream().map(role -> repository.findByAuthority(role)
                        .orElseThrow(() -> new ResourceNotFoundException("Role not found "+ role)))
                .collect(Collectors.toSet());
    }
}
