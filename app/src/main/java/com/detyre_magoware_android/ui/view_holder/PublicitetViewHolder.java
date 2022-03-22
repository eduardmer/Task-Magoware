package com.detyre_magoware_android.ui.view_holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.detyre_magoware_android.BR;
import com.detyre_magoware_android.data_model.Programe;
import com.detyre_magoware_android.databinding.PublicitetLayoutBinding;

public class PublicitetViewHolder extends RecyclerView.ViewHolder {
    PublicitetLayoutBinding binding;

    public PublicitetViewHolder(@NonNull PublicitetLayoutBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }

    public void bind(Programe data){
        binding.setVariable(BR.data, data);
        binding.executePendingBindings();
    }
}
