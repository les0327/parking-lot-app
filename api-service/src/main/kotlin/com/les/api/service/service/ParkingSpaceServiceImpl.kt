package com.les.api.service.service

import com.les.api.service.mapper.toResponse
import com.les.api.service.repository.ParkingSpaceRepository
import com.les.api.service.repository.entity.ParkingSpaceEntity
import com.les.model.response.ParkingSpace
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ParkingSpaceServiceImpl(private val parkingSpaceRepository: ParkingSpaceRepository): ParkingSpaceService {

    override fun findAll() : Flow<ParkingSpace> {
        return this.parkingSpaceRepository.findAll()
            .asFlow()
            .map { it.toResponse() }
    }

    override fun findAllByFree(free: Boolean) : Flow<ParkingSpace> {
        return this.parkingSpaceRepository.findAllByFree(free)
            .map { entity -> entity.toResponse() }
    }

    override fun findAllByFloorNumber(floorNumber: UShort) : Flow<ParkingSpace> {
        return this.parkingSpaceRepository.findAllByFloorNumber(floorNumber)
            .map { entity -> entity.toResponse() }
    }

    override suspend fun setFree(id: String, free: Boolean) : ParkingSpace {
        val uuid = UUID.fromString(id)

        return this.parkingSpaceRepository.findById(uuid)
            .map { parkingSpace -> ParkingSpaceEntity(uuid, parkingSpace.number, parkingSpace.floorNumber, free) }
            .flatMap(this.parkingSpaceRepository::save)
            .map(ParkingSpaceEntity::toResponse)
            .awaitSingleOrNull()
            ?: throw RuntimeException("Parking space with id $id is not found")
    }
}