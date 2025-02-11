package com.les.api.service.api.doc

import com.les.model.response.ParkingSpace
import kotlinx.coroutines.flow.Flow
import org.springframework.http.MediaType.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/api/parking-space")
interface ParkingSpaceApi {

    @GetMapping(
        produces = [APPLICATION_JSON_VALUE, APPLICATION_NDJSON_VALUE, TEXT_EVENT_STREAM_VALUE]
    )
    fun findAll() : Flow<ParkingSpace>

    @GetMapping(
        path = ["/free/{free}"],
        produces = [APPLICATION_JSON_VALUE, APPLICATION_NDJSON_VALUE, TEXT_EVENT_STREAM_VALUE]
    )
    fun findAllByFree(@PathVariable free: Boolean): Flow<ParkingSpace>

    @GetMapping(
        path = ["/floorNumber/{floorNumber}"],
        produces = [APPLICATION_JSON_VALUE, APPLICATION_NDJSON_VALUE, TEXT_EVENT_STREAM_VALUE]
    )
    fun findAllByFloorNumber(@PathVariable floorNumber: UShort) : Flow<ParkingSpace>

    @PatchMapping(
        path = ["{id}/free/{free}"],
        consumes = [APPLICATION_JSON_VALUE],
        produces = [APPLICATION_JSON_VALUE]
    )
    suspend fun setFree(@PathVariable id: String, @PathVariable free : Boolean) : ParkingSpace

}