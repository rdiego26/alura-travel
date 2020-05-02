package me.diegoramos.aluratravel.util

import android.content.Context
import me.diegoramos.aluratravel.R
import java.util.*

object DateUtil {

    private fun format(date: Date, context: Context): String =
        android.text.format.DateFormat.getDateFormat(context).format(date)

    fun formatRange(initialDate: Date, finalDate: Date, context: Context): String {
        val resources = context.resources
        return String.format(
            resources.getString(R.string.package_summary_dates_range),
            format(initialDate, context), format(finalDate, context)
        )
    }

}