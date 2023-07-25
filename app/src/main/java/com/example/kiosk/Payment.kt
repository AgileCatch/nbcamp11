package com.example.kiosk

class Payment {
    private var paymentOption: String = ""
    private var couponCode: String = ""
    private var cashReceipt: String = ""

    fun startPayment() {
        println("장바구니 목록을 출력합니다.")
        printReceipt()
        println("결제 수단을 선택해주세요: 1. 카드, 2. 쿠폰, 3. 현금, 그 외 뒤로 가기")
        val paymentChoice = readLine()?.toIntOrNull()


        when (paymentChoice) {
            1 -> {
                paymentOption = "카드"
                println("카드 투입구에 카드를 넣어주세요.")
            }
            2 -> {
                paymentOption = "쿠폰"
                println("1. 뒤로 가기, 쿠폰 번호를 8자리를 입력해주세요:")
                inputCouponCode()
            }
            3 -> {
                paymentOption = "현금"
                println("현금 영수증을 발급하시겠습니까? 1. 예, 2. 아니오, 그 외 뒤로 가기")
                val cashReceipt = readLine()?.toIntOrNull()

                when(cashReceipt) {
                    1 -> {
                        println("1.개인, 2.사업자, 그 외 뒤로가기")
                        val cashReceipt2 = readLine()?.toIntOrNull()
                        when (cashReceipt2) {
                            1-> {}
                            2-> {}
                            else -> {
                                println("잘못된 선택입니다.")
                                return
                            }
                        }
                    }
                    2 -> {
                        println("결제가 완료되었습니다.")
                        showReceiptOption()
                    }
                    else -> {
                        println("잘못된 선택입니다.")
                        return
                    }
                }

            }

            else -> {
                println("잘못된 선택입니다.")
                return
            }
        }

        showReceiptOption()
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

    private fun showReceiptOption() {
        println("영수증을 발급하시겠습니까? (1.예, 2.아니오, 그 외 뒤로 가기)")

        val receiptOption = readLine()?.toIntOrNull()

        when (receiptOption) {
            1 -> {
                println("장바구니 목록을 출력합니다.")
                printReceipt()
            }
            2 -> {
                println("결제가 완료되었습니다.")
            }
            else -> {
                println("잘못된 선택입니다.")
                return
            }
        }
    }

    private fun printReceipt() {
        println("-영수증-")
        printReceipt()
        println("결제 수단: $paymentOption")

        when (paymentOption) {
            "쿠폰" -> println("쿠폰 번호: $couponCode")
            "현금" -> println("현금 영수증 발급: ($cashReceipt)")
        }


        println("장바구니 목록")
        // 장바구니 목록을 출력하는 코드
    }
}