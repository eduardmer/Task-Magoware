package com.detyre_magoware_android.data_model;

import java.util.ArrayList;

public class Stacione {

    private String name;
    private int image;
    private ArrayList<Programe> programe;

    public Stacione(String name, int image, ArrayList<Programe> programe){
        this.name=name;
        this.image=image;
        this.programe=programe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ArrayList<Programe> getPrograme() {
        return programe;
    }

    public void setPrograme(ArrayList<Programe> programe) {
        this.programe = programe;
    }
}
