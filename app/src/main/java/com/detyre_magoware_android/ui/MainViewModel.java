package com.detyre_magoware_android.ui;

import android.util.Log;

import androidx.lifecycle.ViewModel;
import com.detyre_magoware_android.data.DataProvider;
import com.detyre_magoware_android.data_model.Programe;
import com.detyre_magoware_android.data_model.Stacione;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import io.reactivex.rxjava3.core.Single;

public class MainViewModel extends ViewModel {

    final DataProvider dataProvider;
    final SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

    public MainViewModel(DataProvider dataProvider){
        this.dataProvider=dataProvider;
    }

    public Single<ArrayList<Stacione>> getStacione(){
        return dataProvider.getData().map(staciones -> {
            Date date;
            try {
                date = dateFormat.parse("00:00:00");
            } catch (ParseException e) {
                e.printStackTrace();
                date=new Date();
            }
            for (int i=0;i<staciones.size();i++){
                long startTime=date.getTime();
                for (int j=0;j<staciones.get(i).getPrograme().size();j++){
                    Programe programe=staciones.get(i).getPrograme().get(j);
                    if (!programe.isPublicitet()) {
                        programe.setStartTime(startTime);
                        startTime = startTime + getDuration(programe.getDuration());
                        programe.setEndTime(startTime);
                        startTime = startTime + 120000;
                        staciones.get(i).getPrograme().add(j + 1, new Programe("Publicitet", "", true));
                    }

                }
            }
            return staciones;
        });
    }

    private long getDuration(String duration){
        String[] time = duration.split(":");
        return Long.parseLong(time[0])*3600*1000+Long.parseLong(time[1])*60*1000;
    }

}
