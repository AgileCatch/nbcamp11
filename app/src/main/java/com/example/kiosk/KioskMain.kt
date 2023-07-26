package com.example.kiosk

import kotlinx.coroutines.delay
import java.util.Scanner


suspend fun main() {
    val scanner = Scanner(System.`in`)
    val teaOption = TeaOption()
    val coffeeMenu = CoffeeMenu()
    val bestcomMenu = BestComMenu()
    val jewelryMenu = JewelryMenu()
    val milkTMenu = MilkTMenu()
    val originalTMenu = OriginalTMenu()
    val order = Order()
    val payment = Payment(order)
    val waiting = Waiting()

    println("\n\"어서오세요. 공들여 맛있는 공차입니다.\"")


    while (true) {
//        println("\n\"어서오세요. 공들여 맛있는 공차입니다.\"")
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

            1 -> {
                bestcomMenu.displayMenu()
                print("선택 ")
                val bestcomChoice = scanner.nextInt()
                if (bestcomChoice == 0) continue
                val menuItem = bestcomMenu.getMenuItem(bestcomChoice)
                if (menuItem != null) {
                    teaOption.displayMenu()
                    print("음료의 옵션을 선택해주셔요:")
                    while (true) {
                        val optionChoice = scanner.nextInt()
                        teaOption.displayMenu()

                        when (optionChoice) {

                            0 -> break //0을 누르면 메뉴판으로 감
                            1 -> teaOption.setHotIceOption(optionChoice)
                            2 -> teaOption.setSweetnessOption(optionChoice)
                            3 -> teaOption.setIceLevelOption(optionChoice)
                            else -> println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                        }
                    }
                    order.addToOrder(menuItem, options = teaOption.getOptions())

                } else if (bestcomChoice != 0) {
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }

            2 -> {
                originalTMenu.displayMenu()
                print("선택 ")
                val originalTChoice = scanner.nextInt()
                if (originalTChoice == 0) continue
                val menuItem = originalTMenu.getMenuItem(originalTChoice)
                if (menuItem != null) {
                    teaOption.displayMenu()
                    print("음료의 옵션을 선택해주셔요:")
                    while (true) {
                        val optionChoice = scanner.nextInt()
                        teaOption.displayMenu()

                        when (optionChoice) {

                            0 -> break //0을 누르면 메뉴판으로 감
                            1 -> teaOption.setHotIceOption(optionChoice)
                            2 -> teaOption.setSweetnessOption(optionChoice)
                            3 -> teaOption.setIceLevelOption(optionChoice)
                            else -> println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                        }
                    }
                    order.addToOrder(menuItem, options = teaOption.getOptions())
                } else if (originalTChoice != 0) {
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }

            3 -> {
                milkTMenu.displayMenu()
                print("선택 ")
                val milkTChoice = scanner.nextInt()
                if (milkTChoice == 0) continue
                val menuItem = milkTMenu.getMenuItem(milkTChoice)
                if (menuItem != null) {
                    teaOption.displayMenu()
                    print("음료의 옵션을 선택해주셔요:")
                    while (true) {
                        val optionChoice = scanner.nextInt()
                        teaOption.displayMenu()

                        when (optionChoice) {

                            0 -> break //0을 누르면 메뉴판으로 감
                            1 -> teaOption.setHotIceOption(optionChoice)
                            2 -> teaOption.setSweetnessOption(optionChoice)
                            3 -> teaOption.setIceLevelOption(optionChoice)
                            else -> println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                        }
                    }
                    order.addToOrder(menuItem, options = teaOption.getOptions())
                } else if (milkTChoice != 0) {
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }

            4 -> {
                jewelryMenu.displayMenu()
                print("선택 ")
                val jewerlryChoice = scanner.nextInt()
                if (jewerlryChoice == 0) continue
                val menuItem = jewelryMenu.getMenuItem(jewerlryChoice)
                if (menuItem != null) {
                    teaOption.displayMenu()
                    print("음료의 옵션을 선택해주셔요:")
                    while (true) {
                        val optionChoice = scanner.nextInt()
                        teaOption.displayMenu()

                        when (optionChoice) {

                            0 -> break //0을 누르면 메뉴판으로 감
                            1 -> teaOption.setHotIceOption(optionChoice)
                            2 -> teaOption.setSweetnessOption(optionChoice)
                            3 -> teaOption.setIceLevelOption(optionChoice)
                            else -> println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                        }
                    }
                    order.addToOrder(menuItem, options = teaOption.getOptions())
                } else if (jewerlryChoice != 0) {
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }

            5 -> {
                coffeeMenu.displayMenu()
                print("선택 ")
                val coffeeChoice = scanner.nextInt()
                if (coffeeChoice == 0) continue
                val menuItem = coffeeMenu.getMenuItem(coffeeChoice)
                if (menuItem != null) {
                    teaOption.displayMenu()
                    print("음료의 옵션을 선택해주셔요:")
                    while (true) {
                        val optionChoice = scanner.nextInt()
                        teaOption.displayMenu()

                        when (optionChoice) {

                            0 -> break //0을 누르면 메뉴판으로 감
                            1 -> teaOption.setHotIceOption(optionChoice)
                            2 -> teaOption.setSweetnessOption(optionChoice)
                            3 -> teaOption.setIceLevelOption(optionChoice)
                            else -> println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                        }
                    }
                    order.addToOrder(menuItem, options = teaOption.getOptions())
                } else if (coffeeChoice != 0) {
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }

            6 -> {
                if (order.isEmpty()) {
                    println("장바구니가 비어있습니다.")
                    println("=====메뉴를 골라주세요")
                    continue
                }
                order.displayOrder()
                print("결제금액 :")
                println("${order.getTotalPrice()}원")
                println("1. 주문    2. 메뉴추가")
                print("주문하려면 1번 다른 메뉴를 보고 싶으면 2번을 눌러주세요: ")
                val orderChoice = scanner.nextInt()
                delay(1000)
                when (orderChoice) {
                    1 -> {
                        payment.startPayment()
                        delay(2000)
                        waiting.recordCompletedPayment(payment.getPaymentDetails())
                        waiting.printWaitingNumber(false)
                        waiting.printReceiptCount()
                        order.clearOrder()
                    }

                    2 -> continue
                    else -> println("잘못된 번호를 입력했어요. 다시 입력해주세요")
                }
            }


            7 -> {

                // 취소를 누르면 메뉴판으로 돌아가기
//                order.clearOrder()
                println("진행중인 주문이 취소되었어요.")
                continue

            }


        }
    }

}


