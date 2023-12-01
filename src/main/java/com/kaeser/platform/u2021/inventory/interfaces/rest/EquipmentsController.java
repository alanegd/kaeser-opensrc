package com.kaeser.platform.u2021.inventory.interfaces.rest;

import ch.qos.logback.classic.model.processor.ConfigurationModelHandler;
import com.kaeser.platform.u2021.inventory.domain.model.queries.GetEquipmentByIdQuery;
import com.kaeser.platform.u2021.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.u2021.inventory.domain.services.EquipmentQueryService;
import com.kaeser.platform.u2021.inventory.interfaces.rest.resources.CreateEquipmentResource;
import com.kaeser.platform.u2021.inventory.interfaces.rest.resources.EquipmentResource;
import com.kaeser.platform.u2021.inventory.interfaces.rest.transform.CreateEquipmentCommandFromResourceAssembler;
import com.kaeser.platform.u2021.inventory.interfaces.rest.transform.EquipmentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/equipments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Equipments", description = "Equipment Management Endpoints")
public class EquipmentsController {
    private final EquipmentQueryService equipmentQueryService;
    private final EquipmentCommandService equipmentCommandService;

    public EquipmentsController(EquipmentQueryService equipmentQueryService, EquipmentCommandService equipmentCommandService) {
        this.equipmentQueryService = equipmentQueryService;
        this.equipmentCommandService = equipmentCommandService;
    }

    @PostMapping
    public ResponseEntity<EquipmentResource> createEquipment(@RequestBody CreateEquipmentResource resource){
        var createEquipmentCommand = CreateEquipmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var equipmentId = equipmentCommandService.handle(createEquipmentCommand);
        if (equipmentId == 0) {
            return ResponseEntity.badRequest().build();
        }
        var getEquipmentByIdQuery = new GetEquipmentByIdQuery(equipmentId);
        var equipment = equipmentQueryService.handle(getEquipmentByIdQuery);

        if (equipment.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return new ResponseEntity<>(equipmentResource, HttpStatus.CREATED);
    }

    @GetMapping("/{equipmentId}")
    public ResponseEntity<EquipmentResource> getEquipment(@PathVariable Integer equipmentId){
        var getEquipmentByIdQuery = new GetEquipmentByIdQuery(equipmentId);
        var equipment = equipmentQueryService.handle(getEquipmentByIdQuery);

        if (equipment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return ResponseEntity.ok(equipmentResource);
    }

}
