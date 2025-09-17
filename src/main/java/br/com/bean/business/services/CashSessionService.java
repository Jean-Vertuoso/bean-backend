package br.com.bean.business.services;

import br.com.bean.business.converters.CashSessionConverter;
import br.com.bean.business.dto.CashSessionDto;
import br.com.bean.business.dto.ClosingSessionDto;
import br.com.bean.business.enums.CashSessionStatus;
import br.com.bean.infrastructure.entities.CashSession;
import br.com.bean.infrastructure.entities.User;
import br.com.bean.infrastructure.exceptions.ResourceNotFoundException;
import br.com.bean.infrastructure.repositories.CashSessionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
        cashSession.setStatus(CashSessionStatus.OPEN);
        cashSession.setUser(user);

        return converter.entityToDto(repository.save(cashSession));
    }

    @Transactional
    public CashSessionDto closeCashSession(ClosingSessionDto dto) {
        CashSession cashSession = getReferenceByIdOrThrow(getActiveCashSession());

        cashSession.setClosingTimestamp(Instant.now());
        cashSession.setNotes(dto.getNotes());
        cashSession.setClosingAmount(dto.getClosingAmount());
        cashSession.setStatus(CashSessionStatus.CLOSED);

        return converter.entityToDto(repository.save(cashSession));
    }

    @Transactional(readOnly = true)
    public Long getActiveCashSession() {
        Long userLoggedId = userService.authenticated().getId();
        return repository.findActiveByUserId(userLoggedId)
                .orElseThrow(() -> new ResourceNotFoundException("No active cash session found for the user with ID " + userLoggedId));
    }

    @Transactional
    public void updateExpectedAmount(CashSession cashSession) {
        cashSession.updateExpectedAmountAndTotalSales();
        repository.save(cashSession);
    }

    public CashSession getReferenceByIdOrThrow(Long id) {
        return finderService.getReferenceByIdOrThrow(repository, id, "CashSession");
    }
}
