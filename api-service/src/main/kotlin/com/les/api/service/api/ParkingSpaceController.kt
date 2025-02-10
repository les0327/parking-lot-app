package com.les.api.service.api

import com.les.api.service.api.doc.ParkingSpaceApi
import com.les.api.service.mapper.toEntity
import com.les.api.service.mapper.toResponse
import com.les.api.service.repository.ParkingSpaceRepository
import com.les.model.request.ParkingSpaceRequest
import com.les.model.response.ParkingSpace
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.reactive.asFlow
import org.springframework.web.bind.annotation.RestController

@RestController
class ParkingSpaceController(private val parkingSpaceRepository: ParkingSpaceRepository) : ParkingSpaceApi {

    override fun findAll(): Flow<ParkingSpace> {
        return this.parkingSpaceRepository.findAll().asFlow().map { it.toResponse() }
    }

    override fun findAllByFloorNumber(floorNumber: UShort): Flow<ParkingSpace> {
        return this.parkingSpaceRepository.findAllByFloorNumber(floorNumber)
            .map { entity -> entity.toResponse() }
    }

    override suspend fun update(parkingSpaceRequest: ParkingSpaceRequest): ParkingSpace {
        return (
                this.parkingSpaceRepository
                    .save(parkingSpaceRequest.toEntity())
                    ?: throw RuntimeException("Failed to save paking space $parkingSpaceRequest")
                )
            .toResponse()
    }
}