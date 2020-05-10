package me.diegoramos.aluratravel.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import me.diegoramos.aluratravel.R
import me.diegoramos.aluratravel.model.Package
import me.diegoramos.aluratravel.util.Constants
import me.diegoramos.aluratravel.util.CurrencyUtil

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        setTitle(R.string.payment_app_bar_title)

        handleIntent()
    }

    private fun handleIntent() {
        val receivedIntent = intent
        if (receivedIntent.hasExtra(Constants.selectedPackageExtra())) {
            val item: Package =
                intent.getSerializableExtra(Constants.selectedPackageExtra()) as Package

            configPrice(item)
            configButton(item)
        } else {
            val intent = Intent(applicationContext, PackageListActivity::class.java)
            Toast.makeText(applicationContext, R.string.unavailable_package, Toast.LENGTH_SHORT)
                .show()
            startActivity(intent)
        }
    }

    private fun configPrice(item: Package) {
        val priceText: TextView = findViewById(R.id.payment_price_value)
        priceText.text = CurrencyUtil.formatToBR(item.price)
    }

    private fun configButton(item: Package) {
        val button: Button = findViewById(R.id.payment_make_payment_button)
        button.setOnClickListener {
            goToPurchaseSummary(item)
        }
    }

    private fun goToPurchaseSummary(item: Package) {
        val intent = Intent(applicationContext, PurchaseSummaryActivity::class.java)
        intent.putExtra(Constants.selectedPackageExtra(), item)
        startActivity(intent)
    }

}