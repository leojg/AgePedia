package me.lgcode.agepedia.repository.domain

import me.lgcode.agepedia.repository.local.CivEntity

interface CivModel {
    val id: Int
    val name: String
    val expansion: Expansion
    val type: String
    val uniqueUnits: List<String>
    val uniqueTechs: List<String>
    val teamBonus: String
    val civBonus: List<String>
}