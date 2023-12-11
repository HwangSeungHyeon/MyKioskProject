package com.example.mykioskproject

// 해당 경로에 있는 모든 클래스 가져오기
import com.example.mykioskproject.menu.*

class MainMenu: PrintText(){ //PrintText를 상속받는 클래스
    var basket = BasketMenu() //장바구니 메뉴 객체
    private val dataInputClass = Input() //데이터 입력받는 클래스 객체

    fun displayInfo(){ //메소드 오버로딩
        var intMenuCommend = 0 //정수로 변환한 커맨드

        displayInfo(0) //소개문 출력
        while(true){
            displayInfo(1) //메인 메뉴 출력
            if(basket.myList.size != 0){ //장바구니에 뭔가가 들어있다면 주문 메뉴 띄우기
                displayInfo(2)
            }

            intMenuCommend = dataInputClass.getIntInput()

            when(intMenuCommend){
                0 -> { //0을 입력했을 경우
                    displayInfo(-1) //프로그램 종료 문자 출력
                    break // 반복문 종료
                }

                1 -> {
                    val burgersMenu = BurgersMenu()
                    burgersMenu.setList()
                    burgersMenu.displayInfo()

                    intMenuCommend = dataInputClass.getIntInput() //입력받은 정수 커맨드
                    when(intMenuCommend){
                        0 -> continue //메인 메뉴로 되돌아가기
                        in 1..burgersMenu.myList.size ->{ //1부터 메뉴 개수까지
                            println() //그냥 개행 해줌
                            val burgerList = burgersMenu.myList
                            burgerList[intMenuCommend-1].displayInfo() //선택한 메뉴 정보 출력

                            displayInfo(4) // 메뉴에 추가할 건지 물어보기

                            var tmpCommend = dataInputClass.getIntInput() //입력받은 정수 커맨드
                            when(tmpCommend){
                                1->{
                                    basket.myList.add(burgerList[intMenuCommend-1]) //장바구니 객체의 리스트에 마지막에 추가
                                    println("\n${burgerList[intMenuCommend-1].name}가 장바구니에 추가되었습니다.")
                                    continue
                                }
                                2 ->{
                                    println("\n${burgerList[intMenuCommend-1].name}를 장바구니에 넣지 않았습니다.")
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
                    if(basket.myList.size > 0){
                        basket.displayInfo()
                    }
                    else{
                        displayInfo(3) //잘못된 입력이라고 출력
                        continue
                    }

                }

                7 ->{
                    if(basket.myList.size > 0){
                        basket.cancelInfo()
                    }
                    else{
                        displayInfo(3) //잘못된 입력이라고 출력
                        continue
                    }
                }

                else -> { //1에서 5번까지 혹은 1에서 7번까지가 아닐 경우
                    displayInfo(3) //잘못된 입력이라고 출력
                    continue
                }
            }
        }
    }
}