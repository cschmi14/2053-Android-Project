package com.example.project3;

import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class Pokemon {
    private WeakReference<TextView> mName;
    private WeakReference<ImageView> mIcon;
    private WeakReference<TextView> mHP;
    private WeakReference<TextView> mSpAtk;
    private WeakReference<TextView> mAttack;
    private WeakReference<TextView> mSpDef;
    private WeakReference<TextView> mDefense;
    private WeakReference<TextView> mSpeed;
    private WeakReference<TextView> mDescription;
    private WeakReference<TextView> mType;
    private WeakReference<TextView> mDexNumber;
}
