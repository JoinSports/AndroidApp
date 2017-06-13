package org.joinsports.joinsports.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import org.joinsports.joinsports.R;

/**
 * Created by Alex on 11.06.2017.
 */

public abstract class CustomFragment extends android.support.v4.app.Fragment {

    protected void replaceFragmentWith(FragmentActivity fragmentActivity, int containerViewId, Fragment otherFragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, otherFragment);
        fragmentTransaction.commit();
    };

}
