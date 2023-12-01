package com.kaeser.platform.u2021.inventory.interfaces.rest.transform;

import com.kaeser.platform.u2021.inventory.domain.model.commands.CreateSparePartCommand;
import com.kaeser.platform.u2021.inventory.interfaces.rest.resources.CreateSparePartResource;

public class CreateSparePartCommandFromResourceAssembler {
    public static CreateSparePartCommand toCommandFromResource(CreateSparePartResource resource) {
        return new CreateSparePartCommand(resource.supplierId() ,resource.model(), resource.supplierProvidedSerialNumber());
    }
}