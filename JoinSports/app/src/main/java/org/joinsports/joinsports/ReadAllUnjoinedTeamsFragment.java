package org.joinsports.joinsports;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.joinsports.joinsports.dao.NormalUserDAO;
import org.joinsports.joinsports.entity.NormalUser;
import org.joinsports.joinsports.mysqldao.NormalUserDAOMysql;
import org.joinsports.joinsports.utils.CustomFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadAllUnjoinedTeamsFragment extends CustomFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_all_unjoined_teams, container, false);
        return view;
    }

}
