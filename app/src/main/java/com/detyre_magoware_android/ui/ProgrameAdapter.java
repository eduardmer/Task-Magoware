package com.detyre_magoware_android.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.detyre_magoware_android.data_model.Programe;
import com.detyre_magoware_android.databinding.ProgramLayoutBinding;
import com.detyre_magoware_android.databinding.PublicitetLayoutBinding;
import com.detyre_magoware_android.ui.view_holder.ProgrameViewHolder;
import com.detyre_magoware_android.ui.view_holder.PublicitetViewHolder;
import java.util.ArrayList;

public class ProgrameAdapter extends RecyclerView.Adapter {

    final ArrayList<Programe> programe;

    public ProgrameAdapter(ArrayList<Programe> programe){
        this.programe=programe;
    }

    @Override
    public int getItemViewType(int position) {
        if (programe.get(position).isPublicitet())
            return 0;
        else
            return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            PublicitetLayoutBinding itemBinding=PublicitetLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new PublicitetViewHolder(itemBinding);
        }
        else{
            ProgramLayoutBinding itemBinding=ProgramLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new ProgrameViewHolder(itemBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Programe item= programe.get(position);
        if (item.isPublicitet())
            ((PublicitetViewHolder) holder).bind(item);
        else
            ((ProgrameViewHolder) holder).bind(item);
    }

    @Override
    public int getItemCount() {
        return programe.size();
    }

}
