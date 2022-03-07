package com.spring.cloud.inventory.service.web.controllers;

import com.spring.cloud.inventory.service.repositories.ItemInventoryRepository;
import com.spring.cloud.inventory.service.web.mappers.ItemInventoryMapper;
import com.spring.cloud.inventory.service.web.model.ItemInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ItemInventoryController {

    private final ItemInventoryRepository itemInventoryRepository;
    private final ItemInventoryMapper itemInventoryMapper;

    @GetMapping("api/v1/item/{itemId}/inventory")
    List<ItemInventoryDto> listitemsById(@PathVariable UUID itemId){
        log.debug("Finding Inventory for itemId:" + itemId);

        return itemInventoryRepository.findAllByitemId(itemId)
                .stream()
                .map(itemInventoryMapper::itemInventoryToItemInventoryDto)
                .collect(Collectors.toList());
    }
}
