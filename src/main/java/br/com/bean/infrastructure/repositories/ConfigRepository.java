package br.com.bean.infrastructure.repositories;

import br.com.bean.infrastructure.entities.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {

    Optional<Config> findByConfigKey(String key);
}
