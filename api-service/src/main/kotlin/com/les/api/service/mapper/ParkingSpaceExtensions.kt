package com.les.api.service.mapper

import com.les.api.service.repository.entity.ParkingSpaceEntity
import com.les.model.request.ParkingSpaceRequest
import com.les.model.response.ParkingSpace

fun ParkingSpaceRequest.toEntity() : ParkingSpaceEntity {
    return ParkingSpaceEntity(
        null,
        if (this.number >= 0) this.number.toUShort() else throw RuntimeException("Parking space number can't be less then 0"),
        if (this.floorNumber >= 0) this.floorNumber.toUShort() else throw RuntimeException("Parking space floorNumber can't be less then 0"),
        this.free
    )
}

fun ParkingSpaceEntity.toResponse() : ParkingSpace {
    if (this.id == null) {
        throw RuntimeException("ParkingSpaceEntity id cannot be null $this")
    }

    return ParkingSpace(
        this.id,
        this.number,
        this.floorNumber,
        this.free
    )
}