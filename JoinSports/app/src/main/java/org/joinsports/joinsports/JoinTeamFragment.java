package org.joinsports.joinsports;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.joinsports.joinsports.utils.CustomFragment;

/**
 * Created by Alex on 14.06.2017.
 */

public class JoinTeamFragment extends CustomFragment {

    public JoinTeamFragment(int teamId) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_join_team, container, false);
        return view;
    }

}
