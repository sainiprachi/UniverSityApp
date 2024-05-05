package com.universityapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class University (
    @SerializedName("alpha_two_code" ) var alphaTwoCode   : String?           = null,
    @SerializedName("name"           ) var name           : String,
    @SerializedName("country"        ) var country        : String?           = null,
    @SerializedName("domains"        ) var domains: ArrayList<String> = arrayListOf(),
    @SerializedName("web_pages"      ) var webPages: ArrayList<String> = arrayListOf(),
    @SerializedName("state-province" ) var stateProvince : String?= null
        ) : Parcelable





