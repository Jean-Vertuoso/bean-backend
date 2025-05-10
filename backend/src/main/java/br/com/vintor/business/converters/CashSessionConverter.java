package br.com.vintor.business.converters;

import br.com.vintor.business.dto.in.CashSessionDtoRequest;
import br.com.vintor.infrastructure.entities.CashSession;
import org.springframework.stereotype.Component;

@Component
public class CashSessionConverter {

    public CashSession toEntity(CashSessionDtoRequest cashSessionDto){
        CashSession entity = new CashSession();

        entity.setOpeningTimestamp(cashSessionDto.getOpeningTimestamp());
        entity.setClosingTimestamp(cashSessionDto.getClosingTimestamp());
        entity.setOpeningAmount(cashSessionDto.getOpeningAmount());
        entity.setClosingAmount(cashSessionDto.getClosingAmount());
        entity.setExpectedAmount(cashSessionDto.getExpectedAmount());
        entity.setNotes(cashSessionDto.getNotes());
        entity.setClosed(cashSessionDto.getClosed());

        return entity;
    }
}