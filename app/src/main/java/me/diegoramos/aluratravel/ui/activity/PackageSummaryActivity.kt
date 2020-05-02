package me.diegoramos.aluratravel.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import me.diegoramos.aluratravel.R
import me.diegoramos.aluratravel.model.Package
import me.diegoramos.aluratravel.util.CurrencyUtil
import me.diegoramos.aluratravel.util.DateUtil
import me.diegoramos.aluratravel.util.DaysUtil
import me.diegoramos.aluratravel.util.DrawableUtil
import java.math.BigDecimal
import java.util.*

class PackageSummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.package_summary)

        val item = Package("São Paulo", "sao_paulo_sp", 2, BigDecimal(243.99))

        val locationText: TextView = findViewById(R.id.package_summary_city)
        locationText.text = item.location

        val image: ImageView = findViewById(R.id.package_summary_image)
        val drawable: Drawable? = DrawableUtil.getDrawable(this, item.image)
        image.setImageDrawable(drawable!!)

        val daysText: TextView = findViewById(R.id.package_summary_days)
        daysText.text = DaysUtil.formatToText(item.days, this)

        val priceText: TextView = findViewById(R.id.package_summary_price)
        priceText.text = CurrencyUtil.formatToBR(item.price)

        val datesText: TextView = findViewById(R.id.package_summary_dates)
        val initialDate = Calendar.getInstance()
        val finalDate = Calendar.getInstance()
        finalDate.add(Calendar.DATE, item.days)
        datesText.text = DateUtil.formatRange(initialDate.time, finalDate.time, this)


    }

}