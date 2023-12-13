package com.example.mykioskproject

// 해당 경로에 있는 모든 클래스 가져오기
import com.example.mykioskproject.menu.*
import java.lang.NumberFormatException

class MainMenu{
    var basket = BasketMenu() //장바구니 메뉴 객체
    var menuCmd: Int = 0 //메뉴 커맨드 프로퍼티 초기화

    fun displayInfo(){ //메뉴 출력하는 메소드
        while(true){ //0번 눌러야만 탈출함
            /*==============================문구 출력==================================*/
            println("\n\"신선하고 좋은 재료로 건강하고 푸짐하게!\"\n맘스터치에 오신걸 환영합니다.")
            println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
            /*=============================문구 출력 끝=================================*/

            /*===========================메인메뉴 출력===============================*/
            println("\n[메뉴]\n1. 버거\n2. 치킨\n3. 맘스 세트\n4. 사이드\n5. 음료\n0. 종료")

            //장바구니에 뭔가가 들어있다면 주문 메뉴 띄우기
            if(basket.myList.size != 0) println("\n[주문 메뉴]\n6. 주문\n7. 취소")
            /*===========================메인메뉴 출력===============================*/

            menuCmd = cmdInput() //메뉴 선택하도록 입력 받음

            when(menuCmd){
                0 -> { //0을 입력하면
                    println("\n프로그램을 종료합니다.") //프로그램 종료 문자 출력
                    break // 반복문 종료
                }

                1 -> {
                    val burgersMenu = BurgersMenu()
                    burgersMenu.setList()
                    burgersMenu.displayInfo()

                    basket.addBasket(burgersMenu) //BurgersMenu 클래스 객체를 DetailMenu 클래스로 업캐스팅
                }

                2 -> {
                    val chickenMenu = ChickenMenu()
                    chickenMenu.setList()
                    chickenMenu.displayInfo()

                    basket.addBasket(chickenMenu) //ChickenMenu 클래스 객체를 DetailMenu 클래스로 업캐스팅
                }

                3->{
                    val setMenu = SetMenu()
                    setMenu.setList()
                    setMenu.displayInfo()

                    basket.addBasket(setMenu) //SetMenu 클래스 객체를 DetailMenu 클래스로 업캐스팅
                }

                4 -> {
                    val sideMenu = SideMenu()
                    sideMenu.setList()
                    sideMenu.displayInfo()

                    basket.addBasket(sideMenu) //SideMenu 클래스 객체를 DetailMenu 클래스로 업캐스팅
                }

                5 -> {
                    val drinksMenu = DrinksMenu()
                    drinksMenu.setList()
                    drinksMenu.displayInfo()

                    basket.addBasket(drinksMenu) //DrinksMenu 클래스 객체를 DetailMenu 클래스로 업캐스팅
                }

                6->{
                    if(basket.myList.size > 0){
                        basket.displayInfo()
                    }
                    else{
                        println("잘못된 번호를 입력했어요. 다시 입력해주세요.") //잘못된 입력이라고 출력
                        continue
                    }

                }

                7 ->{
                    if(basket.myList.size > 0){
                        basket.orderCancel()
                    }
                    else{
                        println("잘못된 번호를 입력했어요. 다시 입력해주세요.") //잘못된 입력이라고 출력
                        continue
                    }
                }

                else -> { //1에서 5번까지 혹은 1에서 7번까지가 아닐 경우
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요.") //잘못된 입력이라고 출력
                    continue
                }
            }
        }
    }

    fun cmdInput(): Int{ //intMenuCommend 프로퍼티를 입력받음
        var cmdInput: Int
        while(true){
            try{
                cmdInput = readln().toInt() //null을 받을 수 없는 문자열을 가져와서
                break
            }catch (e:NumberFormatException){
                println("숫자만 입력할 수 있어요. 다시 입력해주세요.")
            }
        }
        return cmdInput
    }
}
