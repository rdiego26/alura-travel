package me.diegoramos.aluratravel.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import me.diegoramos.aluratravel.R
import me.diegoramos.aluratravel.model.Package
import me.diegoramos.aluratravel.util.CurrencyUtil
import me.diegoramos.aluratravel.util.DaysUtil
import me.diegoramos.aluratravel.util.DrawableUtil
import java.math.BigDecimal

class PurchaseSummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_summary)

        setTitle(R.string.purchase_summary_app_bar_title)

        val item = Package("São Paulo", "sao_paulo_sp", 2, BigDecimal(243.99))

        configLocation(item)
        configDays(item)
        configImage(item)
        configPrice(item)

    }

    private fun configLocation(item: Package) {
        val locationText: TextView = findViewById(R.id.purchase_summary_location_name)
        locationText.text = item.location
    }

    private fun configDays(item: Package) {
        val daysText: TextView = findViewById(R.id.purchase_summary_days)
        daysText.text = DaysUtil.formatToText(item.days, this)
    }

    private fun configImage(item: Package) {
        val image: ImageView = findViewById(R.id.purchase_summary_image)
        val drawable: Drawable? = DrawableUtil.getDrawable(this, item.image)
        image.setImageDrawable(drawable!!)
    }

    private fun configPrice(item: Package) {
        val priceText: TextView = findViewById(R.id.purchase_summary_price)
        priceText.text = CurrencyUtil.formatToBR(item.price)
    }
}