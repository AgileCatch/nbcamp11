package com.example.kiosk

import kotlinx.coroutines.delay
import java.util.Scanner


suspend fun main() {
    val scanner = Scanner(System.`in`)
    val teaOption = TeaOption()
    val toppingOpion = ToppingOpion()
    val menus = listOf(BestComMenu(),OriginalTMenu(),MilkTMenu(), JewelryMenu(), CoffeeMenu())
    val order = Order()
    val payment = Payment(order)
    val waiting = Waiting()

    println("\n\"어서오세요. 공들여 맛있는 공차입니다.\"")


    while (true) {

        println("\n아래 메뉴판을 보시고 메뉴를 골라 입력해주세요")
        println("[ 공차 메뉴 ]")
        println("1. 베스트 콤비네이션   | 공차 고객들이 즐겨찾는 티와 토핑의 환상의 조합")
        println("2. 오리지널 티       | 찻잎을 정성껏 우려낸 프리미엄 잎차")
        println("3. 밀크티           | 프리미엄 잎차에 부드러운 밀크를 넣은 공차의 No.1메뉴")
        println("4. 쥬얼리           | 쥬얼리가 기본으로 들어간 맛있는 밀크티")
        println("5. Coffee         | 프리미엄 잎차와 100% 아라비카 원두의 이색 만남")
        println("6. Order          | 장바구니를 확인 후 주문합니다.")
        println("7. Cancel         | 진행중인 주문을 취소합니다.")

        print("메뉴 선택:")
        val choice = scanner.nextInt()


        when (choice) {
            in 1..menus.size -> {
                val selectedMenu = menus[choice - 1]
                selectedMenu.displayMenu()
                print("음료 선택:")
                val menuChoice = scanner.nextInt()
                if (menuChoice == 0) continue
                val menuItem = selectedMenu.getMenuItem(menuChoice)
                if (menuItem != null) {
                    teaOption.displayMenu()
                    toppingOpion.displaymenu2()
                    print("옵션 선택:")
                    while (true) {
                        val optionChoice = scanner.nextInt()
//                        teaOption.displayMenu()

                        when (optionChoice) {
                            0 -> break //0을 누르면 메뉴판으로 감
                            1 -> teaOption.setHotIceOption(optionChoice)
                            2 -> teaOption.setSweetnessOption(optionChoice)
                            3 -> teaOption.setIceLevelOption(optionChoice)
                            4 ->   {
                                toppingOpion.displayMenu1(optionChoice)
                                print("토핑 선택:")
                                val toppingChoice = scanner.nextInt()
                                if (toppingChoice == 0) continue
                                if (toppingChoice == toppingOpion.selectedToppings1.size + 1) {
                                    toppingOpion.displayMenu1(optionChoice)
                                    print("추가 토핑 선택:")
                                    val additionalToppingChoice = scanner.nextInt()
                                    if (additionalToppingChoice == 0) continue
                                    val additionalToppingItem = toppingOpion.getMenuItem1(additionalToppingChoice)
                                    if (additionalToppingItem != null) {
                                        if (toppingOpion.selectTopping1(additionalToppingItem)) {
                                            println("${additionalToppingItem.name} 토핑이 추가되었습니다.")
                                        }
                                    } else {
                                        println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                                    }
                                } else {
                                    val toppingItem = toppingOpion.getMenuItem1(toppingChoice)
                                    if (toppingItem != null) {
                                        if (toppingOpion.selectTopping1(toppingItem)) {
                                            println("${toppingItem.name} 토핑이 추가되었습니다.")
                                        }
                                    } else {
                                        println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                                    }
                                }
                            }
                            else -> {
                                println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                                continue
                            }
                        }
                        if (optionChoice == 3) {
                            break
                        }
                    }
                    order.addToOrder(menuItem, options = teaOption.getOptions())
                } else {
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }
            6 -> {
                if (order.isEmpty()) {
                    println("장바구니가 비어있습니다.")
                    println("=====메뉴를 골라주세요=====")
                    continue
                }
                order.displayOrder()
                print("\n결제금액 :")
                println("${order.getTotalPrice()}원")
                println("1. 주문\n2. 메뉴추가")
                println("주문하려면 1번 다른 메뉴를 보고 싶으면 2번을 눌러주세요: ")
                val orderChoice = scanner.nextInt()
                delay(1000)
                when (orderChoice) {
                    1 -> {
                        payment.startPayment()
                        delay(2000)
                        waiting.recordCompletedPayment(payment.getPaymentDetails())
                        waiting.printWaitingNumber(false)
                        waiting.printReceiptCount()
                        order.clearOrder(false)
                    }
                    2 -> continue
                    else -> println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }
            7 -> {
                println("진행중인 주문이 취소되었습니다.")
                order.clearOrder(true)
                continue
            }
            else -> {
                println("잘못된 번호를 입력했어요. 다시 입력해주세요")
            }
        }
    }
}