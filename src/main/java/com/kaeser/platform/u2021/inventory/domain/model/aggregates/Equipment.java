package com.kaeser.platform.u2021.inventory.domain.model.aggregates;

import com.kaeser.platform.u2021.inventory.domain.model.valueobjects.EEquipmentType;
import com.kaeser.platform.u2021.inventory.domain.model.valueobjects.MaterialSerialNumber;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Equipment extends AbstractAggregateRoot<Equipment> {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    private String model;

    @Embedded
    private MaterialSerialNumber materialSerialNumber;

    @Enumerated(EnumType.ORDINAL)
    private EEquipmentType equipmentType;


    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    public Equipment() {
    }


    public Equipment(String model, EEquipmentType equipmentType) {
        this.model = model;
        this.equipmentType = equipmentType;
        this.materialSerialNumber = new MaterialSerialNumber();
    }

    public UUID getMaterialSerialNumber() {
        return materialSerialNumber.materialSerialNumber();
    }

    public String getEEquipmentType() {
        return equipmentType.name();
    }

}
