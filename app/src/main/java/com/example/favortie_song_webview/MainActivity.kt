package com.example.favortie_song_webview

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.favortie_song_webview.ui.theme.FavortiesongwebviewTheme

class MainActivity : ComponentActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient() // 웹뷰 내에서 링크를 클릭하면 새 창이 아닌 웹뷰 내에서 열리도록 설정
        webView.settings.javaScriptEnabled = true // 자바스크립트 사용을 허용

        webView.loadUrl("https://www.naver.com") // 원하는 URL을 로드
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack() // 웹뷰 내에서 이전 페이지로 이동
        } else {
            super.onBackPressed() // 기본 백버튼 동작 수행
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FavortiesongwebviewTheme {
        Greeting("Android")
    }
}