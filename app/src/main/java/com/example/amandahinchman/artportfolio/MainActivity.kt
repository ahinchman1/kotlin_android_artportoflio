package com.example.amandahinchman.artportfolio

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.graphics.drawable.BitmapDrawable
import android.graphics.Bitmap



class MainActivity : AppCompatActivity() {
    private var gridView: GridView? = null
    private var adapter: ArrayAdapter<Drawable>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.art_piece_entry)
        gridView = findViewById(R.id.gvArtPieces)

        val artCollection: List<Drawable> = loadDrawables(this.resources).map {
            resize(it)
        }

        adapter = ArrayAdapter (
                this,
                R.layout.art_piece_entry,
                artCollection
        )

        gridView?.adapter = adapter

    }

    private fun loadDrawables(res: Resources): List<Drawable> {
        val icons = res.obtainTypedArray(R.array.art_images)
        val list = (0 until icons.indexCount).map {
            icons.getDrawable(it)
        }
        icons.recycle() // Must recycle array after
        return list
    }

    // reduce size of high dpi drawables
    private fun resize(image: Drawable): Drawable {
        val b = (image as BitmapDrawable).bitmap
        val bitmapResized = Bitmap.createScaledBitmap(b, 50, 50, false)
        return BitmapDrawable(resources, bitmapResized)
    }

}
