package com.spring.cloud.inventory.service.web.mappers;

import com.spring.cloud.inventory.service.domain.ItemInventory;
import com.spring.cloud.inventory.service.web.model.ItemInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface ItemInventoryMapper {

    ItemInventory itemInventoryDtoToItemInventory(ItemInventoryDto itemInventoryDTO);

    ItemInventoryDto itemInventoryToItemInventoryDto(ItemInventory itemInventory);
}
