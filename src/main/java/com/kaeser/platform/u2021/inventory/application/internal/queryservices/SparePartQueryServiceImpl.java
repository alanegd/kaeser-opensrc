package com.kaeser.platform.u2021.inventory.application.internal.queryservices;

import com.kaeser.platform.u2021.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u2021.inventory.domain.model.entities.SparePart;
import com.kaeser.platform.u2021.inventory.domain.model.queries.GetEquipmentByIdQuery;
import com.kaeser.platform.u2021.inventory.domain.model.queries.GetSparePartByIdQuery;
import com.kaeser.platform.u2021.inventory.domain.services.SparePartQueryService;
import com.kaeser.platform.u2021.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import com.kaeser.platform.u2021.inventory.infrastructure.persistence.jpa.repositories.SparePartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SparePartQueryServiceImpl implements SparePartQueryService {

    private final SparePartRepository sparePartRepository;

    public  SparePartQueryServiceImpl( SparePartRepository sparePartRepository) {
        this.sparePartRepository = sparePartRepository;
    }

    @Override
    public Optional<SparePart> handle(GetSparePartByIdQuery query) {
        return sparePartRepository.findById(query.sparePartId());
    }
}
