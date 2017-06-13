package org.joinsports.joinsports;


import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.joinsports.joinsports.dao.NormalUserDAO;
import org.joinsports.joinsports.entity.NormalUser;
import org.joinsports.joinsports.mysqldao.DBConnector;
import org.joinsports.joinsports.mysqldao.NormalUserDAOMysql;
import org.joinsports.joinsports.utils.CustomFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends CustomFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);
        registerEventHandlers(view);
        displayUserData(view);
        return view;
    }

    private void registerEventHandlers(View view) {
        Button button = (Button) view.findViewById(R.id.read_user_bt_editProfile);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //change to update user fragment
                replaceFragmentWith(getActivity(), R.id.fragment_container, new UpdateUserFragment());
            }
        });
    }

    private void displayUserData(View view) {
        NormalUserDAO normalUserDAO = new NormalUserDAOMysql(Global.dbc);
        NormalUser currentUser = normalUserDAO.retrieveById(Global.user.getId());
        if (currentUser != null) {
            ((TextView)view.findViewById(R.id.read_user_tv_username)).setText(currentUser.getUsername());
            ((TextView)view.findViewById(R.id.read_user_tv_firstName)).setText(currentUser.getFirstName());
            ((TextView)view.findViewById(R.id.read_user_tv_lastName)).setText(currentUser.getLastName());
            ((TextView)view.findViewById(R.id.read_user_tv_emailAddress)).setText(currentUser.getEmailAddress());
        } else {
            throw new RuntimeException("couldn't retrieve user by user id");
        }
    }
}
