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

                        while(true){
                            menuCmd = cmdInput() //입력받은 정수 커맨드
                            when(menuCmd){
                                2-> break
                                1 ->{
                                    if(basket.sum <= basket.cash){
                                        basket.pay()
                                        println("주문이 완료되었습니다.\n")
                                        basket.myList.clear() // 장바구니 비우기
                                        break
                                    }
                                    else{
                                        println("현재 잔액은 ${basket.cash}원으로 ${basket.sum-basket.cash}원이 부족해서 주문할 수 없습니다.")
                                        break
                                    }
                                }
                                else->{
                                    println("잘못된 번호를 입력했어요. 다시 입력해주세요.") //잘못된 입력이라고 출력
                                    continue
                                }
                            }
                        }
                    }
                    else{
                        println("잘못된 번호를 입력했어요. 다시 입력해주세요.") //잘못된 입력이라고 출력
                        continue
                    }

                }

                7 ->{
                    if(basket.myList.size > 0){
                        basket.cancelInfo()

                        while(true){
                            menuCmd = cmdInput() //입력받은 정수 커맨드
                            when(menuCmd){
                                0-> break
                                in 1..basket.myList.size ->{
                                    println("${basket.myList[menuCmd-1].name}(이)가 장바구니에서 제거되었습니다.")
                                    basket.myList.removeAt(menuCmd-1)
                                    break
                                }
                                else->{
                                    println("잘못된 번호를 입력했어요. 다시 입력해주세요.") //잘못된 입력이라고 출력
                                    continue
                                }
                            }
                        }
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

    private fun addBasket(myMenu:DetailMenu){ //basket에 추가하는 과정 그냥 하나로 합침
        var escapeFlag = true //메뉴에서 나올 건지 결정하는 플래그

        while(true){
            val bMenuCmd = cmdInput() //장바구니 넣을지 말지 결정하는 메뉴 커맨드
            when(bMenuCmd){
                0 -> break // 사용자가 0 입력하면 메인메뉴로 돌아감

                in 1..myMenu.myList.size ->{ // 1부터 메뉴 개수까지
                    println() //한줄 개행해줌
                    val foodList = myMenu.myList //메뉴 음식 목록(햄버거면 햄버거 목록, 치킨이면 치킨 목록)
                    foodList[bMenuCmd-1].displayInfo() //선택한 메뉴 정보 출력

                    // 메뉴에 추가할 건지 물어보기
                    println("위 메뉴를 장바구니에 추가하시겠습니까?")
                    println("1. 확인\t2. 취소")

                    while(true){
                        when(cmdInput()){ //입력받은 정수 커맨드
                            1->{
                                basket.myList.add(foodList[bMenuCmd-1]) //장바구니 객체의 리스트 마지막에 추가
                                println("\n${foodList[bMenuCmd-1].name}(이)가 장바구니에 추가되었습니다.")

                                break
                            }
                            2 ->{
                                println("\n${foodList[bMenuCmd-1].name}(을)를 장바구니에 넣지 않았습니다.")
                                break
                            }
                            else -> {
                                println("잘못된 번호를 입력했어요. 다시 입력해주세요.")
                                escapeFlag = false //입력 잘못하면 탈출 X
                                continue
                            }
                        }
                    }
                    if(escapeFlag) break //입력 잘못한 게 아니라면 통과됨
                }
                else ->{
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요.")
                    continue
                }
            }
        }
    }
}
