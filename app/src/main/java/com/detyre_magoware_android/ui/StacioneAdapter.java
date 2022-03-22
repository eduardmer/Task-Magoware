package com.detyre_magoware_android.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.detyre_magoware_android.BR;
import com.detyre_magoware_android.data_model.Stacione;
import com.detyre_magoware_android.databinding.StacionLayoutBinding;

import java.util.ArrayList;

public class StacioneAdapter extends RecyclerView.Adapter<StacioneAdapter.MyViewHolder> {

    final Context context;
    final ArrayList<Stacione> stacione;

    public StacioneAdapter(Context context, ArrayList<Stacione> stacione){
        this.context=context;
        this.stacione=stacione;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        StacionLayoutBinding binding;

        public MyViewHolder(@NonNull StacionLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bind(Context context, Stacione data){
            binding.setVariable(BR.data, data);
            binding.image.setImageResource(data.getImage());
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            binding.recyclerView.setAdapter(new ProgrameAdapter(data.getPrograme()));
            binding.executePendingBindings();
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StacionLayoutBinding itemBinding=StacionLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(context, stacione.get(position));
    }

    @Override
    public int getItemCount() {
        return stacione.size();
    }

}
