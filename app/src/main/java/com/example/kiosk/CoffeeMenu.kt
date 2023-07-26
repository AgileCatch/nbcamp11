package com.example.kiosk



class CoffeeMenu:Menu {
    private val menuList = ArrayList<MenuItem>()

    init {
        menuList.add(MenuItem("아메리카노 ",3700))
        menuList.add(MenuItem("카페라떼  ",4200))
        menuList.add(MenuItem("카라멜라떼 ",4500))
        menuList.add(MenuItem("바닐라라떼 ",4500))
    }

    override fun displayMenu(){
        println("\n[ Coffee MENU ]")
        for((index,item) in menuList.withIndex()){
            println("${index + 1}. ${item.name}  | W ${item.price}  | ")
        }
        println("0. 뒤로가기")
    }

    override fun getMenuItem(index: Int): MenuItem?{
        return if (index in 1..menuList.size) menuList[index - 1] else null
    }
}