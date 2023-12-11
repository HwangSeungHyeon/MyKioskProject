package com.example.mykioskproject.menu

import com.example.mykioskproject.DetailMenu
import com.example.mykioskproject.Input

class BasketMenu : DetailMenu(){
    override fun displayInfo() { // 메뉴 주문할 때 사용
        var sum = 0 //음식 가격 총합 저장할 변수
        println("\n아래와 같이 주문 하시겠습니까?")
        println("\n[ Orders ]")
        for(food in myList){
            food.displayInfo()
            sum += food.price //음식 가격 총합
        }
        println("\n[ Total ]")
        println("${sum}원 입니다.")

        println("\n1.주문\t2.메뉴로 돌아가기")
    }

    fun cancelInfo() { // 메뉴 취소할 때 사용
        println("\n취소할 메뉴를 선택해주세요.")

        println("\n[ Orders ]")
        for(food in myList){
            food.displayInfo()
        }

        println("\n1.취소할 메뉴 선택 \t2.메뉴로 돌아가기")
    }
}