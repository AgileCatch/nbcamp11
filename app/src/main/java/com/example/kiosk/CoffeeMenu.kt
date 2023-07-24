package com.example.kiosk

import android.view.Menu
import java.net.Inet4Address

class CoffeeMenu {
    private val menuList = ArrayList<MenuItem>()

    init {
        menuList.add(MenuItem("아메리카노",3700))
        menuList.add(MenuItem("카페라떼",4200))
        menuList.add(MenuItem("카랴멜 카페라떼",4500))
        menuList.add(MenuItem("바닐라 카페라떼",4500))
    }

    fun displayMenu(){
        println("[ Coffee MENU ]")
        for((index,item) in menuList.withIndex()){
            println("${index + 1}. ${item.name}  | W ${item.price}  | ")
        }
        println("0. 뒤로가기")
    }

    fun getMenuItem(index: Int): MenuItem?{
        return if (index in 1..menuList.size) menuList[index - 1] else null
    }
}