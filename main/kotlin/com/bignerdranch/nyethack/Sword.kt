package com.bignerdranch.nyethack

class Sword(): Weapon("Morningstar","One hand Sword") {
        var _name = name
        get() = "The Legendary $field"
        set(value) {
            field = value.toLowerCase().reversed().capitalize()
        }
    init {
        _name = name
    }
}
