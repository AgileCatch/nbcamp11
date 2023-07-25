package com.example.kiosk

import androidx.core.graphics.green
import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)
    val coffeeMenu = CoffeeMenu()
    val bestcomMunu = BestComMenu()
    val jewelryMenu = JewelryMenu()
    val milkTMenu = MilkTMenu()
    val originalTMenu = OriginalTMenu()
    val order = Order()

    println("현재 잔액을 입력하세요")
    var cash = scanner.nextInt()
    val won = "원"

    while (true) {
        println("\" 공차에 오신걸 환영합니다 \"")
        println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요")
        println("[ 공차 메뉴 ]")
        println("1. 베스트 콤비네이션      | 음료 토핑 조합   ")
        println("2. 오리지날 티      | 티 ")
        println("3. 밀크티      | 밀크 티")
        println("4. 쥬얼리      | 쥬얼리 티")
        println("5. Coffee      | 직접 갈은 원두를 사용한 커피")
        println("6. Order       | 장바구니를 확인 후 주문합니다.")
        println("7. Cancel      | 진행중인 주문을 취소합니다.")

        print("선택:")
        val choice = scanner.nextInt()

        when (choice) {
            1 -> {
                bestcomMunu.displayMenu()
                print("선택 ")
                val bestcomChoice = scanner.nextInt()
                if (bestcomChoice == 0) continue
                val menuItem = bestcomMunu.getMenuItem(bestcomChoice)
                if (menuItem != null) {
                    order.addToOrder(menuItem)
                } else {
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }

            2 -> {
                originalTMenu.displayMenu()
                print("선택 ")
                val originalTChoice = scanner.nextInt()
                if (originalTChoice == 1) continue
                val menuItem = originalTMenu.getMenuItem(originalTChoice)
                if (menuItem != null) {
                    order.addToOrder(menuItem)
                } else {
                    println("잘못된 번호를 입력했어요. 다시 입력해주시요")
                }
            }

            6 -> {
                if(order.isEmpty()){
                    println("장바구니가 비어있습니다.")
                    println("=====메뉴를 골라주세요")
                    continue
                }
                order.displayOrder()
                println("[ 장바구니 ]")
                println("${order.getTotalPrice()}" + won)
                println("1.  주문    2. 추가메뉴")
                print("주문하려면 1번 다른 메뉴를 보고 싶으면 2번을 눌러주세요: ")
                val orderChoice = scanner.nextInt()
                when (orderChoice) {
                    1 -> {
                        if (order.getTotalPrice() <= cash) {
                            cash -= order.getTotalPrice()
                            println("주문이 완료되었습니다. 현재 잔액은 $cash 원 입니다.")
                            order.clearOrder()
                        } else {
                            println("현재 잔액은 ${cash}원 으로 ${order.getTotalPrice() - cash}원이 부족하여 결제를 할 수 없습니다.")
                        }
                    }

                    2 -> continue
                    else -> println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }

        }
    }

}
