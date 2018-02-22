package com.yandex.appmetrica.pushthetempo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.yandex.metrica.push.YandexMetricaPush;

public class SilentPushReceiver extends BroadcastReceiver {

    private static final String TAG = SilentPushReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + intent.getStringExtra(YandexMetricaPush.EXTRA_PAYLOAD));
    }
}
