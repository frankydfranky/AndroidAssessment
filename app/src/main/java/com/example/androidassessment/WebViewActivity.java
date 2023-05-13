package com.example.androidassessment;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView mWebView = findViewById(R.id.webview);

        // Get the passed url
        String url = getIntent().getStringExtra("url");

        // Load webpage in WebView
        mWebView.loadUrl(url);
    }
}

