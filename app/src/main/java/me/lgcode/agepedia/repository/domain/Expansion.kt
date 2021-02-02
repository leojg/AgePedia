package me.lgcode.agepedia.repository.domain

import com.google.gson.annotations.SerializedName

enum class Expansion(val value: String) {
    @SerializedName("Age of Kings") AOK("Age of Kings"),
    @SerializedName("The Conquerors") AOC("The Conquerors"),
    @SerializedName("Forgotten Empires") FORGOTTEN("Forgotten Empires"),
    @SerializedName("Rise of Rajas") RAJAS("Rise of Rajas"),
    @SerializedName("African Kingdoms") AFRICAN("African Kingdoms")
}