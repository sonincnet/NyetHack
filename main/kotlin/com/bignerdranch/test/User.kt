package com.bignerdranch.test

class User(_name: String, var surname: String, var post: String) {
    var name = _name
    var fired = false
    init{
        require(name.length>1, {"name, at least must be more than one character"})
        println("INIT_BLOCK")
    }
    constructor(only_name: String)
        : this(only_name, surname = "Smith", post = "Autor"){//инициализация параметров главного конструктора
        fired = true
    }
    fun getUserName(): String{
        return name+" "+surname+" "+post
    }
    fun getStatus(): String{
        if (fired){
            return "Fired"
        } else {
            return "Works"
        }
    }
}