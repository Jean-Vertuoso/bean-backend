package br.com.bean.business.services;

import br.com.bean.infrastructure.entities.Category;
import br.com.bean.infrastructure.exceptions.ResourceNotFoundException;
import br.com.bean.infrastructure.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Set<Category> findSetById(Set<Long> ids){
        return ids.stream().map(id -> repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Category not found with id "+ id)))
                .collect(Collectors.toSet());
    }
}
