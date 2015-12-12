package com.example.vivek_pc.stickynotes.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.vivek_pc.stickynotes.R;
import com.example.vivek_pc.stickynotes.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RVActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.my_recycler_view)
    RecyclerView rcview;

    List<Integer> list;
    int c = 12;
    TestAdapter testAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

//        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.cltoolbar);
//        collapsingToolbarLayout.setTitle("Collapsing");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);list.add(3);list.add(4);list.add(5);
        list.add(6);list.add(7);list.add(8);list.add(9);list.add(10);
        list.add(11);

        testAdapter = new TestAdapter(list);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcview.setLayoutManager(layoutManager);
        rcview.setAdapter(testAdapter);

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
            list.add(c++);
            testAdapter.notifyItemInserted(c-1);
        } else if(id== R.id.action_del) {
            --c;
            list.remove(c-1);
            testAdapter.notifyItemRemoved(c-1);        }

        return super.onOptionsItemSelected(item);
    }

}
