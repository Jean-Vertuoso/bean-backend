package br.com.bean.business.services;

import br.com.bean.infrastructure.repositories.ConfigRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConfigService {

    private final ConfigRepository configRepository;

    public ConfigService(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    public BigDecimal getDefaultOpeningAmount() {
        return configRepository.findByConfigKey("CASH_DEFAULT_OPENING_AMOUNT")
                .map(config -> new BigDecimal(config.getConfigValue()))
                .orElse(BigDecimal.ZERO);
    }

    public void updateDefaultOpeningAmount(BigDecimal newValue) {
        var config = configRepository.findByConfigKey("CASH_DEFAULT_OPENING_AMOUNT")
                .orElseThrow(() -> new RuntimeException("Configuração não encontrada"));

        config.setConfigValue(newValue.toString());
        configRepository.save(config);
    }
}
