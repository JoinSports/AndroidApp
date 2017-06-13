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
public class UpdateUserFragment extends CustomFragment {

    private EditText oldPassword;
    private EditText newPassword;
    private EditText newPasswordRepeat;
    private EditText email;
    private EditText emailRepeat;
    private FeedbackTextView feedback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);

        final Button commitChangesBt = (Button) view.findViewById(R.id.update_user_bt_commitChanges);
        commitChangesBt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateUserData();
            }
        });

        final Button abortChangesBt = (Button) view.findViewById(R.id.update_user_bt_abortChanges);
        abortChangesBt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //go to home fragment
                replaceFragmentWith(getActivity(), R.id.fragment_container, new HomeFragment());
            }
        });

        oldPassword = (EditText)view.findViewById(R.id.update_user_tf_oldPassword);
        newPassword = (EditText)view.findViewById(R.id.update_user_tf_newPassword);
        newPasswordRepeat = (EditText)view.findViewById(R.id.update_user_tf_newPasswordRepeat);
        email = (EditText)view.findViewById(R.id.update_user_tf_emailAddress);
        emailRepeat = (EditText)view.findViewById(R.id.update_user_tf_emailAddressRepeat);
        feedback = new FeedbackTextView((TextView)view.findViewById(R.id.update_user_tv_feedback));

        return view;
    }

    private void updateUserData() {
        if(!checkPassword()) return;
        if(!checkEmail()) return;
        //push new data to db
        NormalUserDAO userDAO = new NormalUserDAOMysql(Global.dbc);
        NormalUser updatedUser = Global.user;
        updatedUser.setEmailAddress(email.getText().toString());
        updatedUser.setPassword(newPassword.getText().toString());
        if (userDAO.update(updatedUser)) {
            //update successful
            //update global user
            Global.onUpdatedUser(updatedUser);
            feedback.displaySuccess("Änderungen übernommen.");
        } else {
            //update not successful
            feedback.displayError("Änderungen konnten nicht übernommen werden.");
            return;
        }
        //go to home fragment
        replaceFragmentWith(getActivity(), R.id.fragment_container, new HomeFragment());
    }

    private boolean checkPassword() {
        //check not empty
        if (newPassword.getText().toString().equals("")) {
            feedback.displayError("Das neue Kennwort darf nicht leer sein.");
            return false;
        }
        //check equality
        if (!newPassword.getText().toString().equals(newPasswordRepeat.getText().toString())) {
            feedback.displayError("Das neue Kennwort wurde falsch wiederholt.");
            return false;
        }
        //check if old password is valid
        NormalUserDAO userDAO = new NormalUserDAOMysql(Global.dbc);
        if (!userDAO.checkCredentials(Global.authusername, oldPassword.getText().toString())) {
            feedback.displayError("Das alte Kennwort ist nicht gültig.");
            return false;
        }
        return true;
    }

    private boolean checkEmail() {
        //check not empty
        if (email.getText().toString().equals("")) {
            feedback.displayError("Die neue Email-Adresse darf nicht leer sein.");
            return false;
        }
        //check equality
        if (!email.getText().toString().equals(emailRepeat.getText().toString())) {
            feedback.displayError("Die neue Email-Adresse wurde falsch wiederholt.");
            return false;
        }
        return true;
    }

}
