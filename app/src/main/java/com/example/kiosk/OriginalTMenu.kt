package com.example.kiosk

class OriginalTMenu {
    private val menuList = ArrayList<MenuItem>()

    init {
        menuList.add(MenuItem("블랙티      ",4000))
        menuList.add(MenuItem("자스민 그린티 ",4000))
        menuList.add(MenuItem("얼그레이 티  ",4000))
        menuList.add(MenuItem("우롱티      ",5100))
    }
    fun displayMenu(){
        println(" [ OriginalT MENU ]")
        for((index, item)in menuList.withIndex()){
            println("${index + 1}. ${item.name}  |  ${item.price} 원 |")
        }
        println("0. 뒤로가기")
    }
    fun getMenuItem(index:Int): MenuItem?{
        return if(index in 1..menuList.size) menuList[index - 1] else null
    }

}