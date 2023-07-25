package com.example.kiosk

class Order {
    private val orderList = ArrayList<MenuItem>()

    fun addToOrder(item: MenuItem){
        orderList.add(item)
        println("${item.name}가 장바구니에 추가 되었습니다.")
    }

    fun displayOrder() {
        if (orderList.isEmpty()) {
            println("장바구니가 비어있습니다.")
            println("====메뉴를 선택해주세요====")
        } else {
            println("[ | 장바구니 | ]")
            for (item in orderList) {
                println("${item.name}   | ${item.price}  원  | ")
            }
        }
    }


    fun getTotalPrice(): Int{
        return orderList.sumOf { it.price }
    }

    fun clearOrder(){
        orderList.clear()
        println(" 주문이 완료되었습니다.")
    }

    fun isEmpty(): Boolean {
        return orderList.isEmpty()
    }
}