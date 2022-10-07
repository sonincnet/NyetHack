import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME: String = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("./src/main/data/tavern-menu-items.txt")
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

//    uniquePatrons.run(::println)

    var orderCount = 0
    while (orderCount <= 3) {
        placeOrder(
            uniquePatrons.random(),
            menuList.random())
        orderCount++
    }
//    patronGold.run(::println)
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}

fun performPurchase(price: Double): Boolean {
    displayBalance()
    val totalPurse: Double = playerGold + playerSilver / 100.0
    if (totalPurse<price){
        println("Bartender: Sorry, you haven't money...")
        return false
    }
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    val remainingBalance = totalPurse - price
    val remainingBalanceDracoin  = remainingBalance/1.43
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")
    println("Remaining balance Dracoin: ${"%.4f".format(remainingBalanceDracoin)}")
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingBalance.toInt()
    playerSilver = remainingSilver
    displayBalance()
    return true
}

private fun placeOrder(patronName: String, menuItem: String) {
    println()
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    val (type, name, price) = menuItem.split(',')
    val messages = mutableListOf<String>()
    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName says: Thanks for the $name."
    }
    messages += "$patronName speaks with $tavernMaster about their order."
    messages += "$patronName buys a $name ($type) for $price"
    messages.forEach { it.run(::println) }

    if(performPurchase(price.toDouble())){
        println(phrase)
    } else {
        println("$patronName: Damn shit!!!")
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