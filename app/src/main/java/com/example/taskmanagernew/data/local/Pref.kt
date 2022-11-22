package com.example.taskmanagernew.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Pref(context:Context) {

    private val pref: SharedPreferences=context.getSharedPreferences("pref_name",MODE_PRIVATE)
    


    fun isBoardingShow():Boolean{
       return pref.getBoolean(BOARDING_SHOW,false)
    }

    fun savedShowBoarding(isShow:Boolean){
        pref.edit().putBoolean(BOARDING_SHOW,isShow).apply()

    }
    companion object{
        private const val BOARDING_SHOW="onboarding.show"
        private const val NAME_PROFILE="profile.name"
        private const val AGE_PROFILE="profile.age"
        private const val IMAGE_PROFILE="profile.image"
    }

    fun savedName(name: String){
        pref.edit().putString(NAME_PROFILE,name).apply()

    }

  fun getName():String?{
      return pref.getString(NAME_PROFILE,"")
  }
   fun saveAge(age: String) {
       pref.edit().putString(AGE_PROFILE,age).apply()
   }
    fun getAge(): String? {
return pref.getString(AGE_PROFILE,"")
    }
    fun saveImage(url:String){
        pref.edit().putString(IMAGE_PROFILE,url).apply()

    }
    fun getImage():String?{
        return pref.getString(IMAGE_PROFILE,"")
    }


}