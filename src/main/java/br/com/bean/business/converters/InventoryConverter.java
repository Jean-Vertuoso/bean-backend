package br.com.bean.business.converters;

import br.com.bean.business.dto.InventoryDto;
import br.com.bean.infrastructure.entities.Inventory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InventoryConverter {

    public Inventory dtoToEntity(InventoryDto dto){
        Inventory entity = new Inventory();

        entity.setQuantity(dto.getQuantity());
        entity.setMinimumQuantity(dto.getMinimumQuantity());
        entity.setTotalValue(dto.getTotalValue());
        entity.setLastUpdated(LocalDateTime.now());

        return entity;
    }

    public InventoryDto entityToDto(Inventory entity){
        InventoryDto dto = new InventoryDto();

        dto.setQuantity(entity.getQuantity());
        dto.setMinimumQuantity(entity.getMinimumQuantity());
        dto.setTotalValue(entity.getTotalValue());
        dto.setLastUpdated(entity.getLastUpdated());

        return dto;
    }
}
