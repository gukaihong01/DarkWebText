package com.gukaihong.darkwebtext

import android.content.res.Configuration
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val html = """
            <p style="text-align:center;">
            	这
            </p>
            <p style="text-align:center;">
            	里
            </p>
            <p style="text-align:center;">
            	是
            </p>
            <p style="text-align:center;">
            	什
            </p>
            <p style="text-align:center;">
            	么
            </p>
            <p style="text-align:center;">
            	颜
            </p>
            <p style="text-align:center;">
            	色
            </p>
            <p style="text-align:center;">
            	！！！
            </p>
        """
        val webSetting = webView.settings
        webSetting.javaScriptEnabled = true
        webSetting.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        webSetting.setAllowFileAccessFromFileURLs(false)
        webSetting.setAllowUniversalAccessFromFileURLs(false)
        webView.loadUrl("file:///android_asset/htmlStyle.html?type=${if (isDarkTheme()) 1 else 0}")
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(p0: WebView?, p1: String?) {
                super.onPageFinished(p0, p1)
                webView.loadUrl("javascript:createTable('$html')")
            }
        }
    }

    /**
     * 是否是深色模式
     *
     */
    fun isDarkTheme(): Boolean = (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
}