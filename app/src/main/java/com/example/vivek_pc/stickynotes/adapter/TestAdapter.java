package com.example.vivek_pc.stickynotes.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vivek_pc.stickynotes.R;

import java.util.List;

/**
 * Created by vivek-pc on 11/22/2015.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder>{

    private List<Integer> data;

    public TestAdapter(List<Integer> data) {
        this.data = data;
    }

    static class TestViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text;

        public TestViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvitem,null);
        return new TestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        holder.text.setText("item no. "+data.get(position));
        holder.image.setImageResource(R.drawable.visa);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
