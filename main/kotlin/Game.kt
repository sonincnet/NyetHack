
fun main(args: Array<String>) {


    val player = Player()
//    player.name = "estragon"
    player.castFireball()
    // Аура
//    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    // Состояние игрока
//    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

//    printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)

}



private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String) {
    val besotted = when (2){
        in 1..10-> "Tipsy"
        in 11..20-> "Sloshed"
        in 21..30-> "Soused"
        in 31..40-> "Stewed"
        in 41..50-> "..t0aSt3d"
        else -> "Like glass"
    }
    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
    println("Besotted: $besotted")
}


