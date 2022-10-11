
fun main(args: Array<String>) {

    var healthPoints = 89
    var isBlessed = true
    val isImmortal = false
    val player = Player()
    player.name = "estragon"
    player.castFireball()
    // Аура
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    // Состояние игрока
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)

}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) = when (healthPoints) {
    100 -> "is in excellent condition!"
    in 90..99 -> "has a few scratches."
    in 75..89 -> if (isBlessed) {
        "has some minor wounds, but is healing quite quickly!"
    } else {
        "has some minor wounds."
    }

    in 15..74 -> "looks pretty hurt."
    else -> "is in awful condition!"
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

private fun auraColor(
    isBlessed: Boolean,
    healthPoints: Int,
    isImmortal: Boolean) = if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"
