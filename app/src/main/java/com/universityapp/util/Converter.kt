package com.universityapp.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converter {
    @TypeConverter
    fun fromArray(foodDonationList:ArrayList<String>?): String?  {
        return Gson().toJson(foodDonationList)
    }

    @TypeConverter
    fun toArray(value:String?):ArrayList<String>? {
        val listType: Type = object : TypeToken<ArrayList<String>>() {}.type

        return Gson().fromJson(value, listType)
    }

}