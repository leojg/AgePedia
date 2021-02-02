package me.lgcode.agepedia.repository.domain

import me.lgcode.agepedia.repository.local.TechEntity

object TechMapper {

    fun mapToEntity(techModel: TechModel) = TechEntity(
        techModel.id,
        techModel.name,
        techModel.description,
        techModel.expansion,
        techModel.age,
        techModel.developsIn,
        techModel.cost,
        techModel.buildTime,
        techModel.appliesTo
    )

    fun mapListToEntity(list: List<TechModel>) = list.map { mapToEntity(it) }

}
