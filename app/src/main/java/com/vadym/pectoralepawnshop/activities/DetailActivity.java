package com.vadym.pectoralepawnshop.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.webkit.WebView;

import com.vadym.pectoralepawnshop.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DetailActivity extends Activity {

    public static final String URL = "URLtoPAGE";
    private WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        mWebView = (WebView) findViewById(R.id.webView);
        Intent intent = getIntent();
        String url = intent.getStringExtra(DetailActivity.URL);

        new UpdateDrinkTask(this).execute(url);
    }

    private class UpdateDrinkTask extends AsyncTask<String, Void, String> {

        private ProgressDialog dialog;

        public UpdateDrinkTask(Activity activity) {
            dialog = new ProgressDialog(activity);
        }

        protected void onPreExecute() {
            dialog.setMessage("Загружаем страницу с интернета, подождите...");
            dialog.show();
        }

        protected String doInBackground(String... links) {
            try {
                // Loading html page
                Document document = Jsoup.connect(links[0]).get();
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
                return document.toString();
            } catch (IOException e) {
                return "Ошибка загрузки страницы, попробуйте чуть позже.";
            }
        }

        protected void onPostExecute(String htmldocument) {
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.loadData(htmldocument, "text/html; charset=utf-8", null);
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
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
