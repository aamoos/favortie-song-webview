package com.example.favortie_song_webview

 import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                Toast.makeText(this@MainActivity, "Failed to load webpage", Toast.LENGTH_SHORT).show()
            }
        }

        webView.settings.javaScriptEnabled = true // 자바스크립트 사용을 허용
        webView.settings.useWideViewPort = true

        webView.loadUrl("https://favorite-song.store") // 원하는 URL을 로드
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack() // 웹뷰 내에서 이전 페이지로 이동
        } else {
            super.onBackPressed() // 기본 백버튼 동작 수행
        }
    }
}