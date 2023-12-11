package com.example.mykioskproject.menu

import com.example.mykioskproject.DetailMenu

class SideMenu : DetailMenu(){
    override fun setList() {
        myList.add(FoodData("콘샐러드", 1800, "달콤한 스위트콘에 신선한 야채가 어우러진 콘샐러드 치킨,버거와 곁들여 먹기 좋습니다."))
        myList.add(FoodData("케이준 양념감자", 2000, "케이준 스타일의 바삭한 양념감자, 맘스터치의 베스트 사이드 메뉴"))
        myList.add(FoodData("치즈감자", 2900, "케이준 양념감자와 깊고 진한 딥치즈 소스를 함께 즐길 수 있는 치즈감자"))
        myList.add(FoodData("할라피뇨너겟", 2000, "콕콕 박힌 할라피뇨로 매콤하게 즐기는 할라피뇨 너겟"))
    }

    override fun displayInfo() {
        println("\n[ 사이드 메뉴 ]")
        for((idx, data) in myList.withIndex()){
            println("${idx+1}. ${data.name}\t|\t${data.price}원\t|\t${data.explanation}")
        }
        println("0. 메인 메뉴로 돌아가기")
    }
}