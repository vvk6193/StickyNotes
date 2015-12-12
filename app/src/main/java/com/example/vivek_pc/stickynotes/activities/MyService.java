package com.example.vivek_pc.stickynotes.activities;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class MyService extends JobService {
    public MyService() {
    }
    private Handler mJobHandler = new Handler( new Handler.Callback() {

        @Override
        public boolean handleMessage( Message msg ) {
            Toast.makeText( getApplicationContext(),
                    "JobService task running", Toast.LENGTH_SHORT )
                    .show();
            jobFinished( (JobParameters) msg.obj, false );
            return true;
        }

    } );

    @Override
    public boolean onStartJob(JobParameters params) {

        mJobHandler.sendMessage( Message.obtain( mJobHandler, 1, params ) );
        Log.d("vvk","scheduled");
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

}
