package com.example.amandahinchman.artportfolio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView: GridView = findViewById(R.id.gvArtPieces)

        gridView.adapter = ImageGridAdapter(this)

    }

}
