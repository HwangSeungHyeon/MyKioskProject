package com.example.mykioskproject

class Input {
    fun input(): String?{
        //readln은 readLine을 대체한 메소드로, null을 입력받지 않는다.
        val commend = readln() //String 타입으로 입력받는다.

        if(!commend.isNumeric()){ //commend가 정수가 아닐 경우
            println("\n숫자 입력만 가능합니다!")
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
}