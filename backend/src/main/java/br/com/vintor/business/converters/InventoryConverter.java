package br.com.vintor.business.converters;

import br.com.vintor.business.dto.InventoryDto;
import br.com.vintor.infrastructure.entities.Inventory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InventoryConverter {

    public Inventory toInventoryEntity(InventoryDto inventoryDto){
        Inventory inventory = new Inventory();

        inventory.setQuantity(inventoryDto.getQuantity());
        inventory.setMinimumQuantity(inventoryDto.getMinimumQuantity());
        inventory.setTotalValue(inventoryDto.getTotalValue());
        inventory.setLastUpdated(LocalDateTime.now());

        return inventory;
    }

    public InventoryDto toInventoryDto(Inventory inventory){
        InventoryDto inventoryDto = new InventoryDto();

        inventoryDto.setQuantity(inventory.getQuantity());
        inventoryDto.setMinimumQuantity(inventory.getMinimumQuantity());
        inventoryDto.setTotalValue(inventory.getTotalValue());
        inventoryDto.setLastUpdated(inventory.getLastUpdated());

        return inventoryDto;
    }
}
