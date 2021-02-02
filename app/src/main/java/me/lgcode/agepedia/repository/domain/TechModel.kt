package me.lgcode.agepedia.repository.domain

interface TechModel {
    val id: Int
    val name: String
    val description: String
    val expansion: Expansion
    val age: Age
    val developsIn: String
    val cost: Cost
    val buildTime: Int
    val appliesTo: List<String>?
}