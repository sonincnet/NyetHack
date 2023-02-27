package com.bignerdranch.test
fun main() {

}

class Test (_name: String) {
    var name = _name
        get() = "GET: $field"
        set (value){
            field = value.toLowerCase().reversed().capitalize()
        }
//    init {
//        name = "INIT String"
//    }
    fun setName2(n: String){
        name = n
    }
}