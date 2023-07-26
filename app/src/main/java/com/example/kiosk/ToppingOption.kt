package com.example.kiosk

class ToppingOption {
    private val menuList = ArrayList<MenuItem>()
    val selectedToppings = ArrayList<MenuItem>() // 사용자가 선택한 토핑을 저장하는 리스트

    init {
        menuList.add(MenuItem("선택 안함   ", 0))
        menuList.add(MenuItem("펄 추가    ", 500))
        menuList.add(MenuItem("알로에 추가 ", 500))
        menuList.add(MenuItem("화이트펄 추가", 500))
        menuList.add(MenuItem("코코넛 추가 ", 500))
        menuList.add(MenuItem("밀크폼 추가 ", 500))
        menuList.add(MenuItem("치즈폼 추가 ", 500))
    }

    fun displayMenu() {1
        println("[ 토핑 옵션을 선택해 주세요. ]")
        for ((index, item) in menuList.withIndex()) {
            println("${index}. ${item.name}   |${item.price} 원|")
        }
    }

    fun getMenuItem(index: Int): MenuItem? {
        return if (index in 1..menuList.size) menuList[index - 1] else null
    }

    fun selectTopping(topping: MenuItem): Boolean {
        if (selectedToppings.size >= 3) {
            println("최대 3개의 토핑만 선택할 수 있습니다.")
            return false
        }

        selectedToppings.add(topping)
        return true
    }

}
