package com.les.model.response

data class ParkingSpace(
    val id: String,
    val number: UShort,
    val floorNumber: UShort,
    val free: Boolean
)
