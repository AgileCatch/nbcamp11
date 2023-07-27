package com.example.kiosk

class Waiting {
    private val completedPayments = mutableListOf<String>()
    private var storeCurrentNumber = 0
    private var takeoutCurrentNumber = 0
    private var currentNumber = 0


    @Synchronized
    fun recordCompletedPayment(payment: String, store: Boolean) {
        completedPayments.add(payment)
        currentNumber++
        if (store) {
            storeCurrentNumber ++
        } else {
            takeoutCurrentNumber ++
        }
    }




    fun printWaitingNumber(store: Boolean) {

        if (store) {
            println("매장 결제 대기 번호표: $storeCurrentNumber")
        } else {
            println("대기 인원수: $currentNumber")
        }
    }


}