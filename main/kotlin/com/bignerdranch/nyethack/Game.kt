package com.bignerdranch.nyethack
fun main(args: Array<String>) {
    Game.play()
}

private fun runSimulation() {
    val greetingFunction = cGreetingFunction()
    println(greetingFunction("Guyal"))
}

private fun cGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}

object Game {
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()

    init {
        println("Welcome, adventurer.")
        player.castFireball()
    }

    fun play() {
        while (true) {
            currentRoom.also {
                it.description().run(::println)
                it.load().run(::println)
            }
            player.status().run(::println)
            print("> Enter your command: ")
            var command = readln()
            if (command.toLowerCase() == "exit") {
                println("Game OFF")
                break
            }
            GameInput(command).processCommand().run(::println)
        }
    }

    private fun printPlayerStatus(player: Player) {
        println(
            "(Aura: ${player.auraColor(player.isBlessed)}) " +
                    "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })
        fun processCommand() = when (command.toLowerCase()) {
            "move" -> move(argument)
            "map" -> getMap()
            "ring" -> ring(argument)
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying todo!"
    }

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )

    private fun getMap(): String {
        var positionList = listOf(
            mutableListOf("O","O","O"),
            mutableListOf("O","O"))
        positionList[player.currentPosition.x][player.currentPosition.y] = "X"
        return "${positionList[0]} \n${positionList[1]}"
    }

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction is out of bounds.")
            }
            val newRoom = worldMap[newPosition.x][newPosition.y]
            player.currentPosition = newPosition
            currentRoom = newRoom
            getMap().run(::println)
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: $directionInput."
        }
    private fun ring(count: String): String {
        var _count = count
        var ringing = ""
        if(currentRoom.name == "Town Square"){
            if (_count == "") _count = "1"
            for(i in 1.._count.toInt()) {
                ringing+=TownSquare().ringBell()+"\n"
            }
        } else {
            ringing = "You can ringing, only on a Town Square."
        }
        return ringing
    }
}