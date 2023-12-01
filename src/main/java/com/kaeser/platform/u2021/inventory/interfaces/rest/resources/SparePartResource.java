package com.kaeser.platform.u2021.inventory.interfaces.rest.resources;

import com.kaeser.platform.u2021.inventory.domain.model.aggregates.Equipment;

import java.util.UUID;

public record SparePartResource(Integer id, int supplierId, UUID materialSerialNumber, String model, String supplierProvidedSerialNumber, Integer equipmentId) {
}
