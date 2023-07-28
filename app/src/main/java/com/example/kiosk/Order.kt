package com.example.kiosk

import kotlinx.coroutines.delay

class Order {
    private val orderList = ArrayList<Pair<MenuItem, String>>()
    private val additionalToppingsMap = mutableMapOf<MenuItem, List<String>>()

    fun addToOrder(
        item: MenuItem,
        options: String,
        payment: Payment,
        toppingOption: ToppingOption
    ) {
        orderList.add(item to options)
        println("\n\"${item.name}\"이(가) 장바구니에 추가 되었습니다.")
        println("선택한 옵션: $options")
        payment.updateMenuItemInfo(item, options)

        val additionalToppings = toppingOption.getSelectedToppings()
        if (additionalToppings.isNotEmpty()) {
            println("추가 토핑: $additionalToppings")
            additionalToppingsMap[item] = additionalToppings.split(", ")
            val toppingsPrice = toppingOption.getAdditionalToppingPrice()
            item.price += toppingsPrice
        } else {
            println("추가 토핑 없음")
        }
    }

    fun displayOrder() {
        if (orderList.isEmpty()) {
            println("\n장바구니가 비어있습니다.")
            println("=====메뉴를 선택해주세요=====")
        } else {
            println("\n[ | 장바구니 | ]")
            for ((menuItem, options) in orderList) {
                println("${menuItem.name}| ${menuItem.price}원 | 선택한 옵션: $options")

                val additionalToppings = additionalToppingsMap[menuItem]
                if (additionalToppings != null&& additionalToppings.isNotEmpty()) {
                    println("추가 토핑: ${additionalToppings.joinToString(", ")}")
                }
            }
        }
    }

    fun getTotalPrice(): Int {
        return orderList.sumOf { it.first.price }
    }

    suspend fun clearOrder(isCanceled: Boolean) {
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
