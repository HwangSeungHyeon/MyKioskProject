package com.example.mykioskproject

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class TimeManager {
    private var currentTime = Calendar.getInstance()

    fun getTimeMessage(){ //현재 시간 출력
        currentTime = Calendar.getInstance()
        println(SimpleDateFormat("\n현재 시각은 a hh시 mm분입니다.", Locale.KOREA).format(currentTime.time))
    }

    fun getTime(): String{ //현재 시간 출력
        currentTime = Calendar.getInstance()
        return SimpleDateFormat("yyyy-MM-dd a hh:mm:ss", Locale.KOREA).format(currentTime.time)
    }

    fun bankSystemMaintenance(): Boolean{
        currentTime = Calendar.getInstance()
        val currentHour = currentTime.get(Calendar.HOUR_OF_DAY)
        val currentMinute = currentTime.get(Calendar.MINUTE)
        return !(currentHour == 23 && currentMinute >= 50 || currentHour == 0 && currentMinute <= 5)
    }

}