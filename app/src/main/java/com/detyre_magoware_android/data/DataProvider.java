package com.detyre_magoware_android.data;

import com.detyre_magoware_android.R;
import com.detyre_magoware_android.data_model.Programe;
import com.detyre_magoware_android.data_model.Stacione;
import java.util.ArrayList;
import io.reactivex.rxjava3.core.Single;

public class DataProvider {

    public Single<ArrayList<Stacione>> getData(){
        return Single.fromCallable(() -> {
            ArrayList<Stacione> stacione=new ArrayList<>();

            ArrayList<Programe> programe=new ArrayList<>();
            programe.add(new Programe("A","01:30"));
            programe.add(new Programe("C","01:40"));
            programe.add(new Programe("D","00:10"));
            programe.add(new Programe("E","01:25"));
            programe.add(new Programe("F","02:00"));
            programe.add(new Programe("GJ","00:58"));
            programe.add(new Programe("I","01:19"));
            programe.add(new Programe("K","02:30"));
            programe.add(new Programe("LL","01:31"));
            stacione.add(new Stacione("Stacioni_1", R.drawable.klan, programe));

            ArrayList<Programe> programe2=new ArrayList<>();
            programe2.add(new Programe("B","0:35"));
            programe2.add(new Programe("Ç","2:10"));
            programe2.add(new Programe("Dh","1:20"));
            programe2.add(new Programe("Ë","1:40"));
            programe2.add(new Programe("G","1:12"));
            programe2.add(new Programe("H","1:16"));
            programe2.add(new Programe("J","3:20"));
            programe2.add(new Programe("L","1:30"));
            stacione.add(new Stacione("Stacioni_2", R.drawable.top_channel, programe2));

            return stacione;
        });
    }

}
