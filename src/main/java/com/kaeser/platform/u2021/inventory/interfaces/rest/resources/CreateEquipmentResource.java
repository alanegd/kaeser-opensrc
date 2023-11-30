package com.kaeser.platform.u2021.inventory.interfaces.rest.resources;

import com.kaeser.platform.u2021.inventory.domain.model.valueobjects.EEquipmentType;

public record CreateEquipmentResource(String model, EEquipmentType equipmentType) {
}
