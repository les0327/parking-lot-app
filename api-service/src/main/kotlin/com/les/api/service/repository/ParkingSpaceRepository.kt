package com.les.api.service.repository

import com.les.api.service.repository.entity.ParkingSpaceEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.R2dbcRepository
import java.util.UUID

interface ParkingSpaceRepository : R2dbcRepository<ParkingSpaceEntity, UUID> {

    fun findAllByFree(free: Boolean): Flow<ParkingSpaceEntity>

    fun findAllByFloorNumber(floorNumber: UShort): Flow<ParkingSpaceEntity>

}