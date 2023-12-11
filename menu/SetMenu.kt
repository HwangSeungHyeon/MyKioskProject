package com.example.mykioskproject.menu

import com.example.mykioskproject.DetailMenu

class SetMenu : DetailMenu(){

    override fun setList(){
        myList.add(FoodData("싸이버거 세트", 6900, "매콤한 통다리살 패티가 통째로~ 양파와 양상추가 조화를 이루는 맘스터치 시그니처 버거"))
        myList.add(FoodData("싸이플렉스버거 세트", 10000, "통다리살 싸이패티가 2장! 압도적 사이즈의 FLEX, 리얼 입찢버거 싸이플렉스버거"))
        myList.add(FoodData("인크레더블버거 세트", 8000, "에그프라이, 프리미엄 더블햄, 통다리살 패티에 신선한 양상추까지! 크고 확실한 행복을 즐길 수 있는 대확행 버거"))
        myList.add(FoodData("언빌리버블 세트", 8500, "통새우, 에그프라이, 통가슴살 패티에 매콤한 스리라차 마요 소스를 더한 대확행 버거."))
    }

    override fun displayInfo() {
        println("\n[ 세트 메뉴 ]")
        for((idx, data) in myList.withIndex()){
            println("${idx+1}. ${data.name}\t|\t${data.price}원\t|\t${data.explanation}")
        }
        println("0. 메인 메뉴로 돌아가기")
    }

}