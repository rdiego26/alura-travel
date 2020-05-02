package me.diegoramos.aluratravel.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import me.diegoramos.aluratravel.R

import me.diegoramos.aluratravel.model.Package

class PackageListAdapter(private val context: Context,
                         private val data: List<Package>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View =
        LayoutInflater.from(context).inflate(R.layout.package_item, parent, false)

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = data[position].hashCode().toLong()

    override fun getCount(): Int = data.size
}