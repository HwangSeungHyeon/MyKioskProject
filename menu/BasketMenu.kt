package com.example.mykioskproject.menu

import com.example.mykioskproject.OrderControl
import com.example.mykioskproject.TimeManager
import kotlinx.coroutines.runBlocking
import java.lang.NumberFormatException

class BasketMenu : DetailMenu(){ //DetailMenu 클래스를 상속받았음
    val time = TimeManager() //시간 객체
    var cash = (1 .. 5).random() * 5000 //소지 금액은 5000에서 25000사이 랜덤한 값
    var sum = 0
    var menuCmd = 0
    val orderControl = OrderControl() //코루틴 제어하는 객체

    fun DetailMenu.cmdInput(): Int{ //intMenuCommend 프로퍼티를 입력받음
        var cmdInput: Int
        while(true){
            try{
                cmdInput = readln().toInt() //null을 받을 수 없는 문자열을 가져와서
                break
            }catch (e: NumberFormatException){
                println("숫자만 입력할 수 있어요. 다시 입력해주세요.")
            }
        }
        return cmdInput
    }

    fun ordering() { // 메뉴 주문할 때 사용하는 메소드
        sum = 0 //음식 가격 총합 저장할 변수
        println("\n아래와 같이 주문 하시겠습니까?")
        println("\n[ Orders ]")
        for(food in myList){
            food.displayInfo()
            sum += food.price //음식 가격 총합
        }
        println("\n[ Total ]")
        println("${sum}원 입니다.")

        println("\n[ 현재 소지한 금액 ]")
        println("${cash}원 입니다.")

        println("\n1. 주문\t2. 선택 삭제\t3. 장바구니 비우기\t4. 메뉴로 돌아가기")

        while(true){
            menuCmd = cmdInput() //입력받은 정수 커맨드
            when(menuCmd){
                1 ->{ //주문하기
                    if(sum <= cash){
                        if (time.bankSystemMaintenance()) { // 오후 11시 50분부터 다음날 오전 00시 5분까지 동작하지 않도록 설정
                            orderControl.startCoroutinScope() //코루틴 실행
                            runBlocking{ //3초 지날 때까지 막아둠
                                orderControl.job2?.join()
                            }
                            orderControl.job2?.cancel() //코루틴 할당 취소
                            orderControl.count++
                            cash -= sum
                            println("결제를 완료했습니다. (${time.getTime()})")
                            myList.clear() // 장바구니 비우기
                            break

                        } else {
                            time.getTimeMessage()
                            println("은행 점검 시간에는 결제할 수 없습니다.")
                            println("\n[ 점검시간 ]")
                            println("오후 11시 50분 ~ 다음날 오전 00시 05분")
                            continue
                        }
                    }
                    else{
                        println("현재 잔액은 ${cash}원으로 ${sum-cash}원이 부족해서 주문할 수 없습니다.")
                        continue
                    }
                }
                2-> { //장바구니에서 삭제하기
                    orderCancel()
                    break
                }
                3->{
                    allDelete()
                    break
                }
                4-> break //메인메뉴로 돌아가기
                else->{
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요.") //잘못된 입력이라고 출력
                    continue
                }
            }
        }
    }

    private fun orderCancel() { // 메뉴 취소할 때 사용하는 메소드
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

    private fun allDelete(){
        println("\n장바구니를 초기화하시겠습니까?")
        println("1. 초기화\t2.메인메뉴로 돌아가기")

        while(true){
            menuCmd = cmdInput() //입력받은 정수 커맨드
            when(menuCmd){
                2 -> break
                in 1..myList.size ->{
                    println("장바구니가 초기화되었습니다.")
                    myList.clear()
                    break
                }
                else->{
                    println("잘못된 번호를 입력했어요. 다시 입력해주세요.") //잘못된 입력이라고 출력
                    continue
                }
            }
        }
    }

    fun addBasket(myMenu: DetailMenu){ //basket에 추가하는 메소드
        var escapeFlag: Boolean //메뉴에서 나올 건지 결정하는 플래그

        while(true){
            myMenu.displayInfo() //메뉴 정보 출력
            val bMenuCmd = cmdInput() //장바구니 넣을지 말지 결정하는 메뉴 커맨드
            escapeFlag = true

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