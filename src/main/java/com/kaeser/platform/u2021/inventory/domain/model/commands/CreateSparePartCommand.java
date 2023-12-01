package com.kaeser.platform.u2021.inventory.domain.model.commands;

public record CreateSparePartCommand(int supplierId, String model, String supplierProvidedSerialNumber) {
}
