package com.kaeser.platform.u2021.inventory.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.u2021.inventory.domain.model.aggregates.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
    Optional<Equipment> findByMaterialSerialNumber(UUID materialSerialNumber);
}
