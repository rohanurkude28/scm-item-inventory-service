package com.spring.cloud.inventory.service.web.mappers;

import com.spring.cloud.inventory.service.domain.ItemInventory;
import com.spring.cloud.inventory.service.domain.ItemInventory.ItemInventoryBuilder;
import com.spring.cloud.inventory.service.web.model.ItemInventoryDto;
import com.spring.cloud.inventory.service.web.model.ItemInventoryDto.ItemInventoryDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-07T20:58:46+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class ItemInventoryMapperImpl implements ItemInventoryMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public ItemInventory itemInventoryDtoToItemInventory(ItemInventoryDto itemInventoryDTO) {
        if ( itemInventoryDTO == null ) {
            return null;
        }

        ItemInventoryBuilder itemInventory = ItemInventory.builder();

        itemInventory.id( itemInventoryDTO.getId() );
        itemInventory.createdDate( dateMapper.asTimestamp( itemInventoryDTO.getCreatedDate() ) );
        itemInventory.lastModifiedDate( dateMapper.asTimestamp( itemInventoryDTO.getLastModifiedDate() ) );
        itemInventory.itemId( itemInventoryDTO.getItemId() );
        itemInventory.quantityOnHand( itemInventoryDTO.getQuantityOnHand() );

        return itemInventory.build();
    }

    @Override
    public ItemInventoryDto itemInventoryToItemInventoryDto(ItemInventory itemInventory) {
        if ( itemInventory == null ) {
            return null;
        }

        ItemInventoryDtoBuilder itemInventoryDto = ItemInventoryDto.builder();

        itemInventoryDto.id( itemInventory.getId() );
        itemInventoryDto.createdDate( dateMapper.asOffsetDateTime( itemInventory.getCreatedDate() ) );
        itemInventoryDto.lastModifiedDate( dateMapper.asOffsetDateTime( itemInventory.getLastModifiedDate() ) );
        itemInventoryDto.itemId( itemInventory.getItemId() );
        itemInventoryDto.quantityOnHand( itemInventory.getQuantityOnHand() );

        return itemInventoryDto.build();
    }
}
