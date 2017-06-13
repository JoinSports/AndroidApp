package org.joinsports.joinsports;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.joinsports.joinsports.utils.CustomFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends CustomFragment implements AppController {

    private UpdateUserModel model;
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
        model = new UpdateUserModel(this);
        oldPassword = (EditText)view.findViewById(R.id.update_user_tf_oldPassword);
        newPassword = (EditText)view.findViewById(R.id.update_user_tf_newPassword);
        newPasswordRepeat = (EditText)view.findViewById(R.id.update_user_tf_newPasswordRepeat);
        email = (EditText)view.findViewById(R.id.update_user_tf_emailAddress);
        emailRepeat = (EditText)view.findViewById(R.id.update_user_tf_emailAddressRepeat);
        feedback = new FeedbackTextView((TextView)view.findViewById(R.id.update_user_tv_feedback));
        registerEventHandlers(view);
        return view;
    }

    private void registerEventHandlers(View view) {
        final Button commitChangesBt = (Button) view.findViewById(R.id.update_user_bt_commitChanges);
        commitChangesBt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean success;
                success = model.updateUserData(oldPassword.getText().toString(),
                        newPassword.getText().toString(),
                        newPasswordRepeat.getText().toString(),
                        email.getText().toString(),
                        emailRepeat.getText().toString());
                if (success) {
                    replaceFragmentWith(getActivity(), R.id.fragment_container, new HomeFragment());
                }
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
    }

    @Override
    public void showSuccess(String response) {
        feedback.displaySuccess(response);
    }

    @Override
    public void showError(String response) {
        feedback.displayError(response);
    }
}
