package com.vadym.pectoralepawnshop.activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.vadym.pectoralepawnshop.R;
import com.vadym.pectoralepawnshop.database.DataBaseSimulation;
import com.vadym.pectoralepawnshop.fragments.ForClientFragment;
import com.vadym.pectoralepawnshop.fragments.HowItWorksFragment;

public class DetailActivity extends Activity {

    public static final String EXTRA_TOPICNO = "topicNo";
    public static final String EXTRA_CALLEDFRAG = "calledFrag";

    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        WebView mWebView = (WebView) findViewById(R.id.webView);
        TextView contentView = (TextView) findViewById(R.id.contentView);

        /* An instance of this class will be registered as a JavaScript interface */
        class MyJavaScriptInterface
        {
            private TextView contentView;

            public MyJavaScriptInterface(TextView aContentView)
            {
                contentView = aContentView;
            }

            @SuppressWarnings("unused")
            public void processContent(String aContent)
            {
                final String content = aContent;
                contentView.post(new Runnable()
                {
                    public void run()
                    {
                        contentView.setText(content);
                    }
                });
            }
        }

//        mWebView.setWebViewClient(new MyWebViewClient());
        // включаем поддержку JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.addJavascriptInterface(new MyJavaScriptInterface(contentView), "INTERFACE");
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:window.INTERFACE.processContent(document.getElementsByTagName('body')[0].innerText);");
            }
        });
        // указываем страницу загрузки
        mWebView.loadUrl("http://pectorale.com.ua/stat/4-prostyh-shaga");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

}
