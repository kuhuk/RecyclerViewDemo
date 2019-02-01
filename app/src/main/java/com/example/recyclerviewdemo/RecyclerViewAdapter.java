package com.example.recyclerviewdemo;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    ArrayList<String> arrayList;
    Context mContext;
    CardView mCardView;

    RecyclerViewAdapter(ArrayList<String> strings, Context context) {
        arrayList = strings;
        this.mContext = context;
    }

    //inner class - ViewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView1, textView2, textView3;
        Button mButton;

        public MyViewHolder(View v) {
            super(v);
            this.textView1 = (TextView) v.findViewById(R.id.tv1);
            this.textView2 = (TextView) v.findViewById(R.id.tv2);
            this.textView3 = (TextView) v.findViewById(R.id.tv3);
            this.mButton = (Button) v.findViewById(R.id.button);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card, viewGroup, false);

        view.setOnClickListener(MainActivity.myOnClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.textView1.setText(arrayList.get(i));
        myViewHolder.textView2.setText(arrayList.get(i));
        myViewHolder.textView3.setText(arrayList.get(i));
        myViewHolder.mButton.setText(arrayList.get(i));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
