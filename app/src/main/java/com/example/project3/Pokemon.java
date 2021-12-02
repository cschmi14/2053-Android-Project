package com.example.project3;

import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class Pokemon {
    private String name;
    private String icon;
    private int[] stats;
    private String description;
    private String type;
    private int dexNumber;

    public Pokemon(String name)
    {
        this.name = name;
    }
}
