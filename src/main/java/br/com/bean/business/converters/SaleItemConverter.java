package br.com.bean.business.converters;

import br.com.bean.business.dto.SaleItemDto;
import br.com.bean.infrastructure.entities.SaleItem;
import org.springframework.stereotype.Component;

@Component
public class SaleItemConverter {

    public SaleItemDto entityToDto(SaleItem entity) {
        SaleItemDto dto = new SaleItemDto();

        dto.setProductId(entity.getProduct().getId());
        dto.setName(entity.getProduct().getName());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setDiscount(entity.getDiscount());
        dto.setSubtotal(entity.getSubtotal());

        return dto;
    }
}
