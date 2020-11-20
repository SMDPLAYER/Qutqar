package uz.smd.hakaton;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Yandex extends AppCompatActivity {
    private ValueCallback<Uri[]> mFilePathCallback;
    private WebView webView;
    private String lastUrl;

    Activity activity ;
    private ProgressDialog progDailog;

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yandex);

        activity = this;

        progDailog = ProgressDialog.show(activity, "Yuklanmoqda","Iltimos kuting...", true);
        progDailog.setCancelable(false);



        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.thehotline.org/identify-abuse/");
        WebSettings webSettings = webView.getSettings();

        webSettings.setDomStorageEnabled(true);


        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient(){
            public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
                super.onPageStarted(webView, string2, bitmap);
                if (string2.startsWith("https://www.thehotline.org/identify-abuse/")) {
                    Yandex.this.lastUrl = string2;
                }
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog.show();
                view.loadUrl(url);

                return true;
            }
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.proceed();
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog.dismiss();
            }

        });

        webView.setWebChromeClient(new WebChromeClient(){

            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                Yandex.this.mFilePathCallback = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                Yandex.this.startActivityForResult(Intent.createChooser((Intent)intent, (CharSequence)"File Browser"), 2);
                return true;
            }
        });

    }
}
