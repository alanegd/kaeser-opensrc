package com.kaeser.platform.u2021.inventory.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.u2021.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u2021.inventory.domain.model.entities.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SparePartRepository extends JpaRepository<SparePart, Integer> {
    Optional<SparePart> findByEquipmentId(Integer equipmentId);
}
