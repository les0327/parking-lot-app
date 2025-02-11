package com.les.api.service.mapper

import com.les.api.service.repository.entity.ParkingSpaceEntity
import com.les.model.response.ParkingSpace

fun ParkingSpaceEntity.toResponse() : ParkingSpace {
    if (this.id == null) {
        throw RuntimeException("ParkingSpaceEntity id cannot be null $this")
    }

    return ParkingSpace(
        this.id.toString(),
        this.number,
        this.floorNumber,
        this.free
    )
}