package me.diegoramos.aluratravel.ui.adapter

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import me.diegoramos.aluratravel.R
import me.diegoramos.aluratravel.model.Package
import me.diegoramos.aluratravel.util.CurrencyUtil

class PackageListAdapter(private val context: Context,
                         private val data: List<Package>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.package_item, parent, false)

        val item: Package = data[position]

        configureLocation(view, item)
        configureImage(view, item)
        configureDays(view, item)
        configurePrice(view, item)

        return view
    }

    private fun configurePrice(view: View, item: Package) {
        val priceText: TextView = view.findViewById(R.id.packageItemPrice)
        priceText.text = String.format(
            context.resources.getString(R.string.package_item_price),
            CurrencyUtil.formatToBR(item.price)
        )
    }

    private fun configureDays(view: View, item: Package) {
        val daysText: TextView = view.findViewById(R.id.packageItemDays)
        daysText.text =
            String.format(context.resources.getString(R.string.package_item_days), item.days)
    }

    private fun configureImage(
        view: View,
        item: Package
    ) {
        val imageView: ImageView = view.findViewById(R.id.packageItemImage)
        val imageDrawable = getDrawable(item)
        imageView.setImageDrawable(imageDrawable)
    }

    private fun getDrawable(item: Package): Drawable? {
        val resources: Resources = context.resources
        val drawableID = resources.getIdentifier(item.image, "drawable", context.packageName)
        return resources.getDrawable(drawableID)
    }

    private fun configureLocation(
        view: View,
        item: Package
    ) {
        val localText: TextView = view.findViewById(R.id.packageItemLocation)
        localText.text = item.location
    }


    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = data[position].hashCode().toLong()

    override fun getCount(): Int = data.size
}