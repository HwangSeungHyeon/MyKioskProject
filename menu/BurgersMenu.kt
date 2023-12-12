package com.example.mykioskproject.menu

import com.example.mykioskproject.DetailMenu

class BurgersMenu : DetailMenu(){ //DetailMenu 클래스를 상속받았음
    override fun setList(){  //버거 메뉴를 등록하는 메소드
        myList.add(FoodData("싸이버거", 4600, "바삭하고 매콤한 치킨 패티와 신선한 양상추가 조화를 이루는 맘스터치 시그니처 버거"))
        myList.add(FoodData("싸이플렉스버거", 7700, "통다리살 싸이패티가 2장! 압도적 사이즈의 FLEX, 리얼 입찢버거 싸이플렉스버거"))
        myList.add(FoodData("인크레더블버거", 5700, "프리미엄 더블햄, 에그프라이, 통다리살 패티에 아삭아삭한 양상추와 양파까지, 풍성한 버거."))
        myList.add(FoodData("언빌리버블버거", 6200, "통새우, 에그프라이, 통가슴살 패티에 매콤한 스리라차 마요 소스를 더한 대확행 버거."))
    }

    override fun displayInfo() {  //등록된 버거 메뉴를 출력하는 메소드
        println("\n[ 버거 메뉴 ]")
        for((idx, data) in myList.withIndex()){
            println("${idx+1}. ${data.name}\t|\t${data.price}원\t|\t${data.explanation}")
        }
        println("0. 메인 메뉴로 돌아가기")
    }
}