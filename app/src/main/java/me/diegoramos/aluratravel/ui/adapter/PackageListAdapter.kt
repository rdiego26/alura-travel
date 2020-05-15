package me.diegoramos.aluratravel.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.package_item.view.*
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

    fun bind(item: Package) {
        itemView.packageItemLocation.text = item.location
        itemView.packageItemDays.text = DaysUtil.formatToText(item.days, itemView.context)
        itemView.packageItemPrice.text = CurrencyUtil.formatToBR(item.price)

        val imageDrawable = DrawableUtil.getDrawable(itemView.context, item.image)
        itemView.packageItemImage.setImageDrawable(imageDrawable)

    }


}