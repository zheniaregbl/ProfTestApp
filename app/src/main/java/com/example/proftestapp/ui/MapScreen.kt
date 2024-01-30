package com.example.proftestapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mapkit.mapview.MapView

@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    mapView: MapView
) {

    Scaffold(
        modifier = modifier
    ) { paddingValues ->

        AndroidView(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            factory = {
                mapView
            }
        )
    }
}