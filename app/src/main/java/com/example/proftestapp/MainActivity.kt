package com.example.proftestapp

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.proftestapp.core.AppConstants
import com.example.proftestapp.ui.MapScreen
import com.example.proftestapp.ui.theme.ProfTestAppTheme
import com.example.proftestapp.ui.utils.LockScreenOrientation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.logo.Alignment
import com.yandex.mapkit.logo.HorizontalAlignment
import com.yandex.mapkit.logo.VerticalAlignment
import com.yandex.mapkit.mapview.MapView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        MapKitFactory.setApiKey(AppConstants.API_KEY)
        MapKitFactory.initialize(this)

        val style = "[" +
                "        {" +
                "            \"types\": \"polyline\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"road\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"e9e9e9\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polyline\"," +
                "            \"elements\": \"geometry.outline\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"road\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"9f9f9f\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polygon\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"land\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"e4e4e4\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polygon\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"landcover\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"e0e3e7\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polygon\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"residential\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"e9ecf0\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polygon\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"industrial\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"f6e7d6\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polygon\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"cemetery\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"c8cbce\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polygon\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"park\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"e0e3e7\"" +
                "            }" +
                "        }" +
                "    ]"

        mapView = MapView(this)

        mapView.mapWindow.map.setMapStyle(style)

        mapView.mapWindow.map.logo.setAlignment(
            Alignment(
                HorizontalAlignment.RIGHT,
                VerticalAlignment.BOTTOM
            )
        )
        
        setContent {
            
            ProfTestAppTheme {

                LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

                MapScreen(
                    modifier = Modifier
                        .fillMaxSize(),
                    mapView = mapView
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}