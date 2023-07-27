package com.example.kiosk

import java.util.Scanner

class ToppingOption {
    private val scanner = Scanner(System.`in`)
    private val pearlPrice: Int = 500
    private val aloePrice: Int = 500
    private val whitePearlPrice: Int = 500
    private val coconutPrice: Int = 500
    private val milkFoamPrice: Int = 700
    private val cheeseFoamPrice: Int = 700

    private var pearlSelected: Boolean = false
    private var aloeSelected: Boolean = false
    private var whitePearlSelected: Boolean = false
    private var coconutSelected: Boolean = false
    private var milkFoamSelected: Boolean = false
    private var cheeseFoamSelected: Boolean = false

    fun displayMenu1() {
        println("\n[ Topping Option ]")
        println("1. 펄 | ${getToppingPriceText(pearlPrice)}")
        println("2. 알로에 | ${getToppingPriceText(aloePrice)}")
        println("3. 화이트펄 | ${getToppingPriceText(whitePearlPrice)}")
        println("4. 코코넛 | ${getToppingPriceText(coconutPrice)}")
        println("5. 밀크폼 | ${getToppingPriceText(milkFoamPrice)}")
        println("6. 치즈폼 | ${getToppingPriceText(cheeseFoamPrice)}")
        println("0. 추가토핑 없음")
    }

    private fun getToppingPriceText(price: Int): String {
        return "$price 원"
    }

    fun selectToppings() {
        while (true) {
            println("추가할 토핑 번호를 입력하세요 (0을 누르면 메뉴판으로 돌아갑니다):")
            val choice = readLine()?.toIntOrNull()

            when (choice) {
                0 -> break // 0을 누르면 메뉴판으로 돌아감
                in 1..6 -> choice?.let { selectTopping(it) }
                else -> println("잘못된 번호를 입력했습니다. 다시 입력해주세요.")
            }
        }
    }

    private fun selectTopping(choice: Int) {
        when (choice) {
            1 -> selectPearl()
            2 -> selectAloe()
            3 -> selectWhitePearl()
            4 -> selectCoconut()
            5 -> selectMilkFoam()
            6 -> selectCheeseFoam()
        }
    }

    private fun selectPearl() {
        pearlSelected = !pearlSelected
        println(if (pearlSelected) "펄이 선택되었습니다." else "펄이 해제되었습니다.")
    }

    private fun selectAloe() {
        aloeSelected = !aloeSelected
        println(if (aloeSelected) "알로에가 선택되었습니다." else "알로에가 해제되었습니다.")
    }

    private fun selectWhitePearl() {
        whitePearlSelected = !whitePearlSelected
        println(if (whitePearlSelected) "화이트펄이 선택되었습니다." else "화이트펄이 해제되었습니다.")
    }

    private fun selectCoconut() {
        coconutSelected = !coconutSelected
        println(if (coconutSelected) "코코넛이 선택되었습니다." else "코코넛이 해제되었습니다.")
    }

    private fun selectMilkFoam() {
        milkFoamSelected = !milkFoamSelected
        println(if (milkFoamSelected) "밀크폼이 선택되었습니다." else "밀크폼이 해제되었습니다.")
    }

    private fun selectCheeseFoam() {
        cheeseFoamSelected = !cheeseFoamSelected
        println(if (cheeseFoamSelected) "치즈폼이 선택되었습니다." else "치즈폼이 해제되었습니다.")
    }

    fun getAdditionalToppingPrice(): Int {
        var totalPrice = 0

        if (pearlSelected) totalPrice += pearlPrice
        if (aloeSelected) totalPrice += aloePrice
        if (whitePearlSelected) totalPrice += whitePearlPrice
        if (coconutSelected) totalPrice += coconutPrice
        if (milkFoamSelected) totalPrice += milkFoamPrice
        if (cheeseFoamSelected) totalPrice += cheeseFoamPrice

        return totalPrice
    }

    fun getSelectedToppings(): String {
        val selectedToppingsList = mutableListOf<String>()
        if (pearlSelected) selectedToppingsList.add("펄")
        if (aloeSelected) selectedToppingsList.add("알로에")
        if (whitePearlSelected) selectedToppingsList.add("화이트펄")
        if (coconutSelected) selectedToppingsList.add("코코넛")
        if (milkFoamSelected) selectedToppingsList.add("밀크폼")
        if (cheeseFoamSelected) selectedToppingsList.add("치즈폼")

        return if (selectedToppingsList.isEmpty()) "추가토핑 없음" else selectedToppingsList.joinToString(", ")
    }
}