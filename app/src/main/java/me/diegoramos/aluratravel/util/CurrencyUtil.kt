package me.diegoramos.aluratravel.util

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

object CurrencyUtil {

    fun formatToBR(value: BigDecimal): String {
        val currencyFormat: NumberFormat = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
        return currencyFormat.format(value)
    }
}