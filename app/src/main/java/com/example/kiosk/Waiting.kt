package com.example.kiosk

class Waiting {
    private val completedPayments = mutableListOf<String>()
    private var storeCurrentNumber = 0
    private var takeoutCurrentNumber = 0


    fun recordCompletedPayment(payment: String, store: Boolean) {
        completedPayments.add(payment)
        if (store) {
            storeCurrentNumber += 1
        } else {
            takeoutCurrentNumber += 1
        }
    }


    fun printReceiptCount() {
        println("\n현재 결제 완료된 항목의 개수: ${completedPayments.size}")
    }

    fun printWaitingNumber(store: Boolean) {
        if (store) {
            println("매장 결제 대기 번호표: $storeCurrentNumber")
        } else {
            println("포장 결제 대기 번호표: $takeoutCurrentNumber")
        }
    }


}