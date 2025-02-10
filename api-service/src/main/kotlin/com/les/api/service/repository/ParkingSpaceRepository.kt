package com.les.api.service.repository

import com.les.api.service.repository.entity.ParkingSpaceEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ParkingSpaceRepository : ReactiveCrudRepository<ParkingSpaceEntity, String> {

    fun findAllByFloorNumber(floorNumber: UShort): Flow<ParkingSpaceEntity>

    suspend fun save(parkingSpaceEntity: ParkingSpaceEntity) : ParkingSpaceEntity?
}