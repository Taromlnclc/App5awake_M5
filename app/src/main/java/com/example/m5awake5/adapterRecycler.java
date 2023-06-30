package com.example.m5awake5;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.m5awake5.databinding.ItemsBinding;
import java.util.List;


public class adapterRecycler extends RecyclerView.Adapter<adapterRecycler.ViewHolder> {
    private final List<String> dataList;
    public adapterRecycler(List<String> dataList) {
        this.dataList = dataList;
    }
    public static OnItemClickListener clickListener;

    // Interface para click
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
   // La escucha del click
    public void setOnItemClickListener(OnItemClickListener listener) {
        clickListener = listener;
    }

    // Contiene la vista de cada elemento de datos
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ItemsBinding binding;

        public ViewHolder(ItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (clickListener != null && position != RecyclerView.NO_POSITION) {
                    clickListener.onItemClick(position);
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsBinding binding = ItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String data = dataList.get(position);
        holder.binding.textFragmento.setText(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
