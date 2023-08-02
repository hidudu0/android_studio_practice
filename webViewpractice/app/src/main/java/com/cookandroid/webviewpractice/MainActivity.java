package com.cookandroid.webviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etUrl;
    private AppCompatButton btnMove, btnBack;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUrl = findViewById(R.id.etUrl);
        btnMove = findViewById(R.id.btnMove);
        btnBack = findViewById(R.id.btnBack);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        WebSettings webSet = webView.getSettings();
        webSet.setBuiltInZoomControls(true);
        webSet.setJavaScriptEnabled(true);

        btnMove.setOnClickListener(v -> {
            webView.loadUrl(etUrl.getText().toString());
        });

        btnBack.setOnClickListener(v -> {
            webView.goBack();
        });
    }


    class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}