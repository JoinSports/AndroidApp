package org.joinsports.joinsports;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.joinsports.joinsports.utils.CustomFragment;


public class CreateTeamFragment extends CustomFragment implements AppController {

    private CreateTeamModel model;
    private EditText teamName;
    private FeedbackTextView feedback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_team, container, false);
        model = new CreateTeamModel(this);
        registerEventHandlers(view) ;
        setupControls(view);
        return view;
    }

    private void registerEventHandlers(View view) {
        Button bt = (Button)view.findViewById(R.id.create_team_bt_createTeam);
        bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean success;
                success = model.createNewTeam(teamName.getText().toString());
                if (success) {
                    //go to Home Fragment
                    replaceFragmentWith(getActivity(), R.id.fragment_container, new HomeFragment());
                }
            }
        });
    }

    private void setupControls(View view) {
        teamName = (EditText)view.findViewById(R.id.create_team_tf_teamName);
        feedback = new FeedbackTextView((TextView)view.findViewById(R.id.create_team_tv_feedback));
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
