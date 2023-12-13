package com.example.mykioskproject.menu

import com.example.mykioskproject.DetailMenu

class BasketMenu : DetailMenu(){ //DetailMenu 클래스를 상속받았음
    var cash = (1 .. 5).random() * 5000 //소지 금액은 5000에서 25000사이 랜덤한 값
    var sum = 0
    override fun displayInfo() { // 메뉴 주문할 때 사용하는 메소드
        sum = 0 //음식 가격 총합 저장할 변수
        println("\n아래와 같이 주문 하시겠습니까?")
        println("\n[ Orders ]")
        for(food in myList){
            food.displayInfo()
            sum += food.price //음식 가격 총합
        }
        println("\n[ Total ]")
        println("${sum}원 입니다.")

//        println("\n[ 현재 소지한 금액 ]")
//        println("${cash}원 입니다.")

        println("\n1.주문\t2.메뉴로 돌아가기")
    }

    fun cancelInfo() { // 메뉴 취소할 때 사용하는 메소드
        println("\n취소할 메뉴를 선택해주세요.")

        println("\n[ Orders ]")
        for((idx, food) in myList.withIndex()){
            print("${idx+1}. ")
            food.displayInfo()
        }
        println("0. 메인 메뉴로 돌아가기")
    }

    fun pay(){
        cash -= sum
    }
}