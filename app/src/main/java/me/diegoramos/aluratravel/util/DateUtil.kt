package me.diegoramos.aluratravel.util

import android.content.Context
import java.util.*

object DateUtil {

    fun format(date: Date, context: Context): String =
        android.text.format.DateFormat.getDateFormat(context).format(date)

}