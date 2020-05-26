package com.example.myappkiehyoon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img = arrayOf(
            R.drawable.ai,
            R.drawable.php,
            R.drawable.css,
            R.drawable.id,
            R.drawable.jpg,
            R.drawable.mp4,
            R.drawable.pdf,
            R.drawable.png,
            R.drawable.psd,
            R.drawable.tiff,
            R.drawable.html,
            R.drawable.js

        )
        val text = arrayOf(
            "ai",
            "php",
            "css",
            "id",
            "jpg",
            "mp4",
            "pdf",
            "png",
            "psd",
            "tiff",
            "html",
            "js"
        )

        val gridviewAdapter = GridviewAdapter(this, img, text)
        gridview.adapter = gridviewAdapter
        
        gridview.setOnItemClickListener {adapterView, view, i, l ->

            val intent = Intent(this, KoreanActivity::class.java)
            startActivity(intent)
        }


        viewPager = findViewById(R.id.viewpager) as ViewPager

        val adapter = ViewPageAdapter(this)
        viewPager.adapter = adapter
    }
}
