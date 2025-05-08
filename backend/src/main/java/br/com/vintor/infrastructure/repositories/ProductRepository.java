package br.com.vintor.infrastructure.repositories;

import br.com.vintor.infrastructure.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
