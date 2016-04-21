package com.vadym.pectoralepawnshop;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;

public class SignInActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.vadym.pectoralepawnshop.R.layout.activity_sign_in);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
