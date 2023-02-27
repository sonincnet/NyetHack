package com.bignerdranch.nyethack

open class Navigation {
}

enum class Direction (private val coordinate: Coordinate){
    NORTH(Coordinate(-1,0)),
    EAST(Coordinate(0,1)),
    SOUTH(Coordinate(1,0)),
    WEST(Coordinate(0,-1));
    fun updateCoordinate(playerCoordinate: Coordinate) =
        coordinate + playerCoordinate
}

data class Coordinate(val x: Int, val y: Int): Navigation(){
    val isInBounds = x >= 0 && y >= 0
    operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
}