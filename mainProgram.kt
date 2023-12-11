package com.example.mykioskproject

fun main() {
    selectMainMenu() //메뉴 선택받는 함수
}

// 메뉴 띄우는 함수
fun displayMainMenu(){
    println("\"신선하고 좋은 재료로 건강하고 푸짐하게!\"\n맘스터치에 오신걸 환영합니다.")
    println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n")
    println("[메뉴]")

    println("1. 버거")
    println("2. 치킨")
    println("3. 맘스 세트")
    println("4. 사이드")
    println("5. 음료")
    println("0. 종료")
}

fun selectMainMenu(){
    while(true){
        displayMainMenu() //메인 메뉴를 띄우는 함수

        //readln은 readLine을 대체한 메소드로, null을 입력받지 않는다.
        val commend = readln() //String 타입으로 입력받는다.

        if(!commend.isNumeric()){ //commend가 정수가 아닐 경우
            println("정수로 입력해주세요!")
            continue
        }

        when(commend.toInt()){
            1 -> {
                println("버거 메뉴 출력")
            }

            0 -> {
                println("\n프로그램을 종료합니다.")
                break
            }
            else -> {
                println("\n지원하지 않는 기능입니다.\n")
            }
        }
    }
}

//String 클래스에 대한 확장함수
fun String.isNumeric(): Boolean {
    return try {
        this.toInt() //Int 자료형으로 변환이 되면
        true //true 반환
    } catch (e: Exception) { //에러가 발생하면
        false //false 반환
    }
}