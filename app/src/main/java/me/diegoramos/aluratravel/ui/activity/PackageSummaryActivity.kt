package me.diegoramos.aluratravel.ui.activity

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import me.diegoramos.aluratravel.R
import me.diegoramos.aluratravel.model.Package
import me.diegoramos.aluratravel.util.*
import java.util.*

class PackageSummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_summary)

        setTitle(R.string.package_summary_app_bar_title)

        handleIntent()
    }

    private fun handleIntent() {
        val receivedIntent = intent
        if (receivedIntent.hasExtra(Constants.selectedPackageExtra())) {
            val item: Package =
                intent.getSerializableExtra(Constants.selectedPackageExtra()) as Package

            configLocation(item)
            configImage(item)
            configDays(item)
            configPrice(item)
            configDates(item)
            configButton(item)
        } else {
            val intent = Intent(applicationContext, PackageListActivity::class.java)
            Toast.makeText(applicationContext, R.string.unavailable_package, Toast.LENGTH_SHORT)
                .show()
            startActivity(intent)
        }
    }

    private fun configDates(item: Package) {
        val datesText: TextView = findViewById(R.id.package_summary_dates)
        val initialDate = Calendar.getInstance()
        val finalDate = Calendar.getInstance()
        finalDate.add(Calendar.DATE, item.days)
        datesText.text = DateUtil.formatRange(initialDate.time, finalDate.time, this)
    }

    private fun configPrice(item: Package) {
        val priceText: TextView = findViewById(R.id.package_summary_price)
        priceText.text = CurrencyUtil.formatToBR(item.price)
    }

    private fun configDays(item: Package) {
        val daysText: TextView = findViewById(R.id.package_summary_days)
        daysText.text = DaysUtil.formatToText(item.days, this)
    }

    private fun configImage(item: Package) {
        val image: ImageView = findViewById(R.id.package_summary_image)
        val drawable: Drawable? = DrawableUtil.getDrawable(this, item.image)
        image.setImageDrawable(drawable!!)
    }

    private fun configLocation(item: Package) {
        val locationText: TextView = findViewById(R.id.package_summary_city)
        locationText.text = item.location
    }

    private fun configButton(item: Package) {
        val button: Button = findViewById(R.id.package_summary_button)
        button.setOnClickListener {
            val intent = Intent(applicationContext, PaymentActivity::class.java)
            intent.putExtra(Constants.selectedPackageExtra(), item)
            startActivity(intent)
        }
    }

}