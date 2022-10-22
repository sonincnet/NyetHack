package com.bignerdranch.nyethack

import java.io.File

const val TAVERN_NAME: String = "Taernyl's Folly"

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("./src/com.bignerdranch.nyethack.main/data/tavern-menu-items.txt")
    .readText()
    .split("\n")
val patronGold = mutableMapOf<String, Double>()

fun main() {

    printMenu(menuList)

    (0..9).forEach {
        val first = patronList.random()
        val last = lastName.random()
        val name = "$first $last"
        uniquePatrons += name
    }

    uniquePatrons.forEach {
        patronGold[it] = 20.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(
            uniquePatrons.random(),
            menuList.random())
        orderCount++
    }
    displayPatronBalances()
}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}
private fun placeOrder(patronName: String, menuItem: String) {
    println()
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    val (type, name, price) = menuItem.split(',')
    val messages = mutableListOf<String>()
    val currentPatronGold = patronGold[patronName]!!.minus(price.toDouble())
    patronGold[patronName] = currentPatronGold
    if (patronGold[patronName]!! < 1.22) {
        kickPatron(patronName)
        println("You have no money, $patronName, go out from $TAVERN_NAME\n $patronName Kicked")
        return
    } else {
    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName says: Thanks for the $name."
    }
    messages += "$patronName speaks with $tavernMaster about their order."
    messages += "$patronName buys a $name ($type) for $price"
    messages.forEach { it.run(::println) }
    }
}

private fun kickPatron(patronName: String){
    uniquePatrons.remove(patronName)
    patronGold.remove(patronName)
}

private fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

private fun printDot(lenName: Int, mlName: Int){
    val numDots = 10 + mlName - lenName
    var cntr = 0
    while (cntr<numDots){
        print(".")
        cntr++
    }
}
private fun printMenu(menuList: List<String>){
    var mlName = 0//max length name
    println("*** Welcome to Taernyl's Folly ***")
    menuList.forEach {
        val name = it.split(",")[1]
        if(mlName < name.length){
            mlName = name.length
        }
    }
    menuList.forEach {
        val (type, name, price) = it.split(",")
        println("           ~[$type]~")
        print(name)
        printDot(name.length, mlName)
        println(price)
    }

}