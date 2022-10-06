//Функциональный "тип" var name: "()-> type"

fun main() {

    println (configureGreetingFunction()("Player01"))
}

private fun printConstructionCost(numBuildings: Int): String{
    val cost = 500
    return "construction cost: ${cost * numBuildings}"
}

private fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println(printConstructionCost(numBuildings))
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}