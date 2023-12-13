package com.example.mykioskproject

import com.example.mykioskproject.menu.FoodData
import java.lang.NumberFormatException

open class DetailMenu {
    val myList = ArrayList<FoodData>() //음식 메뉴를 저장할 리스트

    open fun setList(){ //메뉴를 등록하는 메소드

    }

    open fun displayInfo(){ //등록된 메뉴를 출력하는 메소드

    }

    fun cmdInput(): Int{ //intMenuCommend 프로퍼티를 입력받음
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
}