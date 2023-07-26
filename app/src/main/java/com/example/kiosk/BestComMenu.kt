package com.example.kiosk

class BestComMenu :Menu{

    private val menuList = ArrayList<MenuItem>()

    init {
        menuList.add(MenuItem("블랙밀크티+펄      ",4700))
        menuList.add(MenuItem("타로밀크티+펄      ",4700))
        menuList.add(MenuItem("우롱티+코코넛+밀크폼 ",4700))
        menuList.add(MenuItem("아메리카노+펄      ",4000))
    }
    override fun displayMenu(){
        println("\n[ Best Combination MENU ]")
        for((index, item)in menuList.withIndex()){
            println("${index + 1}. ${item.name}   |${item.price} 원|")
        }
        println("0. 뒤로가기")
    }

    override fun getMenuItem(index: Int): MenuItem?{
        return if(index in 1..menuList.size) menuList[index - 1] else null
    }
}