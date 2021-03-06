package com.vadym.pectoralepawnshop.activities;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.vadym.pectoralepawnshop.R;
import com.vadym.pectoralepawnshop.database.PectoraleDatabaseHelper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DetailTopicsActivity extends Activity {

    public static final String ID_TOPIC = "idTopic";
    private WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_topics);

        mWebView = (WebView) findViewById(R.id.webView);

        int idTopic = (Integer) getIntent().getExtras().get(ID_TOPIC);

        try {
            SQLiteOpenHelper pectoraleDatabaseHelper = new PectoraleDatabaseHelper(this);
            SQLiteDatabase db = pectoraleDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query(PectoraleDatabaseHelper.TN_TOPIC,
                    new String[]{"NAME", "URL"},
                    "_id = ?",
                    new String[]{Integer.toString(idTopic)},
                    null, null, null);
            if (cursor.moveToFirst()) {
                //Получение данных статьи из курсора
                String name = cursor.getString(0);
                String url = cursor.getString(1);
                System.out.println(name);
                System.out.println(url);

                ActionBar actionBar = getActionBar();
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setTitle(name);

                new UpdateDrinkTask(this).execute(url);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, R.string.dbunvaliable, Toast.LENGTH_SHORT);
            toast.show();
        }


    }

    private class UpdateDrinkTask extends AsyncTask<String, Void, String> {

        private ProgressDialog dialog;

        public UpdateDrinkTask(Activity activity) {
            dialog = new ProgressDialog(activity);
        }

        protected void onPreExecute() {
            dialog.setMessage(getString(R.string.loadingpage));
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
                // Remove faq block
                document.select("div.faq_link").remove();
                return document.toString();
            } catch (IOException e) {
                return getString(R.string.errorloadingpage);
            }
        }

        protected void onPostExecute(String htmldocument) {
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.loadData(htmldocument, "text/html; charset=utf-8", null);
            mWebView.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView view, String url) {
                    // do your stuff here
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                }
            });

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
