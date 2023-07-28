package com.example.kiosk

data class MenuItem (val name: String, val price:Int,val teaOption: TeaOption? = null){
    override fun toString(): String{
        return "$name | ${price}원"
    }
}