package com.example.breakthecode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CipherAdapter extends RecyclerView.Adapter<CipherAdapter.ViewHolder> {
    private ArrayList<CipherType> ciphers;
    ItemClicked activity;

    public CipherAdapter(Context context, ArrayList<CipherType> list){
        this.activity = (ItemClicked) context;
        this.ciphers = list;
    }

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvCipher;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCipher = itemView.findViewById(R.id.tvCipher);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(ciphers.indexOf((CipherType) v.getTag()));
                }
            });
        }
    }
    @NonNull
    @Override
    public CipherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CipherAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(ciphers.get(position));
        holder.tvCipher.setText(ciphers.get(position).getCipherType());
    }

    @Override
    public int getItemCount() {
        return ciphers.size();
    }
}
