package me.diegoramos.aluratravel.ui.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import me.diegoramos.aluratravel.R

import me.diegoramos.aluratravel.model.Package
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class PackageListAdapter(private val context: Context,
                         private val data: List<Package>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.package_item, parent, false)

        val item: Package = data[position]

        val localText: TextView = view.findViewById(R.id.packageItemLocation)
        localText.text = item.location

        val imageView: ImageView = view.findViewById(R.id.packageItemImage)
        val resources: Resources = context.resources
        val drawableID = resources.getIdentifier(item.image, "drawable", context.packageName)
        val imageDrawable = resources.getDrawable(drawableID)
        imageView.setImageDrawable(imageDrawable)

        val daysText: TextView = view.findViewById(R.id.packageItemDays)
        daysText.text = String.format(resources.getString(R.string.packageItemDays), item.days)

        val priceText: TextView = view.findViewById(R.id.packageItemPrice)
        val currencyFormat: NumberFormat = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
        priceText.text = String.format(resources.getString(R.string.packageItemPrice), currencyFormat.format(item.price))

        return view
    }


    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = data[position].hashCode().toLong()

    override fun getCount(): Int = data.size
}