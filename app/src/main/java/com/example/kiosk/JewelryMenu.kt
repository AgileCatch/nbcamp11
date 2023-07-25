package com.example.kiosk

class JewelryMenu {
    private val menuList = ArrayList<MenuItem>()

    init {
        menuList.add(MenuItem("딸기쥬얼리 밀크티   ",3500))
        menuList.add(MenuItem("브라슈가쥬얼리 밀크티 ",5500))

    }
    fun displayMenu(){
        println("\n[ Jewelry MENU ]")
        for((index, item)in menuList.withIndex()){
            println("${index + 1}. ${item.name}   |${item.price} 원|")
        }
        println("0. 뒤로가기")

    }
    fun getMenuItem(index: Int): MenuItem?{
        return if (index in 1..menuList.size) menuList[index - 1] else null
    }
}