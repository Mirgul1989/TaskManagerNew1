package com.example.taskmanagernew.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Pref(private val context:Context) {

    private val pref: SharedPreferences=context.getSharedPreferences("pref_name",MODE_PRIVATE)

    fun isOnBoardingShow():Boolean{
       return pref.getBoolean(BOARDINGSHOW,false)
    }

    fun savedShowBoarding(isShow:Boolean){

        pref.edit().putBoolean(BOARDINGSHOW,isShow).apply()

    }
    companion object{
   private     const val BOARDINGSHOW="onboarding.show"
    }

}