package com.example.mykioskproject

// 해당 경로에 있는 모든 클래스 가져오기
import com.example.mykioskproject.menu.*

class MainMenu: PrintText(){ //PrintText를 상속받는 클래스
    var basket = BasketMenu() //장바구니 메뉴 객체
    private val dataInputClass = Input() //데이터 입력받는 클래스 객체
    var intMenuCommend = 0
    var escapeFlag = false //탈출할 건지 말건지 결정하는 플래그

    fun displayInfo(){ //메소드 오버로딩
        displayInfo(0) //소개문 출력
        while(true){
            displayInfo(1) //메인 메뉴 출력
            if(basket.myList.size != 0){ //장바구니에 뭔가가 들어있다면 주문 메뉴 띄우기
                displayInfo(2)
            }

            intMenuCommend = dataInputClass.getInput() //입력받은 정수 커맨드
            when(intMenuCommend){
                0 -> { //0을 입력했을 경우
                    displayInfo(-1) //프로그램 종료 문자 출력
                    break // 반복문 종료
                }

                1 -> {
                    val burgersMenu = BurgersMenu()
                    burgersMenu.setList()
                    burgersMenu.displayInfo()

                    addBasket(burgersMenu) //BurgersMenu 클래스 객체를 DetailMenu 클래스로 업캐스팅
                }

                2 -> {
                    val chickenMenu = ChickenMenu()
                    chickenMenu.setList()
                    chickenMenu.displayInfo()

                    addBasket(chickenMenu) //ChickenMenu 클래스 객체를 DetailMenu 클래스로 업캐스팅
                }

                3->{
                    val setMenu = SetMenu()
                    setMenu.setList()
                    setMenu.displayInfo()

                    addBasket(setMenu) //SetMenu 클래스 객체를 DetailMenu 클래스로 업캐스팅
                }

                4 -> {
                    val sideMenu = SideMenu()
                    sideMenu.setList()
                    sideMenu.displayInfo()

                    addBasket(sideMenu) //SideMenu 클래스 객체를 DetailMenu 클래스로 업캐스팅
                }

                5 -> {
                    val drinksMenu = DrinksMenu()
                    drinksMenu.setList()
                    drinksMenu.displayInfo()

                    addBasket(drinksMenu) //DrinksMenu 클래스 객체를 DetailMenu 클래스로 업캐스팅
                }

                6->{
                    if(basket.myList.size > 0){
                        basket.displayInfo()

                        intMenuCommend = dataInputClass.getInput() //입력받은 정수 커맨드
                        if(intMenuCommend==2) continue //0일 경우 반복
                    }
                    else{
                        displayInfo(3) //잘못된 입력이라고 출력
                        continue
                    }

                }

                7 ->{
                    if(basket.myList.size > 0){
                        basket.cancelInfo()

                        intMenuCommend = dataInputClass.getInput() //입력받은 정수 커맨드
                        if(intMenuCommend==2) continue //0일 경우 반복
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

    private fun addBasket(myMenu:DetailMenu){ //basket에 추가하는 과정 그냥 하나로 합침
        while(true){
            escapeFlag = false //탈출할 건지 말건지 결정하는 플래그

            val intMenuCommend = dataInputClass.getInput() //입력받은 정수 커맨드
            when(intMenuCommend){
                0 -> break //0입력받으면 메인메뉴로 가기

                in 1..myMenu.myList.size ->{ //1부터 메뉴 개수까지
                    println() //그냥 개행 해줌
                    val chickenList = myMenu.myList
                    chickenList[intMenuCommend-1].displayInfo() //선택한 메뉴 정보 출력

                    displayInfo(4) // 메뉴에 추가할 건지 물어보기

                    while(true){
                        when(dataInputClass.getInput()){ //입력받은 정수 커맨드
                            1->{
                                basket.myList.add(chickenList[intMenuCommend-1]) //장바구니 객체의 리스트에 마지막에 추가
                                println("\n${chickenList[intMenuCommend-1].name}(이)가 장바구니에 추가되었습니다.")
                                escapeFlag = true //장바구니에 추가하면 탈출
                                break
                            }
                            2 ->{
                                println("\n${chickenList[intMenuCommend-1].name}(을)를 장바구니에 넣지 않았습니다.")
                                escapeFlag = true //장바구니에 넣지 않아도 탈출
                                break
                            }
                            else -> {
                                displayInfo(3)
                                escapeFlag = false //입력 잘못하면 탈출 X
                                continue
                            }
                        }
                    }
                    if(escapeFlag) break
                }
                else ->{
                    displayInfo(3)
                    continue
                }
            }
        }

    }
}