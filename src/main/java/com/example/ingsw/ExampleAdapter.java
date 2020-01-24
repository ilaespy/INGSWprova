package com.example.ingsw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
     private ArrayList<Struttura> mExemplelist;
     private OnItemClickListener mListenr;


     public interface OnItemClickListener{
         void onItemClick(int position);
     }

     public void setOnItemClickListener(OnItemClickListener listener){
         mListenr = listener;
     }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
  //      public ImageView imageView;
        public TextView textView;
        public TextView textView2;
        public TextView textViewt;
        public TextView textViewtip;
        public TextView textViewns;
        public TextView textViewa;
        public TextView textViewc;


    public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
        super(itemView);
    //    imageView = itemView.findViewById(R.id.ImageView);
        textView = itemView.findViewById(R.id.textview);
        textView2 = itemView.findViewById(R.id.textview2);
        textViewt = itemView.findViewById(R.id.textviewte);
        textViewtip=itemView.findViewById(R.id.tip);
        textViewa=itemView.findViewById(R.id.open);
        textViewc=itemView.findViewById(R.id.close);
        textViewns=itemView.findViewById(R.id.stell);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(listener!= null){
                 int position = getAdapterPosition();
                 if (position != RecyclerView.NO_POSITION){
                     listener.onItemClick(position);
                 }
             }
            }
        });
    }}
    public ExampleAdapter(ArrayList<Struttura> struttura){
        mExemplelist = struttura;
    }
    @Override

    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exitems, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListenr);
        return evh;
    }
    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Struttura currentStruttura = mExemplelist.get(position);
      //  holder.imageView.setImageResource(currentStruttura.getFoto());
        holder.textView.setText(currentStruttura.getNome());
        holder.textView2.setText(currentStruttura.getIndirizzo());
        holder.textViewt.setText(currentStruttura.getTel());
        holder.textViewtip.setText(currentStruttura.getTipo());
        holder.textViewa.setText(Integer.toString(currentStruttura.getApertura()));
        holder.textViewc.setText(Integer.toString(currentStruttura.getChiusura()));
        holder.textViewns.setText(Integer.toString(currentStruttura.getnStelle()));

    }

    @Override
    public int getItemCount() {
        return mExemplelist.size();
    }

   }
