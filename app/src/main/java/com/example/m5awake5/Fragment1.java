package com.example.m5awake5;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.m5awake5.databinding.Fragment1Binding;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {

   // public ItemsBinding binding;
   private Fragment1Binding binding;
    private final List<String> dataList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = Fragment1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapterRecycler adapter = new adapterRecycler(setData());

        // Obtenemos elemento seleccionado
        adapter.setOnItemClickListener(position -> {
            // Tomamos (get), cambiamos (set) el elemento seleccionado y notificamos el cambio
            String modifiedData = "Clicked " + dataList.get(position);
            dataList.set(position, modifiedData);
            adapter.notifyItemChanged(position);
        });

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setHasFixedSize(true);
    }

    private List<String> setData(){
        for (int i=1; i<=10000; i++){
            dataList.add("Word " + i);
        }
        return dataList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}