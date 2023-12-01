package com.kaeser.platform.u2021.inventory.application.internal.commandservices;

import com.kaeser.platform.u2021.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u2021.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u2021.inventory.domain.model.commands.CreateSparePartCommand;
import com.kaeser.platform.u2021.inventory.domain.model.entities.SparePart;
import com.kaeser.platform.u2021.inventory.domain.services.SparePartCommandService;
import com.kaeser.platform.u2021.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import com.kaeser.platform.u2021.inventory.infrastructure.persistence.jpa.repositories.SparePartRepository;
import org.springframework.stereotype.Service;

@Service
public class SparePartCommandServiceImpl implements SparePartCommandService {
    private final SparePartRepository sparePartRepository;
    private final EquipmentRepository equipmentRepository;

    public SparePartCommandServiceImpl(SparePartRepository sparePartRepository, EquipmentRepository equipmentRepository) {
        this.sparePartRepository = sparePartRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public int handle(CreateSparePartCommand command, Integer equipmentId) {

        // Validate unique equipmentId on spare part

        sparePartRepository.findByEquipmentId(equipmentId).map(sparePart -> {
            throw new IllegalArgumentException("Spare part already exists for equipment " + equipmentId);
        });

        // Validate that equipment exists

        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new IllegalArgumentException("Equipment does not exist"));


        // Creating new spare part and assigning the equipment to it
        var sparePart = new SparePart(
                command.supplierId(),
                command.model(),
                command.supplierProvidedSerialNumber(),
                equipment
        );


        sparePartRepository.save(sparePart);

        return sparePart.getId();
    }
}
