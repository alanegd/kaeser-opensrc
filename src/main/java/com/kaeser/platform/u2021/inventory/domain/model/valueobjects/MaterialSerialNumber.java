package com.kaeser.platform.u2021.inventory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record MaterialSerialNumber(UUID materialSerialNumber) {
    public MaterialSerialNumber() {
        this(UUID.randomUUID());
    }

    public MaterialSerialNumber {
        if (materialSerialNumber == null) {
            throw new IllegalArgumentException("Material Serial Number  cannot be null or blank");
        }
    }
}
