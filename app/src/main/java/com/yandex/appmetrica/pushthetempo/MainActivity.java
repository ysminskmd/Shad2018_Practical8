package com.yandex.appmetrica.pushthetempo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.push.YandexMetricaPush;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final List<Pair<String, String>> mOptions = Arrays.asList(
            Pair.create("Android", "iOS"),
            Pair.create("Rap", "Rock"),
            Pair.create("Marvel", "DC")
    );

    private int mOptionId = 0;

    private Button mLeftOption;
    private Button mRightOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLeftOption = findViewById(R.id.left_option);
        mRightOption = findViewById(R.id.right_option);

        nextPoll();

        mLeftOption.setOnClickListener(this);
        mRightOption.setOnClickListener(this);

        Intent intent = getIntent();
        if (YandexMetricaPush.OPEN_DEFAULT_ACTIVITY_ACTION.equals(intent.getAction())) {
            String payload = intent.getStringExtra(YandexMetricaPush.EXTRA_PAYLOAD);
            Toast.makeText(this, payload, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        YandexMetrica.reportEvent(button.getText().toString());
        nextPoll();
    }

    private void nextPoll() {
        if (mOptionId < mOptions.size()) {
            Pair<String, String> option = mOptions.get(mOptionId++);
            mLeftOption.setText(option.first);
            mRightOption.setText(option.second);
        } else {
            mLeftOption.setText("Yandex");
            mRightOption.setText("Yandex");
        }
    }
}
