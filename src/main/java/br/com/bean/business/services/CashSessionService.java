package br.com.bean.business.services;

import br.com.bean.business.converters.CashSessionConverter;
import br.com.bean.business.dto.CashSessionDto;
import br.com.bean.business.enums.CashSessionStatus;
import br.com.bean.infrastructure.entities.CashSession;
import br.com.bean.infrastructure.entities.User;
import br.com.bean.infrastructure.exceptions.IllegalArgumentException;
import br.com.bean.infrastructure.exceptions.ResourceNotFoundException;
import br.com.bean.infrastructure.repositories.CashSessionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CashSessionService {

    private final CashSessionRepository repository;
    private final CashSessionConverter converter;
    private final UserService userService;
    private final ConfigService configService;
    private final EntityFinderService finderService;

    public CashSessionService(CashSessionRepository repository, CashSessionConverter converter, UserService userService, ConfigService configService, EntityFinderService finderService) {
        this.repository = repository;
        this.converter = converter;
        this.userService = userService;
        this.configService = configService;
        this.finderService = finderService;
    }

    public CashSessionDto openCashSession() {
        CashSession cashSession = new CashSession();
        User user = userService.getReferenceByIdOrThrow(userService.getMe().getId());

        cashSession.setOpeningTimestamp(Instant.now());
        cashSession.setOpeningAmount(configService.getDefaultOpeningAmount());
        cashSession.setStatus(CashSessionStatus.OPENED);
        cashSession.setUser(user);

        return converter.entityToDto(repository.save(cashSession));
    }

    public CashSessionDto closeCashSession(Long sessionId) {
        return new CashSessionDto();
    }



    public CashSession getReferenceByIdOrThrow(Long id) {
        return finderService.getReferenceByIdOrThrow(repository, id, "CashSession");
    }
}
