package com.example.mykioskproject.menu

class DrinksMenu: DetailMenu(){ //DetailMenu 클래스를 상속받았음
    override fun setList() {  //음료수 메뉴를 등록하는 메소드
        myList.add(FoodData("콜라", 1600, "음료는 160z컵음료 혹은 355ml 캔음료로 제공됩니다."))
        myList.add(FoodData("펩시콜라제로", 1600, "음료는 160z컵음료 혹은 355ml 캔음료로 제공됩니다."))
        myList.add(FoodData("사이다", 1600, "음료는 160z컵음료 혹은 355ml 캔음료로 제공됩니다."))
        myList.add(FoodData("청포도에이드", 2200, "과일의 달콤함과 청량감을 그대로 담은 청포도에이드"))
    }

    override fun displayInfo() {  //등록된 음료수 메뉴를 출력하는 메소드
        println("\n[ 음료수 메뉴 ]")
        for((idx, data) in myList.withIndex()){
            println("${idx+1}. ${data.name}\t|\t${data.price}원\t|\t${data.explanation}")
        }
        println("0. 메인 메뉴로 돌아가기")
    }
}