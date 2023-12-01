package com.kaeser.platform.u2021.inventory.domain.model.entities;

import com.kaeser.platform.u2021.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u2021.inventory.domain.model.valueobjects.EEquipmentType;
import com.kaeser.platform.u2021.inventory.domain.model.valueobjects.MaterialSerialNumber;
import com.kaeser.platform.u2021.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
public class SparePart extends AuditableModel {
    // Establece que la información de los Spare Parts, incluye id (int, Primary Key, Autogenerado),
    //materialSerialNumber (identificador del negocio, Obligatorio), supplierId (int, obligatorio), model (string,
    //obligatorio), supplierProvidedSerialNumber (string, obligatorio), equipmentId (int, obligatorio).


    // Spare Parts, conformadas por los atributos id (int, Primary Key, Autogenerado), materialSerialNumber (owned
    //type, Obligatorio, identificador del negocio), supplierId (int, obligatorio), model (string, obligatorio),
    //supplierProvidedSerialNumber (string, obligatorio), equipmentId (int, Obligatorio, identificador del equipment del
    //que forma parte).

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private MaterialSerialNumber materialSerialNumber;

    @Getter
    private int supplierId;

    @Getter
    private String model;

    @Getter
    private String supplierProvidedSerialNumber;

    @Getter
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    public SparePart(){
        
    }

    public SparePart(int supplierId, String model, String supplierProvidedSerialNumber, Equipment equipment) {
        this.materialSerialNumber = new MaterialSerialNumber();
        this.supplierId = supplierId;
        this.model = model;
        this.supplierProvidedSerialNumber = supplierProvidedSerialNumber;
        this.equipment = equipment;

    }

    public UUID getMaterialSerialNumber() {
        return materialSerialNumber.materialSerialNumber();
    }
}
