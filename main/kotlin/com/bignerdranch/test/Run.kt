package com.bignerdranch.test
fun main() {
//  User("Don", "Jonson", "Actor").also{
    User("Kevin").also{
        it.getUserName().run(::println)
        it.getStatus().run(::println)
    }
}