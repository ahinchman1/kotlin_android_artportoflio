package com.example.amandahinchman.artportfolio

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView


class ImageGridAdapter(context: Context, resources: List<Int>) : ArrayAdapter<Int>(context, R.layout.art_piece_entry, resources) {
    private val mResources = resources

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val art = mResources[position]

        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val artView = inflater.inflate(R.layout.art_piece_entry, null)
        val imageView:ImageView = artView.findViewById<ImageView>(R.id.artPieceImage)

        imageView.setImageBitmap(decodeSampledBitmapFromResource(context.resources, art, 100, 100))

        return artView
    }

    private fun decodeSampledBitmapFromResource(res: Resources, resId: Int,
                                                reqWidth: Int, reqHeight: Int): Bitmap {

        // First decode with inJustDecodeBounds=true to check dimensions
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(res, resId, options)

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight)

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false
        return BitmapFactory.decodeResource(res, resId, options)
    }

    private fun calculateInSampleSize(options: BitmapFactory.Options, reqWidth: Int,
                                      reqHeight: Int): Int {
        // Raw height and width of image
        val height = options.outHeight
        val width = options.outWidth
        var inSampleSize = 1

        if (height > reqHeight || width > reqWidth) {

            val halfHeight = height / 2
            val halfWidth = width / 2

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }

        return inSampleSize
    }

}
