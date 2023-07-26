package com.example.kiosk

class ToppingOpion {
    private val menuList = ArrayList<ToppingItem>()
    val selectedToppings = ArrayList<ToppingItem>() // 사용자가 선택한 토핑을 저장하는 리스트

    init {
        menuList.add(ToppingItem("펄 ", 500))
        menuList.add(ToppingItem("알로에 ", 500))
        menuList.add(ToppingItem("화이트펄 ", 500))
        menuList.add(ToppingItem("코코넛 ", 500))
        menuList.add(ToppingItem("밀크폼 ", 700))
        menuList.add(ToppingItem("치즈폼 ", 700))
    }

    fun displayMenu() {
        println("[ Tea Option ]")
        for ((index, item) in menuList.withIndex()) {
            println("${index + 1}. ${item.name}   |${item.price} 원|")
        }
    }

    fun getMenuItem(index: Int): ToppingItem? {
        return if (index in 1..menuList.size) menuList[index - 1] else null
    }

    fun selectTopping(topping: ToppingItem): Boolean {
        if (selectedToppings.size >= 3) {
            println("최대 3개의 토핑만 선택할 수 있습니다.")
            return false
        }

        selectedToppings.add(topping)
        return true
    }

    fun getSelectedToppings(): List<ToppingItem> {
        return selectedToppings
    }
}
