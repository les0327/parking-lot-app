package com.les.api.service.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*


@Table(name = "parking_space")
data class ParkingSpaceEntity(
    @Id val id: UUID? = null,
    val number: UShort,
    val floorNumber: UShort,
    val free: Boolean
)
