package com.example.kiosk

class Order {
    private val orderList = ArrayList<MenuItem>()

    fun addToOrder(item: MenuItem){
        orderList.add(item)
        println("${item.name}가 장바구니에 추가 되었습니다.")
    }

    fun displayOrder(){
        println("[ Orders ]")
        for(item in orderList){
            println("${item.name}   | W ${item.price}  | ")
        }
    }

    fun getRotalPrice(): Int{
        return orderList.sumOf { it.price }
    }

    fun clearOrder(){
        orderList.clear()
        println(" 주문이 취소되었습니다.")
    }
}