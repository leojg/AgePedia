package me.lgcode.agepedia.repository.remote

import com.google.gson.annotations.SerializedName
import me.lgcode.agepedia.repository.domain.CivModel

class CivResponse(
    @SerializedName("id") override val id: Int,
    @SerializedName("name") override val name: String,
    @SerializedName("expansion") override val expansion: String,
    @SerializedName("army_type") override val type: String,
    @SerializedName("unique_unit")override val uniqueUnits: List<String>,
    @SerializedName("unique_tech")override val uniqueTechs: List<String>,
    @SerializedName("team_bonus")override val teamBonus: String,
    @SerializedName("civilization_bonus")override val civBonus: List<String>
): CivModel

class CivResponseWrapper(
    val civilizations: List<CivResponse>
)