package com.kaeser.platform.u2021.inventory.domain.model.valueobjects;

import lombok.Getter;

@Getter
public enum EEquipmentType {
    SCREW_COMPRESSOR(0),
    AIR_TREATMENT(1);

    private final int value;

    EEquipmentType(int value) {
        this.value = value;
    }
}
