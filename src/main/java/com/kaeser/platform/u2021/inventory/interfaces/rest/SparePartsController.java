package com.kaeser.platform.u2021.inventory.interfaces.rest;

import com.kaeser.platform.u2021.inventory.domain.model.queries.GetSparePartByIdQuery;
import com.kaeser.platform.u2021.inventory.domain.services.SparePartCommandService;
import com.kaeser.platform.u2021.inventory.domain.services.SparePartQueryService;
import com.kaeser.platform.u2021.inventory.interfaces.rest.resources.CreateSparePartResource;
import com.kaeser.platform.u2021.inventory.interfaces.rest.resources.SparePartResource;
import com.kaeser.platform.u2021.inventory.interfaces.rest.transform.CreateSparePartCommandFromResourceAssembler;
import com.kaeser.platform.u2021.inventory.interfaces.rest.transform.SparePartResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/equipments/{equipmentId}/spare-parts", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Spare parts", description = "Spare parts Management Endpoints")
public class SparePartsController {
    private final SparePartQueryService sparePartQueryService;
    private final SparePartCommandService sparePartCommandService;

    public SparePartsController(SparePartQueryService sparePartQueryService, SparePartCommandService sparePartCommandService) {
        this.sparePartQueryService = sparePartQueryService;
        this.sparePartCommandService = sparePartCommandService;
    }

    @PostMapping
    public ResponseEntity<SparePartResource> createSparePart(@RequestBody CreateSparePartResource resource, @PathVariable Integer equipmentId){

        var createSparePartCommand = CreateSparePartCommandFromResourceAssembler.toCommandFromResource(resource);
        var sparePartId = sparePartCommandService.handle(createSparePartCommand, equipmentId);
        if (sparePartId == 0) {
            return ResponseEntity.badRequest().build();
        }
        var getSparePartByIdQuery = new GetSparePartByIdQuery(sparePartId);
        var sparePart = sparePartQueryService.handle(getSparePartByIdQuery);

        if (sparePart.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var sparePartResource = SparePartResourceFromEntityAssembler.toResourceFromEntity(sparePart.get());
        return ResponseEntity.ok(sparePartResource);
    }
}
