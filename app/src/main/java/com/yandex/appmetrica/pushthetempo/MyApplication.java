package com.yandex.appmetrica.pushthetempo;

import android.app.Application;

import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.push.YandexMetricaPush;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        YandexMetrica.activate(getApplicationContext(), "68f96d35-447d-47f1-b6ba-416dcf934997");
        YandexMetrica.enableActivityAutoTracking(this);

        YandexMetricaPush.init(getApplicationContext());
    }
}
