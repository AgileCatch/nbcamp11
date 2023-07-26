package com.example.kiosk

interface Menu {
    fun displayMenu()
    fun getMenuItem(index: Int): MenuItem?
}