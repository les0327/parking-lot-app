package com.les.api.service.api

import com.les.api.service.api.doc.ParkingSpaceApi
import com.les.api.service.service.ParkingSpaceService
import com.les.model.response.ParkingSpace
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.RestController

@RestController
class ParkingSpaceController(private val parkingSpaceService: ParkingSpaceService) : ParkingSpaceApi {

    override fun findAll(): Flow<ParkingSpace> {
        return this.parkingSpaceService.findAll()
    }

    override fun findAllByFree(free: Boolean): Flow<ParkingSpace> {
        return this.parkingSpaceService.findAllByFree(free);
    }

    override fun findAllByFloorNumber(floorNumber: UShort): Flow<ParkingSpace> {
        return this.parkingSpaceService.findAllByFloorNumber(floorNumber);
    }

    override suspend fun setFree(id: String, free: Boolean): ParkingSpace {
        return this.parkingSpaceService.setFree(id, free);
    }
}