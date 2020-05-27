package com.example.myappkiehyoon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.myappkiehyoon.Auth.AccountActivity
import com.example.myappkiehyoon.Auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom.*

class MainActivity : AppCompatActivity() {

    internal lateinit var viewPager: ViewPager

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

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

        my_page.setOnClickListener {

            if(auth.currentUser == null) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, AccountActivity::class.java)
                startActivity(intent)

            }


        }

    }
}
