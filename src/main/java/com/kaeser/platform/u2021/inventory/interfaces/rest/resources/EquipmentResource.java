package com.kaeser.platform.u2021.inventory.interfaces.rest.resources;

import com.kaeser.platform.u2021.inventory.domain.model.valueobjects.EEquipmentType;

import java.util.UUID;

public record EquipmentResource(Integer id, String model, UUID materialSerialNumber, EEquipmentType equipmentType) {
}
