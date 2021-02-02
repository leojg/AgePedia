package me.lgcode.agepedia.repository.remote

import com.google.gson.annotations.SerializedName
import me.lgcode.agepedia.repository.domain.*

class TechResponse(
    @SerializedName("id") override val id: Int,
    @SerializedName("name") override val name: String,
    @SerializedName("description") override val description: String,
    @SerializedName("expansion") override val expansion: Expansion,
    @SerializedName("age") override val age: Age,
    @SerializedName("develops_in") override val developsIn: String,
    @SerializedName("cost") override val cost: Cost,
    @SerializedName("build_time") override val buildTime: Int,
    @SerializedName("applies_to") override val appliesTo: List<String>?

):TechModel

class TechResponseWrapper(
    val technologies: List<TechResponse>
)