package me.diegoramos.aluratravel.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import me.diegoramos.aluratravel.R
import me.diegoramos.aluratravel.dao.PackageDAO
import me.diegoramos.aluratravel.ui.adapter.PackageListAdapter

class PackageListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_list)

        val packageList: ListView = findViewById(R.id.packageList)
        packageList.adapter = PackageListAdapter(this, PackageDAO.getList())
    }
}
