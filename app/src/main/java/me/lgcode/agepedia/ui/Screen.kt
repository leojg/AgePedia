package me.lgcode.agepedia.ui

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import me.lgcode.agepedia.R

sealed class Screen(val route: String, @StringRes val label: Int, @DrawableRes val icon: Int) {
    object CivsList: Screen("civsList", R.string.civ_list, R.drawable.aok)
    object TechsList: Screen("techsList", R.string.tech_list, R.drawable.aoc)
}