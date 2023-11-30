package com.kaeser.platform.u2021.inventory.domain.services;

import com.kaeser.platform.u2021.inventory.domain.model.commands.CreateEquipmentCommand;

public interface EquipmentCommandService {
    int handle(CreateEquipmentCommand command);
}
