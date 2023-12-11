package com.example.mykioskproject

class Input {
    var commend = ""

    private fun input(): String?{
        //readln은 readLine을 대체한 메소드로, null을 입력받지 않는다.
        commend = readln() //String 타입으로 입력받는다.

        if(!commend.isNumeric()){ //commend가 정수가 아닐 경우
            println("\n숫자만 입력할 수 있어요. 다시 입력해주세요.")
            return null
        }
        return commend
    }

    //String 클래스에 대한 확장함수
    private fun String.isNumeric(): Boolean {
        return try {
            this.toInt() //Int 자료형으로 변환이 되면
            true //true 반환
        } catch (e: Exception) { //에러가 발생하면
            false //false 반환
        }
    }

    fun getIntInput():Int{
        while(true){
            commend = input() ?: continue //입력한 값이 null이 아니면 입력한 값 대입, null이면 continue
            break
        }
        return commend.toInt()
    }
}