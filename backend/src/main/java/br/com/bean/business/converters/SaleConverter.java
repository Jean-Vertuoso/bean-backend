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

    public Sale toSaleEntity(SaleDtoRequest saleDto){
        Sale sale = new Sale();

        sale.setSaleTimestamp(saleDto.getSaleTimestamp());
        sale.setTotalDiscount(saleDto.getTotalDiscount());
        sale.setTotalValue(saleDto.getTotalValue());
        sale.setPaymentMethod(saleDto.getPaymentMethod());

        return sale;
    }
}
