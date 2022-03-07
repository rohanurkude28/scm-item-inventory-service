package com.spring.cloud.inventory.service.repositories;

import com.spring.cloud.inventory.service.domain.ItemInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemInventoryRepository extends JpaRepository<ItemInventory, UUID> {

    List<ItemInventory> findAllByitemId(UUID itemId);
}
