package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.WorkItemListBinding;

import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.wordViewHolder> {
    //1. añadir lista de string que contendra los datos
    private List<String> mWordList;
    //8. creamos un constructor para pasar el listado de datos al instanciar el adapter
    public WordsAdapter(List<String>mWordList){
        this.mWordList = mWordList;
    }

    @NonNull
    @Override
    public wordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WorkItemListBinding binding = WorkItemListBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new wordViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull wordViewHolder holder, int position) {
        String word = mWordList.get(position);
        holder.textView.setText(word);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    //2. crear clase interna llamada xxx ViewHolder
    public class wordViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public wordViewHolder(@NonNull WorkItemListBinding binding){
            super(binding.getRoot());
            textView = binding.textView;
        }
    }


}
