package com.example.recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recyclerview.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
private FragmentFirstBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("LISTADO: ",workList().toString());
        //se instancia el adapter
        WordsAdapter mAdapter = new WordsAdapter(workList());
        //se pasa el adapter
        binding.RV.setAdapter(mAdapter);
        //se inica al recycler como mostrar los elementos
        binding.RV.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    private List<String> workList(){
        List<String> listado = new ArrayList<>();
        for (int i=0; i<100; i++){
            listado.add("Palabra "+i);
        }
        return listado;
    }
}