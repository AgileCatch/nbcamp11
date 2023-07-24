package com.example.kiosk

import android.view.Menu

class CoffeeMenu {
    private val menuList = ArrayList<MenuItem>()

    init {
        menuList.add(MenuItem("아메리카노",3700))
        menuList.add(MenuItem("카페라떼",4200))
        menuList.add(MenuItem("카랴멜 카페라떼",4500))
        menuList.add(MenuItem("바닐라 카페라떼",4500))
    }
}