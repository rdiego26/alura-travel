package me.diegoramos.aluratravel.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.diegoramos.aluratravel.R
import me.diegoramos.aluratravel.model.Package
import me.diegoramos.aluratravel.util.CurrencyUtil
import me.diegoramos.aluratravel.util.DaysUtil
import me.diegoramos.aluratravel.util.DrawableUtil

class PackageListAdapter(
    private val data: List<Package>
) : RecyclerView.Adapter<PackageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PackageViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) =
        holder.bind(data[position])

}

class PackageViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.package_item, parent, false)) {

    private var priceText: TextView? = null
    private var daysView: TextView? = null
    private var imageView: ImageView? = null
    private var locationView: TextView? = null

    init {
        priceText = itemView.findViewById(R.id.packageItemPrice)
        daysView = itemView.findViewById(R.id.packageItemDays)
        imageView = itemView.findViewById(R.id.packageItemImage)
        locationView = itemView.findViewById(R.id.packageItemLocation)
    }

    fun bind(item: Package) {
        locationView?.text = item.location
        daysView?.text = DaysUtil.formatToText(item.days, itemView.context)
        priceText?.text = CurrencyUtil.formatToBR(item.price)

        val imageDrawable = DrawableUtil.getDrawable(itemView.context, item.image)
        imageView?.setImageDrawable(imageDrawable)

    }


}