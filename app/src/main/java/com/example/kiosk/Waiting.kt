package com.example.kiosk

class Waiting {
    private val completedPayments = mutableListOf<String>()
    private var currentNumber = 0

    fun recordCompletedPayment(payment: String) {
        completedPayments.add(payment)
    }

    fun printReceiptCount() {
        println("현재 결제 완료된 항목의 개수: ${completedPayments.size}")
    }

    fun printWaitingNumber(store: Boolean) {
        if (store) {
            println("매장 결제 대기 번호표: $currentNumber")
        } else {
            currentNumber += 1
            println("포장 결제 대기 번호표: $currentNumber")
        }
    }
}