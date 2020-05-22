package com.perficient.baidumap.tracepoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baidu.mapapi.map.MapStatus
import com.baidu.mapapi.map.MapStatusUpdateFactory
import com.baidu.mapapi.map.MapView
import com.baidu.mapapi.model.LatLng


class MainActivity : AppCompatActivity() {

    private var mMapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMapView = findViewById(R.id.bmapView)
    }

    override fun onPause() {
        super.onPause()
        mMapView?.onPause()
    }

    override fun onResume() {
        super.onResume()
        mMapView?.onResume()

        val mapStatus = MapStatus.Builder()
            .target(LatLng(30.207811, 120.220744))
            .zoom(20F)
            .build()
        val newMapStatus = MapStatusUpdateFactory.newMapStatus(mapStatus)
        mMapView?.map?.setMapStatus(newMapStatus)

    }

    override fun onDestroy() {
        super.onDestroy()
        mMapView?.onDestroy()
    }
}
