package com.app.bsc20920

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions


class MapAct : AppCompatActivity(), OnMapReadyCallback {
//    var lat = doubleArrayOf(53.349562, 53.336021, 53.336021, 53.33796, 53.344304)
//    var logit = doubleArrayOf(-6.278198, -6.26298, -6.26298, -6.24153, -6.250427)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        for (i in MainButtonActivity.list!!) {
            val sydney = LatLng(i.lat, i.long)
            googleMap.addMarker(
                MarkerOptions()
                    .position(sydney)
                    .title("Marker in Sydney")
            )
        }

        googleMap.setMinZoomPreference(6.0f)
        googleMap.setMaxZoomPreference(14.0f)

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(
            MainButtonActivity.list!![0].lat,
            MainButtonActivity.list!![0].long)))
    }


}