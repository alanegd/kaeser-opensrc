package com.kaeser.platform.u2021.inventory.interfaces.rest.transform;

import com.kaeser.platform.u2021.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u2021.inventory.interfaces.rest.resources.EquipmentResource;

public class EquipmentResourceFromEntityAssembler {
    public static EquipmentResource toResourceFromEntity(Equipment entity) {
        return new EquipmentResource(entity.getId(), entity.getModel(), entity.getMaterialSerialNumber(), entity.getEquipmentType());
    }
}