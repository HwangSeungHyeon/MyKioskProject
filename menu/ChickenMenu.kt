package com.example.mykioskproject.menu

class ChickenMenu : DetailMenu(){ //DetailMenu 클래스를 상속받았음
    override fun setList() {  //치킨 메뉴를 등록하는 메소드
        myList.add(FoodData("후라이드치킨", 16900, "싸이버거 스타일 케이준 양념레시피로 더 바삭하고 스파이시한 핫크리스피 치킨"))
        myList.add(FoodData("간장마늘치킨", 18900, "알싸한 마늘 향의 매콤함, 특제 간장소스의 단짠이 조화로운 치킨"))
        myList.add(FoodData("맘스양념치킨", 18900, "국내산 벌꿀이 함유된 매콤달콤 특제 양념소스로 꿀맛나는 엄마표 맘스양념치킨"))
        myList.add(FoodData("치즈뿌치(체다)", 18900, "체다치즈 고소함과 짭잘한 시즈닝이 중독적인 치킨"))
    }

    override fun displayInfo() {  //등록된 치킨 메뉴를 출력하는 메소드
        println("\n[ 치킨 메뉴 ]")
        for((idx, data) in myList.withIndex()){
            println("${idx+1}. ${data.name}\t|\t${data.price}원\t|\t${data.explanation}")
        }
        println("0. 메인 메뉴로 돌아가기")
    }
}