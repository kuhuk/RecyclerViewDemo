package com.example.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private final ArrayList<String> arrayList;

    RecyclerViewAdapter(ArrayList<String> strings) {
        arrayList = strings;
    }

    //inner class - ViewHolder
    static class MyViewHolder extends RecyclerView.ViewHolder {

        final TextView textView1;
        final TextView textView2;
        final TextView textView3;
        final Button mButton;

        MyViewHolder(View v) {
            super(v);
            this.textView1 = v.findViewById(R.id.tv1);
            this.textView2 = v.findViewById(R.id.tv2);
            this.textView3 = v.findViewById(R.id.tv3);
            this.mButton = v.findViewById(R.id.btn_paynow);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card, viewGroup, false);

        view.setOnClickListener(MainActivity.myOnClickListener);
        return new MyViewHolder(view);
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
