package com.universityapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.universityapp.util.Converter
import io.reactivex.annotations.NonNull
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "UniversityTable")
data class University (
    @ColumnInfo(name = "alpha_two_code")
    @SerializedName("alpha_two_code" ) var alphaTwoCode   : String?           = null,
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    @SerializedName("name"           ) var name           : String,
    @ColumnInfo(name = "country")
    @SerializedName("country"        ) var country        : String?           = null,

    @TypeConverters(Converter::class)
    @ColumnInfo(name = "domains")
    @SerializedName("domains"        ) var domains: ArrayList<String> = arrayListOf(),
    @TypeConverters(Converter::class)
    @ColumnInfo(name = "web_pages")
    @SerializedName("web_pages"      ) var webPages: ArrayList<String> = arrayListOf(),
    @TypeConverters(Converter::class)
    @ColumnInfo(name = "state-province")
    @SerializedName("state-province" ) var stateProvince : String?= null
        ) : Parcelable





