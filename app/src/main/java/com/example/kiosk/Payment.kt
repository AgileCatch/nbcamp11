package com.example.kiosk

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.LocalTime
import kotlinx.coroutines.delay

class Payment(private val order: Order, private val waiting: Waiting) {
    private var paymentOption: String = ""
    private var couponCode: String = ""
    private var currentNumber = 0
    private var selectedMenu: MenuItem? = null
    private var selectedOptions: String = ""
    private val blockedPayStartTime = LocalTime.of(13, 0) // 결제 가능 시작 시간
    private val blockedPayEndTime = LocalTime.of(14, 0)   // 결제 가능 종료 시간

    fun isPaymentAllowed(): Boolean {
        val now = LocalTime.now()
        return now < blockedPayStartTime || now >= blockedPayEndTime
    }





    suspend fun startPayment() {
        var goBack = true
        while (goBack) {
            println("\n\"총 결제 금액\"")
            println("=========")
            println(" ${order.getTotalPrice()}원")
            println("1. 카드\n2. 쿠폰\n3. 현금 \n그 외 뒤로 가기\n결제 수단을 선택해주세요: ")
            val paymentChoice = readLine()?.toIntOrNull()
            delay(1000)


            when (paymentChoice) {
                1 -> {
                    paymentOption = "카드"
                    println("카드 투입구에 카드를 넣어주세요.")
                    selectedMenu?.let {order.addToOrder(it, selectedOptions, this) }
                    showReceiptOption()
                    goBack = false
                }

                2 -> {
                    paymentOption = "쿠폰"
                    while (true) {
                        println("\n쿠폰 번호를 8자리를 입력해주세요(취소하려면 1번을 눌려주세요):")
                        val input = readLine()
                        if (input == "1") {
                            goBack = true
                            break
                        } else if (input != null && input.matches(Regex("\\d{8}"))) {
                            couponCode = input

                            println("쿠폰이 등록되었습니다.")
                            showReceiptOption()
                            goBack = false
                            break


                        } else {
                            println("잘못된 양식입니다. 8자리 숫자로 다시 입력해주세요.")
                        }
                    }

                }

                3 -> {
                    paymentOption = "현금"
                    println("현금 영수증을 발급하시겠습니까? \n1. 예\n2. 아니오 \n그 외 뒤로 가기")
                    val cashReceipt = readLine()?.toIntOrNull()

                    when (cashReceipt) {
                        1 -> {
                            println("1. 개인\n2. 사업자\n그 외 뒤로가기")
                            val cashReceipt2 = readLine()?.toIntOrNull()
                            when (cashReceipt2) {
                                1 -> {
                                    println("핸드폰번호를 입력해주세요.")
                                    println("0 하나만 누르면 뒤로 돌아갑니다.")
                                    val cashReceipt3 = readLine()?.toIntOrNull()
                                    when (cashReceipt3) {
                                        0 -> goBack = true
                                        else -> {
                                            println("해당 번호로 현금영수증 하겠습니다.")
                                            showReceiptOption()
                                            goBack = false

                                        }
                                    }
                                }


                                2 -> {
                                    println("사업자번호를 입력해주세요.")
                                    println("0 하나만 누르면 뒤로 돌아갑니다.")
                                    val cashReceipt3 = readLine()?.toIntOrNull()
                                    when (cashReceipt3) {
                                        0 -> goBack = true
                                        else -> {
                                            println("해당 번호로 현금영수증 하겠습니다.")
                                            showReceiptOption()
                                            goBack = false

                                        }
                                    }

                                }

                                else -> {
                                    println("잘못된 선택입니다.")
                                    goBack = true
                                }
                            }
                        }

                        2 -> {
                            println("결제가 완료되었습니다.")
                            showReceiptOption()
                            goBack = false


                        }

                        else -> {
                            println("잘못된 선택입니다.")
                            goBack = true
                        }
                    }

                }

                else -> {
                    println("잘못된 선택입니다.")
                    goBack = true
                }
            }

        }
        }

         suspend fun showReceiptOption() {
            println("영수증을 발급하시겠습니까? \n1.예 \n2.아니오\n그 외 뒤로 가기")

            val receiptOption = readLine()?.toIntOrNull()

            when (receiptOption) {
                1 -> {

                    printReceipt()
                    print("결제금액 : ")
                    println("${order.getTotalPrice()}")
                    delay(1000)
                    println("1. 매장 \n2. 포장 \n3. 그 외 뒤로가기")
                    val storeOption = readLine()?.toIntOrNull()
                    when (storeOption) {
                        1 -> {
                            printWaitingNumberForStore()
                            waiting.recordCompletedPayment(getPaymentDetails(), true)
                            currentNumber++
                            return
                        }

                        2 -> {
                            printWaitingNumberForTakeout()
                            waiting.recordCompletedPayment(getPaymentDetails(), false)
                            currentNumber++
                            return

                        }
                        else -> {
                            println("잘못된 선택입니다.")
                            return
                        }
                    }
                }

                2 -> {
                    println("결제가 완료되었습니다.")
                    println("1. 매장\n2. 포장\n3. 그 외 뒤로가기")
                    val storeOption = readLine()?.toIntOrNull()
                    when (storeOption) {
                        1 -> {
                            printWaitingNumberForStore()
                            waiting.recordCompletedPayment(getPaymentDetails(), true)
                            currentNumber++
                            return
                        }
                        2 -> {
                            printWaitingNumberForTakeout()
                            waiting.recordCompletedPayment(getPaymentDetails(), false)
                            currentNumber++
                            return
                        }
                        else -> {
                            println("잘못된 선택입니다.")
                            return
                        }
                    }
                }

                else -> {
                    println("잘못된 선택입니다.")
                }
            }
        }


        private fun printReceipt() {
            println("\"=====영수증=====\"")
            println("${selectedMenu?.name}| ${selectedMenu?.price}원 | 선택한 옵션: $selectedOptions")

            println("결제 수단: $paymentOption")

            when (paymentOption) {
                "쿠폰" -> println("쿠폰 번호: $couponCode")
                "현금" -> println("현금 영수증 발급: (${selectedMenu?.price})")
            }


        }

        fun getPaymentDetails(): String {
            return paymentOption
        }
    fun printWaitingNumberForStore() {
        println("매장 결제 대기 번호표: ${currentNumber + 100}")
    }
    fun printWaitingNumberForTakeout() {
        println("포장 결제 대기 번호표: ${currentNumber + 200}")
    }

    fun getCurrentNumber(): Int {
        return currentNumber
    }
    fun updateMenuItemInfo(item: MenuItem, options: String) {
        selectedMenu = item
        selectedOptions = options
    }

    private var paymentTime: LocalDateTime? = null
    fun completePayment() {
        paymentTime = LocalDateTime.now()
    }

    fun printPaymentTime() {
        paymentTime?.let {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            val formattedTime = it.format(formatter)
            println("결제 완료 시간: $formattedTime")
        } ?: println("결제가 완료되지 않았습니다.")
    }


    }
