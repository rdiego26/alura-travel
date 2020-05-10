package me.diegoramos.aluratravel.ui.activity

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import me.diegoramos.aluratravel.R
import me.diegoramos.aluratravel.model.Package
import me.diegoramos.aluratravel.util.Constants
import me.diegoramos.aluratravel.util.CurrencyUtil
import me.diegoramos.aluratravel.util.DaysUtil
import me.diegoramos.aluratravel.util.DrawableUtil

class PurchaseSummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_summary)

        setTitle(R.string.purchase_summary_app_bar_title)

        handleIntent()
    }

    private fun handleIntent() {
        val receivedIntent = intent
        if (receivedIntent.hasExtra(Constants.selectedPackageExtra())) {
            val item: Package =
                intent.getSerializableExtra(Constants.selectedPackageExtra()) as Package

            configLocation(item)
            configDays(item)
            configImage(item)
            configPrice(item)
        } else {
            val intent = Intent(applicationContext, PackageListActivity::class.java)
            Toast.makeText(applicationContext, R.string.unavailable_package, Toast.LENGTH_SHORT)
                .show()
            startActivity(intent)
        }
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