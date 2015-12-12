package com.example.vivek_pc.stickynotes.activities;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.vivek_pc.stickynotes.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.bt1)
    Button bt1;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);


        JobInfo.Builder builder = new JobInfo.Builder( 1,
                new ComponentName( getApplicationContext(),
                        MyService.class ) );
        builder.setPeriodic(5000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        JobScheduler  mJobScheduler = (JobScheduler)
                getApplicationContext().getSystemService( Context.JOB_SCHEDULER_SERVICE );
//        mJobScheduler.schedule(builder.build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if(id== R.id.action_favorite) {

        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.bt1)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                Intent intent = new Intent(this,RVActivity.class);
                startActivity(intent);
                break;
        }
    }
}
