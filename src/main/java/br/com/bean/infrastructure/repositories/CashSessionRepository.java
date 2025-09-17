package br.com.bean.infrastructure.repositories;

import br.com.bean.infrastructure.entities.CashSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CashSessionRepository extends JpaRepository<CashSession, Long> {

    @Query(value =
            """
            SELECT DISTINCT cs.id 
            FROM tb_cash_session cs 
            INNER JOIN tb_user us ON cs.user_id = us.id 
            WHERE cs.user_id = :userId AND cs.status = 'OPEN' 
            """
    , nativeQuery = true)
    Optional<Long> findActiveByUserId(Long userId);
}
