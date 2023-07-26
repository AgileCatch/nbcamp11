package com.example.kiosk

import kotlinx.coroutines.delay
import java.util.Date
import java.util.Locale

class Payment(private val order: Order) {
    private var paymentOption: String = ""
    private var couponCode: String = ""
    private var cashReceipt: String = ""
    private var paymentTime: Long = 0L


    suspend fun startPayment() {
        paymentTime = System.currentTimeMillis()
        println("\n\"총 결제 금액\"")
        println("결제 시간: ${formatTime(paymentTime)}")
        println("=========")
        println(" ${order.getTotalPrice()}원")
        println("1. 카드\n2. 쿠폰\n3. 현금 \n그 외 뒤로 가기\n결제 수단을 선택해주세요: ")
        val paymentChoice = readLine()?.toIntOrNull()
        delay(1000)


        when (paymentChoice) {
            1 -> {
                paymentOption = "카드"
                println("카드 투입구에 카드를 넣어주세요.")

            }
            2 -> {
                paymentOption = "쿠폰"
                println("\n쿠폰 번호를 8자리를 입력해주세요(취소하려면 1번을 눌려주세요):")
                inputCouponCode()
            }
            3 -> {
                paymentOption = "현금"
                println("현금 영수증을 발급하시겠습니까? \n1. 예\n2. 아니오 \n그 외 뒤로 가기")
                val cashReceipt = readLine()?.toIntOrNull()

                when(cashReceipt) {
                    1 -> {
                        println("1. 개인\n2. 사업자\n그 외 뒤로가기")
                        val cashReceipt2 = readLine()?.toIntOrNull()
                        when (cashReceipt2) {
                            1-> {
                                println("핸드폰번호를 입력해주세요.")
                                println("0 하나만 누르면 뒤로 돌아갑니다.")
                                val cashReceipt3 = readLine()?.toIntOrNull()
                                when (cashReceipt3) {
                                    0 -> return
                                    else -> {
                                        println("해당 번호로 현금영수증 하겠습니다.")

                                    }
                                }
                            }


                            2-> {
                                println("사업자번호를 입력해주세요.")
                                println("0 하나만 누르면 뒤로 돌아갑니다.")
                                val cashReceipt3 = readLine()?.toIntOrNull()
                                when (cashReceipt3) {
                                    0 -> return
                                    else -> {
                                        println("해당 번호로 현금영수증 하겠습니다.")

                                    }
                                }

                            }
                            else -> {
                                println("잘못된 선택입니다.")
                                return
                            }
                        }
                    }
                    2 -> {
                        println("결제 시간: ${formatTime(paymentTime)}")
                        println("결제가 완료되었습니다.")


                    }
                    else -> {
                        println("잘못된 선택입니다.")
                        return
                    }
                }
                showReceiptOption()
            }

            else -> {
                println("잘못된 선택입니다.")
                return
            }
        }


    }

    private fun inputCouponCode() {
        val input = readLine()
        when {
            input == "1" -> return
            input != null && input.matches(Regex("\\d{8}")) -> couponCode = input
            else -> {
                println("잘못된 양식입니다. 8자리 숫자로 다시 입력해주세요.")
                inputCouponCode()
            }
        }
    }

    private suspend fun showReceiptOption() {
        println("영수증을 발급하시겠습니까? \n1.예 \n2.아니오\n그 외 뒤로 가기")
        paymentTime = System.currentTimeMillis()

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
                    1 -> true to false
                    2 -> false to false
                    else -> {
                        println("잘못된 선택입니다.")
                    }
                }
            }
            2 -> {
                println("결제가 완료되었습니다.")
                println("1. 매장\n2. 포장\n3. 그 외 뒤로가기")
                val storeOption = readLine()?.toIntOrNull()
                when (storeOption) {
                    1 -> true to false
                    2 -> false to false
                    else -> {
                        println("잘못된 선택입니다.")
                    }
                }
            }
            else -> {
                println("잘못된 선택입니다.")
                return
            }
        }
    }


    private fun printReceipt() {
        paymentTime = System.currentTimeMillis()
        println("\"=====영수증=====\"")
        println("결제 시간: ${formatTime(paymentTime)}")

        println("결제 수단: $paymentOption")

        when (paymentOption) {
            "쿠폰" -> println("쿠폰 번호: $couponCode")
            "현금" -> println("현금 영수증 발급: ($cashReceipt)")
        }


    }

    private fun formatTime(timeInMillis: Long): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return dateFormat.format(Date(timeInMillis))
    }

    fun getPaymentDetails(): String {
        return paymentOption
    }
}