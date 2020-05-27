package com.example.myappkiehyoon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myappkiehyoon.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class LocationActivity : AppCompatActivity() {

    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap

      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.bottom)


            mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(OnMapReadyCallback {
                googleMap = it
                googleMap.isMyLocationEnabled = true
                val location1 = LatLng(1.290270, 103.851959)
                googleMap.addMarker(MarkerOptions().position(location1).title("My Location"))
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 10f))

            })
      }
}
