package com.example.proftestapp.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mapkit.mapview.MapView

/**
 * Экран MapScreen содержит в себе карту из библиотеки Yandex MapKit. Для отображения карты
 * используется composable элемент AndroidView. Весь контент внутри экрана хранится в Scaffold контейнере.
 *
 * @param modifier для установки вида и/или поведения экрана
 * @param mapView объект класса MapView из библиотеки Yandex MapKit
 * (передается во внутрь factory в AndroidView)
 */
@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    mapView: MapView
) {

    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets(0.dp)
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