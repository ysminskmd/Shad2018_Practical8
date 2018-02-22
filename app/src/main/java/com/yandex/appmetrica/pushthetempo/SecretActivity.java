package com.yandex.appmetrica.pushthetempo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SecretActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);

        Toast.makeText(this, getIntent().getDataString(), Toast.LENGTH_LONG).show();
    }
}
