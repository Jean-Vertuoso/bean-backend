package br.com.bean.infrastructure.repositories;

import br.com.bean.infrastructure.entities.CashSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashSessionRepository extends JpaRepository<CashSession, Long> {
}
