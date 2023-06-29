package com.example.marg_disha_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.fragment.app.FragmentActivity

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.marg_disha_new.databinding.ActivityMapsBinding

class MapsActivity : FragmentActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val delhi = LatLng(28.69549647089692, 77.19341287422617)
        val karnal = LatLng(29.687923174038545, 76.9889459811941)
        val Panipat = LatLng(29.394242010326607, 76.96480331679682)
        val Samalkha = LatLng(29.24074275296764, 77.01136375833626)

        mMap.addMarker(MarkerOptions().position(delhi).title("Place name in Delhi"))
        mMap.addMarker(MarkerOptions().position(karnal).title("Place name in Karnal"))
        mMap.addMarker(MarkerOptions().position(Panipat).title("Place name in Panipat"))
        mMap.addMarker(MarkerOptions().position(Samalkha).title("Place name in Samalkha"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Panipat,15f))
    }
}