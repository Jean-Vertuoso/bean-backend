package br.com.bean.business.converters;

import br.com.bean.business.dto.SaleDto;
import br.com.bean.infrastructure.entities.CashSession;
import br.com.bean.infrastructure.entities.Client;
import br.com.bean.infrastructure.entities.Sale;
import br.com.bean.infrastructure.entities.User;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class SaleConverter {

    private final SaleItemConverter saleItemConverter;

    public SaleConverter(SaleItemConverter saleItemConverter) {
        this.saleItemConverter = saleItemConverter;
    }

    public Sale dtoToEntity(SaleDto dto, Client client, CashSession cashSession, User user){
        Sale entity = new Sale();

        entity.setSaleTimestamp(Instant.now());
        entity.setTotalDiscount(dto.getTotalDiscount());
        entity.setPaymentMethod(dto.getPaymentMethod());
        entity.setClient(client);
        entity.setCashSession(cashSession);
        entity.setUser(user);

        return entity;
    }

    public SaleDto entityToDto(Sale entity){
        SaleDto dto = new SaleDto();

        dto.setId(entity.getId());
        dto.setSaleTimestamp(entity.getSaleTimestamp());
        dto.setTotalDiscount(entity.getTotalDiscount());
        dto.setTotalValue(entity.getTotalValue());
        dto.setPaymentMethod(entity.getPaymentMethod());
        dto.setClientId(entity.getClient().getId());
        dto.setCashSessionId(entity.getCashSession().getId());
        dto.setUserId(entity.getUser().getId());
        dto.getItems().addAll(entity.getItems().stream().map(saleItemConverter::entityToDto).toList());

        return dto;
    }
}
