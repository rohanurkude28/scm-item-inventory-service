package com.spring.cloud.inventory.service.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ItemInventory extends BaseEntity{

    @Builder
    public ItemInventory(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, UUID itemId,
                         Integer quantityOnHand) {
        super(id, version, createdDate, lastModifiedDate);
        this.itemId = itemId;
        this.quantityOnHand = quantityOnHand;
    }

    private UUID itemId;
    private Integer quantityOnHand = 0;
}
