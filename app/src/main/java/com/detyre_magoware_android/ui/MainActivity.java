package com.detyre_magoware_android.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.detyre_magoware_android.R;
import com.detyre_magoware_android.ViewModelProviderFactory;
import com.detyre_magoware_android.data.DataProvider;
import com.detyre_magoware_android.data_model.Programe;
import com.detyre_magoware_android.data_model.Stacione;
import com.detyre_magoware_android.databinding.ActivityMainBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;
    final CompositeDisposable compositeDisposable=new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel= new ViewModelProvider(this,new ViewModelProviderFactory(new DataProvider())).get(MainViewModel.class);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        compositeDisposable.add(viewModel.getStacione().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                staciones -> {
                    binding.recyclerView.setAdapter(new StacioneAdapter(this, (ArrayList<Stacione>) staciones));
                },
                error -> Log.i("pergjigja", error.toString())
        ));
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}