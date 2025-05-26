package br.com.bean.business.converters;

import br.com.bean.business.dto.in.CashSessionDtoRequest;
import br.com.bean.infrastructure.entities.CashSession;
import org.springframework.stereotype.Component;

@Component
public class CashSessionConverter {

    public CashSession dtoToEntity(CashSessionDtoRequest dto){
        CashSession entity = new CashSession();

        entity.setOpeningTimestamp(dto.getOpeningTimestamp());
        entity.setClosingTimestamp(dto.getClosingTimestamp());
        entity.setOpeningAmount(dto.getOpeningAmount());
        entity.setClosingAmount(dto.getClosingAmount());
        entity.setExpectedAmount(dto.getExpectedAmount());
        entity.setNotes(dto.getNotes());
        entity.setClosed(dto.getClosed());

        return entity;
    }
}