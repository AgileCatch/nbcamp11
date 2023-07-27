package com.example.kiosk

// 전역 변수로 토핑 옵션들을 리스트에 저장
val toppingOptions = listOf("펄", "화이트펄", "알로에", "코코넛", "밀크폼", "치즈폼")
// 사용자가 선택한 토핑들을 저장하는 리스트
val selectedToppings = mutableListOf<String>()

class ToppingOption {

    fun displayMenu() {
        // 현재 선택된 토핑들을 출력
        println("\n추가된 토핑: ${selectedToppings.joinToString(" ")}")
        // 토핑 옵션들을 출력
        println("1. 펄     | 500원")
        println("2. 화이트펄 | 500원")
        println("3. 알로에  | 500원")
        println("4. 코코넛  | 500원")
        println("5. 밀크폼  | 700원")
        println("6. 치즈폼  | 700원")
        println("0. 뒤로가기 ")
    }

    fun addTopping(toppingChoice: Int): Boolean {
        if (toppingChoice in 1..toppingOptions.size) {
            val selectedTopping = toppingOptions[toppingChoice - 1]
            if (selectedToppings.size < 3) {
                selectedToppings.add(selectedTopping)
                println("$selectedTopping 추가됨.")
            } else {
                println("\n\"최대 3개의 토핑까지 선택 가능합니다.\"")
            }
            return true
        } else if (toppingChoice == 0) {
            return true
        } else {
            println("잘못된 옵션 번호입니다.")
            return false
        }
    }

    fun getToppingOption(optionNumber: Int): String? {
        if (optionNumber in 1..toppingOptions.size) {
            return toppingOptions[optionNumber - 1]
        }
        return null
    }
}

