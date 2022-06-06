package com.example.todolistapp

import android.app.TimePickerDialog
import com.example.todolistapp.model.User
import com.example.todolistapp.retrofit.dto.TaskDoneDTO
import com.example.todolistapp.retrofit.dto.UserDTO
import java.text.SimpleDateFormat

object Constants {
    val SHARED_PREFERENCE_NAME="TODO_SHARED_PREFERENCE"
    val SHARED_PREF_TOKEN="SHARED_PREFERENCE_TOKEN_SESSION"
    val SHARED_PREF_NO_CACHE="SHARED_PREFERENCE_NO_CACHE"
    val SHARED_PREF_USER_DATA="SHARED_PREFERENCE_USER_DATA"



    val RQ_READ_WRITE_PERMISSION=1
    var taskDoneList=ArrayList<Int>()
    var userData: User?=null


    var selectedDate=0L
    var selectedTime=0L

    var isTimeLooper=false


    fun deriveRemainingTime(timeInMilli:Long,sdf:SimpleDateFormat):String{

        var remainderTime=0L
        var limit="left"
        val currentTime=System.currentTimeMillis()
        val temp = sdf.format(currentTime)
        val tempB=sdf.format(timeInMilli)

        if(currentTime>timeInMilli){
            remainderTime=currentTime-timeInMilli
            limit="passed deadline"
        }
        else{
            remainderTime=timeInMilli-currentTime
        }
        val timeInMin= remainderTime/60000
        if(timeInMin<60){
            if (timeInMin==1L) return "$timeInMin minute $limit" else  return "$timeInMin minutes $limit"

        }
        val timeInHr=timeInMin/60
        if(timeInHr<24){
            if(timeInHr==1L) return "$timeInHr hour $limit" else return "$timeInHr hours $limit"

        }
        val timeInDays=timeInHr/24
        if(timeInDays<7){
            if(timeInDays==1L) return "$timeInDays day $limit" else return "$timeInDays days $limit"

        }

        val timeInWeeks=timeInDays/7
        if(timeInWeeks<4){
            if(timeInWeeks==1L) return "$timeInWeeks week $limit" else return "$timeInWeeks weeks $limit"

        }

        val timeInMonths=timeInWeeks/4
        if(timeInMonths<12){
            if(timeInMonths==1L) return "$timeInMonths month $limit" else return "$timeInMonths months $limit"

        }

        val timeInYears=timeInMonths/12

        if(timeInMonths>=12){
            if(timeInYears==1L) return "$timeInYears year $limit" else return "$timeInYears years $limit"

        }

        return "invalid"
    }

}

