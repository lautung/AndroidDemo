package com.lautung.webview_ex

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.lautung.webview_ex.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.wv.apply {
            loadUrl("https://baidu.com")
            settings.apply {
                useWideViewPort=true
                loadWithOverviewMode=true
                setSupportZoom(true)
                builtInZoomControls=true
                displayZoomControls=true
                cacheMode= WebSettings.LOAD_CACHE_ELSE_NETWORK
                allowFileAccess=true
                javaScriptCanOpenWindowsAutomatically=true
                loadsImagesAutomatically=true
                defaultTextEncodingName="utf-8"
            }
            webViewClient= object: WebViewClient(){
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    view?.loadUrl(request?.url.toString())
                    return true
                }

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {

                }

                override fun onPageFinished(view: WebView?, url: String?) {

                }

                override fun onLoadResource(view: WebView?, url: String?) {

                }

                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?
                ) {

                }






            }

            webChromeClient=object :WebChromeClient(){
                override fun onProgressChanged(view: WebView?, newProgress: Int) {

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.wv.settings.javaScriptEnabled=true
    }

    override fun onPause() {
        super.onPause()
        binding.wv.settings.javaScriptEnabled=false
    }
}