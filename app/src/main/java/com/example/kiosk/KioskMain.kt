package com.example.kiosk

import androidx.core.graphics.green
import kotlinx.coroutines.delay
import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)
    val coffeeMenu = CoffeeMenu()
    val bestcomMenu = BestComMenu()
    val jewelryMenu = JewelryMenu()
    val milkTMenu = MilkTMenu()
    val originalTMenu = OriginalTMenu()
    val order = Order()

    println("현재 잔액을 입력하세요.")
    var cash = scanner.nextInt()
    val won = "원"

    while (true) {
        println("\n\"어서오세요. 공들여 맛있는 공차입니다.\"")
        println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요")
        println("[ 공차 메뉴 ]")
        println("1. 베스트 콤비네이션   | 공차 고객들이 즐겨찾는 티와 토핑의 환상의 조합")
        println("2. 오리지널 티       | 찻잎을 정성껏 우려낸 프리미엄 잎차 ")
        println("3. 밀크티           | 프리미엄 잎차에 부드러운 밀크를 넣은 공차의 No.1메뉴")
        println("4. 쥬얼리           | 쥬얼리가 기본으로 들어간 맛있는 밀크티")
        println("5. Coffee         | 프리미엄 잎차와 100% 아라비카 원두의 이색 만남")
        println("6. Order          | 장바구니를 확인 후 주문합니다.")
        println("7. Cancel         | 진행중인 주문을 취소합니다.")

        print("메뉴 선택:")
        val choice = scanner.nextInt()

        when (choice) {
            1 -> {
                bestcomMenu.displayMenu()
                print("선택 ")
                val bestcomChoice = scanner.nextInt()
                if (bestcomChoice == 0) continue
                val menuItem = bestcomMenu.getMenuItem(bestcomChoice)
                if (menuItem != null) {
                    order.addToOrder(menuItem)
                }else{
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }

            2 -> {
                originalTMenu.displayMenu()
                print("선택 ")
                val originalTChoice = scanner.nextInt()
                if(originalTChoice == 1) continue
                val menuItem = originalTMenu.getMenuItem(originalTChoice)
                if (menuItem != null) {
                    order.addToOrder(menuItem)
                } else {
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }
            3 -> {
                milkTMenu.displayMenu()
                print("선택 ")
                val milkTChoice = scanner.nextInt()
                if (milkTChoice == 1) continue
                val menuItem = milkTMenu.getMenuItem(milkTChoice)
                if (menuItem != null) {
                    order.addToOrder(menuItem)
                } else {
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }
            4 -> {
                jewelryMenu.displayMenu()
                print("선택 ")
                val jewerlryChoice = scanner.nextInt()
                if (jewerlryChoice == 1) continue
                val menuItem = jewelryMenu.getMenuItem(jewerlryChoice)
                if (menuItem != null) {
                    order.addToOrder(menuItem)
                } else {
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }
            5 -> {
                coffeeMenu.displayMenu()
                print("선택 ")
                val coffeeChoice = scanner.nextInt()
                if (coffeeChoice == 1) continue
                val menuItem = jewelryMenu.getMenuItem(coffeeChoice)
                if (menuItem != null) {
                    order.addToOrder(menuItem)
                } else {
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요")
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
                delay(1000)
                when (orderChoice) {
                    1 -> {
                        if (order.getTotalPrice() <= cash) {
                            cash -= order.getTotalPrice()
                            println("주문이 완료되었습니다.")
                            delay(1000)
                            println( "현재 잔액은 $cash 원 입니다.")
                            order.clearOrder()
                        } else {
                            println("현재 잔액은 ${cash}원 으로 ${order.getTotalPrice() - cash}원이 부족하여 결제를 할 수 없습니다.")
                        }
                    }

                    2 -> continue
                    else -> println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }
             7 ->{
                 println("주문을 종료합니다.")
                 return
             }

        }
    }

}
