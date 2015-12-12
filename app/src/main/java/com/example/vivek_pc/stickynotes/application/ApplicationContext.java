package com.example.vivek_pc.stickynotes.application;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/**
 * Created by vivek-pc on 11/21/2015.
 */
public class ApplicationContext extends Application{

    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(Intent.ACTION_SCREEN_ON)){
                Log.d("vvk","on");
            }
            else if(action.equals(Intent.ACTION_SCREEN_OFF)){
                    Log.d("vvk","off");
                }
            }
    };

    public void onCreate ()
    {
        IntentFilter screenStateFilter = new IntentFilter();
        screenStateFilter.addAction(Intent.ACTION_SCREEN_ON);
        screenStateFilter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(receiver, screenStateFilter);
        // Setup handler for uncaught exceptions.
//        Thread.setDefaultUncaughtExceptionHandler (new Thread.UncaughtExceptionHandler()
//        {
//            @Override
//            public void uncaughtException (Thread thread, Throwable e)
//            {
//                handleUncaughtException (thread, e);
//            }
//        });
    }
    void handleUncaughtException(Thread thread, Throwable e) {
        Log.d("vvk","c " + e.getMessage());
        System.exit(1);
    }
}
