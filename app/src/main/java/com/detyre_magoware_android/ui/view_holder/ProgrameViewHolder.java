package com.detyre_magoware_android.ui.view_holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.detyre_magoware_android.BR;
import com.detyre_magoware_android.data_model.Programe;
import com.detyre_magoware_android.databinding.ProgramLayoutBinding;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ProgrameViewHolder extends RecyclerView.ViewHolder {
    ProgramLayoutBinding binding;
    final SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

    public ProgrameViewHolder(@NonNull ProgramLayoutBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }

    public void bind(Programe data){
        binding.setVariable(BR.data, data);
        binding.startTime.setText(dateFormat.format(data.getStartTime()));
        binding.endTime.setText(dateFormat.format(data.getEndTime()));
        binding.executePendingBindings();
    }
}
