package me.lgcode.agepedia.repository.domain

import com.google.gson.annotations.SerializedName

enum class Age(val value: String) {
    @SerializedName("Dark") DARK("Dark"),
    @SerializedName("Feudal") FEUDAL("Feudal"),
    @SerializedName("Castle") CASTLE("Castle"),
    @SerializedName("Imperial") IMPERIAL("Imperial")
}