package com.example.kiosk

class TeaOption {
    var hotIceOption: String = "hot"
    var iceLevelOption: String = "regular"
    var sweetnessOption: String = "10%"

    fun displayMenu() {
        println("1. 온도 설정")
        println("2. 당도 설정")
        println("3. 얼음 설정")
        println("0. 뒤로가기")
    }

    fun setHotIceOption(option: Int) {
        println("음료 온도를 설정해 주세요.")
        println("1. hot")
        println("2. ice")
        if (option == 1) {
            hotIceOption = "hot"
            println("옵션이 변경되었습니다. 현재 옵션: $hotIceOption")
        } else if (option == 2) {
            hotIceOption = "ice"
            println("옵션이 변경되었습니다. 현재 옵션: $hotIceOption")
            println("현재 얼음 옵션 : $iceLevelOption")
        } else {
            println("잘못된 옵션입니다. '1' 또는 '2' 중에서 선택해주세요.")
        }
    }

    fun setIceLevelOption(level: Int) {
        println("얼음 옵션을 설정해 주세요.")
        println("1. less")
        println("2. regular")
        println("3. full")

        if (level == 1) {
            iceLevelOption = "less"
            println("얼음 옵션이 변경되었습니다. 현재 옵션: $iceLevelOption")
        } else if (level == 2) {
            iceLevelOption = "regular"
            println("얼음 옵션이 변경되었습니다. 현재 옵션: $iceLevelOption")
        } else if (level == 3) {
            iceLevelOption = "full"
            println("얼음 옵션이 변경되었습니다. 현재 옵션: $iceLevelOption")
        } else {
            println("잘못된 옵션입니다. '1', '2', '3' 중에서 선택해주세요.")
        }
    }


    fun setSweetnessOption(sweetness: Int) {
        println("당도를 설정해 주세요.")
        println("1. 0%")
        println("2. 30%")
        println("3. 50%")
        println("4. 70%")
        println("5. 100%")

        if (sweetness == 1) {
            sweetnessOption = "0%"
            println("당도가 변경되었습니다. 현재 당도: $sweetnessOption")
        } else if (sweetness == 2) {
            sweetnessOption = "30%"
            println("당도가 변경되었습니다. 현재 당도: $sweetnessOption")
        } else if (sweetness == 3) {
            sweetnessOption = "50%"
            println("당도가 변경되었습니다. 현재 당도: $sweetnessOption")
        }
        else if (sweetness == 4) {
            sweetnessOption = "70%"
            println("당도가 변경되었습니다. 현재 당도: $sweetnessOption")
        }
        else if (sweetness == 5) {
            sweetnessOption = "100%"
            println("당도가 변경되었습니다. 현재 당도: $sweetnessOption")
        }
        else {
            println("잘못된 옵션입니다. '1', '2', '3', '4,', '5' 중에서 선택해주세요.")
        }
    }

}
