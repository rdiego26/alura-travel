package me.diegoramos.aluratravel.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.diegoramos.aluratravel.R
import me.diegoramos.aluratravel.dao.PackageDAO
import me.diegoramos.aluratravel.ui.adapter.PackageListAdapter
import me.diegoramos.aluratravel.util.Constants

class PackageListActivity : AppCompatActivity() {

    private var packageList: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_list)

        initializeComponents()
        configureList()
    }

    private fun initializeComponents() {
        packageList = findViewById(R.id.packageList)
    }

    private fun configureList() {
        packageList?.adapter = PackageListAdapter(PackageDAO.getList())
//        packageList?.setOnItemClickListener { parent, view, position, id ->
//            toToPackageSummary(position)
//        }
        val linearLayoutManager = LinearLayoutManager(this)
        packageList?.layoutManager = linearLayoutManager
    }

    private fun toToPackageSummary(position: Int) {
        val intent = Intent(applicationContext, PackageSummaryActivity::class.java)
        intent.putExtra(Constants.selectedPackageExtra(), PackageDAO.getList().get(position))
        startActivity(intent)
    }
}
