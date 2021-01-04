package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.WorkItemListBinding;

import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.wordViewHolder> {
    //1. añadir lista de string que contendra los datos
    private List<String> mWordList;
    private PasarElemento pasarElemento;
    //8. creamos un constructor para pasar el listado de datos al instanciar el adapter
    public WordsAdapter(List<String>mWordList, PasarElemento pasarElemento){
        this.mWordList = mWordList;
        this.pasarElemento = pasarElemento;
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
        //5. indicar que retorna el tamaño del listado
        return mWordList.size();
    }

    //2. crear clase interna llamada xxx ViewHolder
    public class wordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView;
        public wordViewHolder(@NonNull WorkItemListBinding binding){
            super(binding.getRoot());
            textView = binding.textView;
            itemView.setOnClickListener(this);
        }
        public  void onClick(View v){
            int position = getLayoutPosition();
            String element = mWordList.get(position);
            //Toast.makeText(v.getContext(),"CLICK "+element,Toast.LENGTH_LONG).show();
            mWordList.set(position,element+" CLICK");
            notifyDataSetChanged();
            pasarElemento.passElement(element);
        }
    }
    //interface que recibira la palabra
interface PasarElemento{
   void passElement(String elemento);

}

}
