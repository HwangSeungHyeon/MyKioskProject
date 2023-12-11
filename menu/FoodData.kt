package com.example.mykioskproject.menu

open class FoodData(_name: String, _price: Int, _explanation: String) { // 버거, 치킨, 세트메뉴, 사이드메뉴, 음료수의 부모 클래스
    var name: String = _name //메뉴 이름 저장할 변수
    var price:Int = _price //메뉴 가격 저장할 변수
    var explanation : String = _explanation //메뉴 설명 저장할 변수

    open fun displayInfo(){
        println("\"${name}\t|\t${price}원\t|\t${explanation}\"")
    }
}