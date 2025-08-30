package br.com.bean.infrastructure.repositories;

import br.com.bean.infrastructure.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(nativeQuery = true, value =
        """
            SELECT s.*, i.*
            FROM tb_sale s
            LEFT JOIN tb_sale_item i ON i.sale_id = s.id
            WHERE s.id = :id;
        """
    )
    Optional<Sale> findSaleWithItemsById(Long id);
}
