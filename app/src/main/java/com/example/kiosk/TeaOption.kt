package com.example.kiosk

import java.util.Scanner

class TeaOption {
    var hotIceOption: String = "ICE"
    var iceLevelOption: String = "regular"
    var sweetnessOption: String = "50%"

    fun displayMenu() {
        println("\n현재옵션:${hotIceOption}/${sweetnessOption}/${iceLevelOption}\n옵션을 변경하려면 번호를 입력하세요.")
        println("1. ICE/HOT 설정")
        println("2. 당도 설정")
        println("3. 얼음량 설정")
        println("0. 뒤로가기")
    }

    fun setHotIceOption(optionChoice: Int) {
        println("\n음료 온도를 설정해 주세요.")
        println("1. HOT")
        println("2. ICE")
        val hotIceChoice = readOptionInput(1, 2)
        if (hotIceChoice == 1) {
            hotIceOption = "HOT"
            println("옵션이 변경되었습니다. 현재 옵션: $hotIceOption")
        } else if (hotIceChoice == 2) {
            hotIceOption = "ICE"
            println("옵션이 변경되었습니다. 현재 옵션: $hotIceOption")
        }
        displayMenu()
    }

    fun setIceLevelOption(optionChoice: Int) {
        println("\n얼음 옵션을 설정해 주세요.")
        println("1. less")
        println("2. regular")
        println("3. full")
        val iceLevelChoice = readOptionInput(1, 3)

        when (iceLevelChoice) {
            1 -> {
                iceLevelOption = "less"
                println("얼음 옵션이 변경되었습니다. 현재 옵션: $iceLevelOption")
            }
            2 -> {
                iceLevelOption = "regular"
                println("얼음 옵션이 변경되었습니다. 현재 옵션: $iceLevelOption")
            }
            3 -> {
                iceLevelOption = "full"
                println("얼음 옵션이 변경되었습니다. 현재 옵션: $iceLevelOption")
            }
        }
    }

    fun setSweetnessOption(optionChoice: Int) {
        println("\n당도를 설정해 주세요.")
        println("1. 0%")
        println("2. 30%")
        println("3. 50%")
        println("4. 70%")
        println("5. 100%")
        val sweetnessChoice = readOptionInput(1, 5)

        when (sweetnessChoice) {
            1 -> {
                sweetnessOption = "0%"
                println("당도가 변경되었습니다. 현재 당도: $sweetnessOption")
            }
            2 -> {
                sweetnessOption = "30%"
                println("당도가 변경되었습니다. 현재 당도: $sweetnessOption")
            }
            3 -> {
                sweetnessOption = "50%"
                println("당도가 변경되었습니다. 현재 당도: $sweetnessOption")
            }
            4 -> {
                sweetnessOption = "70%"
                println("당도가 변경되었습니다. 현재 당도: $sweetnessOption")
            }
            5 -> {
                sweetnessOption = "100%"
                println("당도가 변경되었습니다. 현재 당도: $sweetnessOption")
            }

        }
        displayMenu()
    }

    private fun readOptionInput(min: Int, max: Int): Int {
        var choice = -1
        val scanner = Scanner(System.`in`)
        while (choice !in min..max) {
            print("옵션 선택: ")
            choice = scanner.nextInt()
            if (choice !in min..max) {
                println("잘못된 번호를 입력했어요. 다시 입력해주세요")
            }
        }
        return choice
    }

    fun getOptions(): String {
        return "$hotIceOption/$sweetnessOption/$iceLevelOption"

    }
}
