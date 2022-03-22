package com.detyre_magoware_android;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.detyre_magoware_android.data.DataProvider;
import com.detyre_magoware_android.ui.main.MainViewModel;

public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    final DataProvider dataProvider;

    public ViewModelProviderFactory(DataProvider dataProvider){
        this.dataProvider=dataProvider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(dataProvider);
    }
}
