package com.kaeser.platform.u2021.inventory.application.internal.commandservices;

import com.kaeser.platform.u2021.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u2021.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u2021.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.u2021.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public int handle(CreateEquipmentCommand command) {


        var equipment = new Equipment(
                command.model(),
                command.equipmentType()
        );
        equipmentRepository.save(equipment);

        return equipment.getId();
    }
}
