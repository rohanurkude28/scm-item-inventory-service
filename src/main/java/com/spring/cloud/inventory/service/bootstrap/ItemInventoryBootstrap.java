package com.spring.cloud.inventory.service.bootstrap;

import com.spring.cloud.inventory.service.domain.ItemInventory;
import com.spring.cloud.inventory.service.repositories.ItemInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class ItemInventoryBootstrap implements CommandLineRunner {
    
    public static final UUID ITEM_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID ITEM_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID ITEM_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

    private final ItemInventoryRepository itemInventoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if(itemInventoryRepository.count() == 0){
            loadInitialInv();
        }
    }

    private void loadInitialInv() {
        itemInventoryRepository.save(ItemInventory
                .builder()
                .itemId(ITEM_1_UUID)
                .quantityOnHand(50)
                .build());

        itemInventoryRepository.save(ItemInventory
                .builder()
                .itemId(ITEM_2_UUID)
                .quantityOnHand(50)
                .build());

        itemInventoryRepository.saveAndFlush(ItemInventory
                .builder()
                .itemId(ITEM_3_UUID)
                .quantityOnHand(50)
                .build());

        log.debug("Loaded Inventory. Record count: " + itemInventoryRepository.count());
    }
}
