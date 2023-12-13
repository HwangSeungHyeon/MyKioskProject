package com.example.mykioskproject.menu

import com.example.mykioskproject.DetailMenu

class BasketMenu : DetailMenu(){ //DetailMenu 클래스를 상속받았음
    var cash = (1 .. 5).random() * 5000 //소지 금액은 5000에서 25000사이 랜덤한 값
    var sum = 0
    var menuCmd = 0
    override fun displayInfo() { // 메뉴 주문할 때 사용하는 메소드
        sum = 0 //음식 가격 총합 저장할 변수
        println("\n아래와 같이 주문 하시겠습니까?")
        println("\n[ Orders ]")
        for(food in myList){
            food.displayInfo()
            sum += food.price //음식 가격 총합
        }
        println("\n[ Total ]")
        println("${sum}원 입니다.")

//        println("\n[ 현재 소지한 금액 ]")
//        println("${cash}원 입니다.")

        println("\n1.주문\t2.메뉴로 돌아가기")

        while(true){
            menuCmd = cmdInput() //입력받은 정수 커맨드
            when(menuCmd){
                2-> break
                1 ->{
                    if(sum <= cash){
                        cash -= sum
                        println("주문이 완료되었습니다.\n")
                        myList.clear() // 장바구니 비우기
                        break
                    }
                    else{
                        println("현재 잔액은 ${cash}원으로 ${sum-cash}원이 부족해서 주문할 수 없습니다.")
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

    fun orderCancel() { // 메뉴 취소할 때 사용하는 메소드
        println("\n취소할 메뉴를 선택해주세요.")

        println("\n[ Orders ]")
        for((idx, food) in myList.withIndex()){
            print("${idx+1}. ")
            food.displayInfo()
        }
        println("0. 메인 메뉴로 돌아가기")

        while(true){
            menuCmd = cmdInput() //입력받은 정수 커맨드
            when(menuCmd){
                0-> break
                in 1..myList.size ->{
                    println("${myList[menuCmd-1].name}(이)가 장바구니에서 제거되었습니다.")
                    myList.removeAt(menuCmd-1)
                    break
                }
                else->{
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요.") //잘못된 입력이라고 출력
                    continue
                }
            }
        }
    }

    fun addBasket(myMenu:DetailMenu){ //basket에 추가하는 메소드
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
                                myList.add(foodList[bMenuCmd-1]) //장바구니 객체의 리스트 마지막에 추가
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