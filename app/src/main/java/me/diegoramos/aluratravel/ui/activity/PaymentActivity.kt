package me.diegoramos.aluratravel.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.diegoramos.aluratravel.R

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        setTitle(R.string.payment_app_bar_title)


    }

}