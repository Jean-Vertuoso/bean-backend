package br.com.bean.business.converters;

import br.com.bean.business.dto.CashSessionDto;
import br.com.bean.infrastructure.entities.CashSession;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CashSessionConverter {

    public CashSessionDto entityToDto(CashSession entity){
        CashSessionDto dto = new CashSessionDto();

        dto.setId(entity.getId());
        dto.setOpeningTimestamp(entity.getOpeningTimestamp());
        dto.setClosingTimestamp(entity.getClosingTimestamp());
        dto.setOpeningAmount(entity.getOpeningAmount());
        dto.setClosingAmount(entity.getClosingAmount() != null ? entity.getClosingAmount() : BigDecimal.ZERO);
        dto.setExpectedAmount(entity.getExpectedAmount()  != null ? entity.getExpectedAmount() : BigDecimal.ZERO);
        dto.setNotes(entity.getNotes());
        dto.setStatus(entity.getStatus());
        dto.setUserId(entity.getUser().getId());

        return dto;
    }
}