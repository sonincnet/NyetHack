package com.bignerdranch.nyethack

fun main() {
    val player = Player()
    player.castFireball()
    // Состояние игрока
    printPlayerStatus(player)

}
private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor(player.isBlessed)}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus(player.healthPoints, player.isBlessed)}")
}