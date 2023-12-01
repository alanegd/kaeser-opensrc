package com.kaeser.platform.u2021.inventory.domain.services;

import com.kaeser.platform.u2021.inventory.domain.model.entities.SparePart;
import com.kaeser.platform.u2021.inventory.domain.model.queries.GetSparePartByIdQuery;

import java.util.Optional;

public interface SparePartQueryService {
    Optional<SparePart> handle(GetSparePartByIdQuery query);
}
