package com.example.kiosk

class Waiting {
    private val completedPayments = mutableListOf<String>()
    private var storeCurrentNumber = 0
    private var takeoutCurrentNumber = 0


    @Synchronized
    fun recordCompletedPayment(payment: String, store: Boolean) {
        completedPayments.add(payment)
        if (store) {
            storeCurrentNumber++
        } else {
            takeoutCurrentNumber++
        }
    }
}



