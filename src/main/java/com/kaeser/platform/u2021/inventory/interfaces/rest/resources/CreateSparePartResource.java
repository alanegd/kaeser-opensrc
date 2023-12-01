package com.kaeser.platform.u2021.inventory.interfaces.rest.resources;

import com.kaeser.platform.u2021.inventory.domain.model.aggregates.Equipment;

public record CreateSparePartResource(int supplierId, String model, String supplierProvidedSerialNumber) {
}
