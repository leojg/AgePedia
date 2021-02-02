package me.lgcode.agepedia.repository.domain

import com.google.gson.annotations.SerializedName

data class Cost (
    @SerializedName("Wood") val wood: Int = 0,
    @SerializedName("Food") val food: Int = 0,
    @SerializedName("Stone") val stone: Int = 0,
    @SerializedName("Gold") val gold: Int = 0
)