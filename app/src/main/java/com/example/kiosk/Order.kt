package com.example.kiosk

import kotlinx.coroutines.delay

class Order {
    private val orderList = ArrayList<Triple<MenuItem, String, List<String>>>()
    //토핑가격추가
    private val toppingPrice = mapOf(
        "펄" to 500,
        "화이트펄" to 500,
        "알로에" to 500,
        "코코넛" to 500,
        "밀크폼" to 700,
        "치즈폼" to 700
    )

    fun addToOrder(item: MenuItem, options: String, payment: Payment,toppings: List<String>){
        orderList.add(Triple(item, options, toppings))
        val totalPrice = item.price + toppings.sumOf { toppingPrice[it] ?: 0 }
        println("\n\"${item.name}\"이(가) 장바구니에 추가 되었습니다.")
        println("선택한 옵션: $options")
        println("선택한 토핑: ${toppings.joinToString(", ")}")
        println("총 가격: ${totalPrice}원")
        payment.updateMenuItemInfo(item, options)
    }

    fun displayOrder() {
        if (orderList.isEmpty()) {
            println("\n장바구니가 비어있습니다.")
            println("=====메뉴를 선택해주세요=====")
        } else {
            println("\n[ | 장바구니 | ]")
            for ((menuItem, options,toppings) in orderList) {
                val totalPrice = menuItem.price + toppings.sumOf { toppingPrice[it] ?: 0 }
                println("${menuItem.name}| ${totalPrice}원 | 선택한 옵션: $options | 선택한 토핑: ${toppings.joinToString(", ")}")

            }
        }
    }


    //토핑가격추가후 총가격 계산
    fun getTotalPrice(): Int {
        return orderList.sumOf { order ->
            val itemPrice = order.first.price
            val toppingPrices = order.third.sumOf { toppingPrice[it] ?: 0 }
            itemPrice + toppingPrices
        }
    }

    suspend fun clearOrder(isCanceled: Boolean){
        orderList.clear()
        if (!isCanceled) {
            println("\"주문이 완료되었습니다.\"")
            delay(2000)
            println("\"결제가 완료되었습니다.\"")
        }
    }

    fun isEmpty(): Boolean {
        return orderList.isEmpty()
    }
}