package me.diegoramos.aluratravel.util

import android.content.Context
import me.diegoramos.aluratravel.R

object DaysUtil {

    fun formatToText(quantityOfDays: Int, context: Context): String {
        return if (quantityOfDays > 1) {
            "$quantityOfDays ${context.getString(R.string.common_day_plural)}"
        } else {
            "$quantityOfDays ${context.getString(R.string.common_day_regular)}"
        }
    }
}