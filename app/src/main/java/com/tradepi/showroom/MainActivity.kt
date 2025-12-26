package com.tradepi.showroom

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                App()
            }
        }
    }
}

@Composable
private fun App() {
    val context = LocalContext.current

    // Senin live domain
    val siteUrl = "https://www.tradepigloball.co/"

    Column(Modifier.fillMaxSize()) {
        // Üst bar: Pi Browser’a aç butonu (Pi ödeme/SDK için)
        Row(
            Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    // Pi Browser native içine “gömme” yok; en sağlamı URL’yi dışarı açmak.
                    // Kullanıcı Pi Browser kuruluysa orada açar.
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(siteUrl))
                    context.startActivity(i)
                }
            ) { Text("Pi Browser’da Aç") }

            OutlinedButton(
                onClick = {
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(siteUrl))
                    context.startActivity(i)
                }
            ) { Text("Tarayıcıda Aç") }
        }

        WebViewScreen(url = siteUrl, modifier = Modifier.weight(1f))
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
private fun WebViewScreen(url: String, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { ctx ->
            WebView(ctx).apply {
                webViewClient = WebViewClient()
                webChromeClient = WebChromeClient()
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true
                settings.cacheMode = WebSettings.LOAD_DEFAULT
                settings.mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
                loadUrl(url)
            }
        },
        update = { it.loadUrl(url) }
    )
}
