package me.diegoramos.aluratravel.util

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable

object DrawableUtil {

    fun getDrawable(context: Context, drawableName: String): Drawable? {
        val resources: Resources = context.resources
        val drawableID = resources.getIdentifier(drawableName, "drawable", context.packageName)
        return resources.getDrawable(drawableID)
    }
}