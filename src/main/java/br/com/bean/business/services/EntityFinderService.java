package br.com.bean.business.services;

import br.com.bean.infrastructure.exceptions.IllegalArgumentException;
import br.com.bean.infrastructure.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EntityFinderService {

    public <ENTITY, ID> ENTITY getReferenceByIdOrThrow(JpaRepository<ENTITY, ID> repository, ID id, String entityName) {
        try{
            return repository.getReferenceById(id);
        } catch(EntityNotFoundException ex) {
            throw new ResourceNotFoundException(entityName + " not found with ID: " + id);
        } catch(IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid or missing " + entityName + " ID.");
        }
    }
}
