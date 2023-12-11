package com.example.mykioskproject

// 해당 경로에 있는 모든 클래스 가져오기
import com.example.mykioskproject.menu.*

class SelectMenu: DisplayMenu(){ //DisplayMenu를 상속받는 클래스
    var basket = ArrayList<Any>() //장바구니 역할로 다른 객체 저장할 리스트

    private val dataInputClass = Input() //데이터 입력받는 클래스 객체

    fun selectMainMenu(){
        var commend = "" //커맨드 입력받을 변수
        var intCommend = 0

        displayInfo(0) //소개문 출력
        while(true){
            displayInfo(1) //메인 메뉴 출력
            if(basket.size != 0){ //장바구니에 뭔가가 들어있다면 주문 메뉴 띄우기
                displayInfo(2)
            }
            commend = dataInputClass.input() ?: continue //입력한 값이 null이 아니면 입력한 값 대입, null이면 continue
            intCommend = commend.toInt()
            when(intCommend){
                0 -> {
                    println("\n프로그램을 종료합니다.")
                    break
                }

                1 -> {
                    val burgersMenu = BurgersMenu()
                    burgersMenu.setList()
                    burgersMenu.displayInfo()

                    commend = dataInputClass.input() ?: continue //입력한 값이 null이 아니면 입력한 값 대입, null이면 continue
                    intCommend = commend.toInt()
                    when(intCommend){
                        0 -> continue //메인 메뉴로 되돌아가기
                        in 1..burgersMenu.myList.size -> {

                            var burgerList = burgersMenu.myList
                            burgerList[intCommend-1].displayInfo()

                            println("위 메뉴를 장바구니에 추가하시겠습니까?")
                            println("1. 확인\t2. 취소")
                            var tmpCommend = dataInputClass.input() ?: continue //입력한 값이 null이 아니면 입력한 값 대입, null이면 continue
                            when(tmpCommend.toInt()){
                                1 -> {
                                    basket.add(burgerList[intCommend-1])
                                    println("${burgerList[intCommend-1].name}가 장바구니에 추가되었습니다.")
                                }
                                2 ->{
                                    println("${burgerList[intCommend-1].name}를 장바구니에 넣지 않았습니다.")
                                    continue
                                }
                            }
                        }
                    }
                }

                2 -> {
                    val chickenMenu = ChickenMenu()
                    chickenMenu.setList()
                    chickenMenu.displayInfo()
                }

                3->{
                    val setMenu = SetMenu()
                    setMenu.setList()
                    setMenu.displayInfo()
                }

                4 -> {
                    val sideMenu = SideMenu()
                    sideMenu.setList()
                    sideMenu.displayInfo()

                }

                5 -> {
                    val drinksMenu = DrinksMenu()
                    drinksMenu.setList()
                    drinksMenu.displayInfo()
                }

                6->{
                    if(basket.size > 0){
                        println("")
                    }
                    else{
                        println("\n지원하지 않는 기능입니다.\n")
                        continue
                    }

                }

                7 ->{
                    if(basket.size > 0){
                        println("")
                    }
                    else{
                        println("\n지원하지 않는 기능입니다.\n")
                        continue
                    }
                }

                else -> {
                    println("\n지원하지 않는 기능입니다.\n")
                    continue
                }
            }
        }
    }
}