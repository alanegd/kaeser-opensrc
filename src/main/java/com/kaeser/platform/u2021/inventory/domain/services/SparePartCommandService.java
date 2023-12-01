package com.kaeser.platform.u2021.inventory.domain.services;

import com.kaeser.platform.u2021.inventory.domain.model.commands.CreateSparePartCommand;

public interface SparePartCommandService {
    int handle(CreateSparePartCommand command, Integer equipmentId);
}
