package com.yandex.appmetrica.pushthetempo;

import android.app.Application;

import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.push.YandexMetricaPush;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        YandexMetrica.activate(getApplicationContext(), "d0d984ef-0d49-46f6-9265-67dfd4794536");
        YandexMetrica.enableActivityAutoTracking(this);

        YandexMetricaPush.init(getApplicationContext());
    }
}
