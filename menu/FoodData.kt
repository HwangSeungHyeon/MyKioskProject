package com.example.mykioskproject.menu

// 음식 데이터를 저장할 클래스 선언
class FoodData(_name: String, _price: Int, _explanation: String) {
    var name: String = _name //메뉴 이름 저장할 변수
    var price:Int = _price //메뉴 가격 저장할 변수
    var explanation : String = _explanation //메뉴 설명 저장할 변수

    fun displayInfo(){
        println("${name}\t|\t${price}원\t|\t${explanation}")
    }
}