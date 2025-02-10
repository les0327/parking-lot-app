package com.les.model.request

data class ParkingSpaceRequest(
    val number: Short,
    val floorNumber: Short,
    val free: Boolean
)
