package com.example.mykioskproject

open class PrintText { //SelectMenu의 부모 클래스
    fun displayInfo(flag:Int){ //소개문 또는 메인메뉴 출력하는 함수
        when(flag){
            0 -> {
                println("\"신선하고 좋은 재료로 건강하고 푸짐하게!\"\n맘스터치에 오신걸 환영합니다.")
                println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
            }
            1 -> {
                println("\n[메뉴]")
                println("1. 버거")
                println("2. 치킨")
                println("3. 맘스 세트")
                println("4. 사이드")
                println("5. 음료")
                println("0. 종료")
            }
            2 -> {
                println("\n[주문 메뉴]")
                println("6. 주문")
                println("7. 취소")
            }
            3-> {
                println("\n잘못된 번호를 입력했어요. 다시 입력해주세요.\n")
            }
            4->{
                println("위 메뉴를 장바구니에 추가하시겠습니까?")
                println("1. 확인\t2. 취소")
            }
            -1 -> {
                println("\n프로그램을 종료합니다.")
            }
        }

    }
}