package com.example.kiosk

class MilkTMenu {
    private val menuList = ArrayList<MenuItem>()

    init {
        menuList.add(MenuItem("블랙 밀크티    ",4500))
        menuList.add(MenuItem("타로 밀크티    ",4500))
        menuList.add(MenuItem("얼그레이 밀크티 ",4500))
        menuList.add(MenuItem("제주그린 밀크티 ",4500))
        menuList.add(MenuItem("초콜릿밀크티    ",4500))
        menuList.add(MenuItem("피스타치오 밀크티",4900))
    }
    fun displayMenu(){
        println("[ MilkT MENU ]")
    for((index, item)in menuList.withIndex()){
        println("${index + 1}. ${item.name}   |${item.price} 원|")
    }
    println("0. 뒤로가기")
    }
    fun getMenuItem(index: Int): MenuItem?{
        return if (index in 1..menuList.size) menuList[index - 1] else null
    }
}
