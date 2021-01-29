package me.lgcode.agepedia.repository.domain

import me.lgcode.agepedia.repository.local.CivEntity

object CivMapper {

    fun mapToEntity(civModel: CivModel) = CivEntity(
        civModel.id,
        civModel.name,
        civModel.expansion,
        civModel.type,
        civModel.uniqueUnits,
        civModel.uniqueTechs,
        civModel.teamBonus,
        civModel.civBonus
    )

    fun mapListToEntity(list: List<CivModel>) = list.map { mapToEntity(it) }

}