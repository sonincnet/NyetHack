package com.bignerdranch.nyethack

import java.util.function.UnaryOperator

fun main() {
//    var positionList = listOf(
//        mutableListOf("","",""),
//        mutableListOf("","")
//    )
//    positionList.map {it.replaceAll((UnaryOperator { "0" }))}//update all list
    val seq = 1..3
    seq.forEach{it.run(::println)}
    println(seq)
}

fun printIsSourceOfBlessings(any: Any) {
    val isSourceOfBlessings = if (any is Player) {
        any.isBlessed
    } else {
        (any as Room).name == "Fount of Blessings"
    }
    println("$any is a source of blessings: $isSourceOfBlessings")
}

fun ring(count: String = "1"): String{
        for(i in 1..count.toInt()) {
            TownSquare().ringBell().run(::println)
        }
        return "ccc"
}