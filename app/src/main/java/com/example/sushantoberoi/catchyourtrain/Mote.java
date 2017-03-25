package com.example.sushantoberoi.catchyourtrain;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by sushant oberoi on 25-03-2017.
 */
public class Mote extends BroadcastReceiver {

    static MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {

        mp = MediaPlayer.create(context, R.raw.emergency_alert);
        Log.d("tag1", "LOOLO");
        mp.start();

    }
}
