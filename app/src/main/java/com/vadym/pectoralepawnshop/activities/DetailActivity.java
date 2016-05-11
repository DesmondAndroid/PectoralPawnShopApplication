package com.vadym.pectoralepawnshop.activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.vadym.pectoralepawnshop.R;
import com.vadym.pectoralepawnshop.database.DataBaseSimulation;
import com.vadym.pectoralepawnshop.fragments.ForClientFragment;
import com.vadym.pectoralepawnshop.fragments.HowItWorksFragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DetailActivity extends Activity {

    public static final String EXTRA_TOPICNO = "topicNo";
    public static final String EXTRA_CALLEDFRAG = "calledFrag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        WebView mWebView = (WebView) findViewById(R.id.webView);

        try {
            // Loading html page
            Document document = Jsoup.connect("http://pectorale.com.ua/stat/4-prostyh-shaga").get();
            // Remove header
            document.getElementsByClass("header").remove();
            // Remove footer
            document.getElementsByClass("footer").remove();
            document.getElementsByClass("empty_footer").remove();
            // Remove block - subscription
            document.getElementsByClass("subscription").remove();
            // Remove main topics at the top page
            document.select("div.container_inside > div.row > div").remove();
            // Remove all links in the text
            document.select("a").unwrap();

            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.loadData(document.toString(), "text/html", "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }


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
