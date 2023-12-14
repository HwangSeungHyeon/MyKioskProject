package com.example.mykioskproject

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class OrderControl {
    var count = 0 //대기 인원수

    // 클래스 생성되는 순간부터 계속 동작
    @OptIn(DelicateCoroutinesApi::class)
    val job1 = GlobalScope.launch {
        while(isActive){
            delay(5000)
            println("현재 주문 대기수: ${count}")
        }
    }

    var job2:Job? = null

    fun startCoroutinScope(){ //함수 호출하는 순간부터 코루틴 동작
        job2 = CoroutineScope(Dispatchers.IO).launch {
            println("결제가 진행 중입니다. 잠시만 기다려주세요.")
            delay(3000) //3초 딜레이
        }
    }
}