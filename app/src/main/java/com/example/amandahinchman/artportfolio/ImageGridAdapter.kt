package com.example.amandahinchman.artportfolio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

private val imageIds = arrayOf(
        R.drawable.circa_1967_complete1, R.drawable.circa_1967_complete2,
        R.drawable.circa_1967_complete3, R.drawable.circa_1967_progress,
        R.drawable.circa_1967_progress1, R.drawable.circa_1967_progress2,
        R.drawable.circa_1967_progress3, R.drawable.circa_1967_progress4,
        R.drawable.lightbox2, R.drawable.lightbox5, R.drawable.lightbox6,
        R.drawable.modular_2_lineolium_screenprint, R.drawable.modular_3_lineolium_screenprint,
        R.drawable.modular_4_lineolium_screenprint, R.drawable.molding_mixedmedia_1,
        R.drawable.molding_mixedmedia_2, R.drawable.papermache_welding1,
        R.drawable.papermache_welding2, R.drawable.papermache_welding3,
        R.drawable.papermache_welding4, R.drawable.papermache_welding5,
        R.drawable.papermache_welding6, R.drawable.plaster_mixedmedia,
        R.drawable.screenprint, R.drawable.screenprint2, R.drawable.screenprint_sample,
        R.drawable.screenprint_series, R.drawable.three_dimensional_print,
        R.drawable.trashreplication_1, R.drawable.trashreplication_2,
        R.drawable.trashreplication_3, R.drawable.wire1_sculpture,
        R.drawable.wire2_sculpture, R.drawable.wire3_sculpture,
        R.drawable.wire5_sculpture, R.drawable.yoshi_crochet
)

class ImageGridAdapter(private val mContext: Context): BaseAdapter() {

    override fun getCount(): Int = imageIds.size

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0L

    // create a new ImageView for each item referenced by the Adapter
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val imageView: ImageView
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            val inflater = mContext!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val artView = inflater.inflate(R.layout.art_piece_entry, parent, false)
            imageView = artView.findViewById(R.id.artPieceImage)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        } else {
            imageView = convertView as ImageView
        }

        imageView.setImageResource(imageIds[position])
        return imageView
    }
}
