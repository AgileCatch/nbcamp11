package com.example.kiosk

data class MenuItem (val name: String, val price:Int){
    override fun toString(): String{
        return "$name | ${price}원"
    }
}