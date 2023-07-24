package com.example.kiosk

class MilkTMenu {
    private val menuList = ArrayList<MenuItem>()

    init {
        menuList.add(MenuItem("블랙",4500))
        menuList.add(MenuItem("타로",4500))
        menuList.add(MenuItem("얼그레이 티",4500))
        menuList.add(MenuItem("제주그린티",4500))
        menuList.add(MenuItem("초코",4500))
        menuList.add(MenuItem("피스타치오",4900))
    }
}