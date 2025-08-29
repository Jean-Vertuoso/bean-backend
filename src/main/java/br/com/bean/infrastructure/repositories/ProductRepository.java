package br.com.bean.infrastructure.repositories;

import br.com.bean.infrastructure.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
            SELECT * FROM tb_product WHERE name ILIKE CONCAT('%', :nameOrBarCode, '%') OR bar_code ILIKE CONCAT('%', :nameOrBarCode, '%')
            """, nativeQuery = true)
    List<Product> findByNameContainingIgnoreCaseOrBarCode(String nameOrBarCode);
}
