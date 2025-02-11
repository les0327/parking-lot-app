package com.les.api.service.service

import com.les.model.response.ParkingSpace
import kotlinx.coroutines.flow.Flow

interface ParkingSpaceService {

    fun findAll() : Flow<ParkingSpace>

    fun findAllByFree(free: Boolean) : Flow<ParkingSpace>

    fun findAllByFloorNumber(floorNumber: UShort) : Flow<ParkingSpace>

    suspend fun setFree(id: String, free: Boolean) : ParkingSpace
}