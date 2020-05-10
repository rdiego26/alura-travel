package me.diegoramos.aluratravel.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import me.diegoramos.aluratravel.R
import me.diegoramos.aluratravel.dao.PackageDAO
import me.diegoramos.aluratravel.ui.adapter.PackageListAdapter
import me.diegoramos.aluratravel.util.Constants

class PackageListActivity : AppCompatActivity() {

    private var packageListView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_list)

        initializeComponents()
        configureList()
    }

    private fun initializeComponents() {
        packageListView = findViewById(R.id.packageList)
    }

    private fun configureList() {
        packageListView?.adapter = PackageListAdapter(this, PackageDAO.getList())
        packageListView?.setOnItemClickListener { parent, view, position, id ->
            toToPackageSummary(position)
        }
    }

    private fun toToPackageSummary(position: Int) {
        val intent = Intent(applicationContext, PackageSummaryActivity::class.java)
        intent.putExtra(Constants.selectedPackageExtra(), PackageDAO.getList().get(position))
        startActivity(intent)
    }
}
