package com.les.api.service.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@Table(name = "parking_space")
data class ParkingSpaceEntity(
    @Id val id: String?=null,
    val number: UShort,
    val floorNumber: UShort,
    val free: Boolean
)
