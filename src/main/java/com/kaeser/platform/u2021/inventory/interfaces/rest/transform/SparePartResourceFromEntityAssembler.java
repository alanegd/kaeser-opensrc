package com.kaeser.platform.u2021.inventory.interfaces.rest.transform;

import com.kaeser.platform.u2021.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u2021.inventory.domain.model.entities.SparePart;
import com.kaeser.platform.u2021.inventory.interfaces.rest.resources.EquipmentResource;
import com.kaeser.platform.u2021.inventory.interfaces.rest.resources.SparePartResource;

public class SparePartResourceFromEntityAssembler {
    public static SparePartResource toResourceFromEntity(SparePart entity) {
        return new SparePartResource(entity.getId(), entity.getSupplierId(), entity.getMaterialSerialNumber(), entity.getModel(), entity.getSupplierProvidedSerialNumber(), entity.getEquipment().getId());
    }
}