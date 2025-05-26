package br.com.bean.business.converters;

import br.com.bean.business.dto.in.SaleDtoRequest;
import br.com.bean.infrastructure.entities.Sale;
import org.springframework.stereotype.Component;

@Component
public class SaleConverter {

    private final ClientConverter clientConverter;
    private final CashSessionConverter cashSessionConverter;

    public SaleConverter(ClientConverter clientConverter, CashSessionConverter cashSessionConverter) {
        this.clientConverter = clientConverter;
        this.cashSessionConverter = cashSessionConverter;
    }

    public Sale dtoToEntity(SaleDtoRequest dto){
        Sale entity = new Sale();

        entity.setSaleTimestamp(dto.getSaleTimestamp());
        entity.setTotalDiscount(dto.getTotalDiscount());
        entity.setTotalValue(dto.getTotalValue());
        entity.setPaymentMethod(dto.getPaymentMethod());

        return entity;
    }
}
