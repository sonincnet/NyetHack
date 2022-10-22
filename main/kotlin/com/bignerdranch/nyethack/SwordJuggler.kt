package com.bignerdranch.nyethack

fun main() {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).random() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }
//
//    com.bignerdranch.nyethack.proficiencyCheck(swordsJuggling)
//    swordsJuggling = swordsJuggling!!.plus(1)
//    println("You juggle $swordsJuggling swords!")

}

fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw IllegalStateException("com.bignerdranch.nyethack.Player cannot juggle swords")
}