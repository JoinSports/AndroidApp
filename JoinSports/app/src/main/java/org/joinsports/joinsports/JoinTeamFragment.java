package org.joinsports.joinsports;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.joinsports.joinsports.entity.Team;
import org.joinsports.joinsports.utils.CustomFragment;

/**
 * Created by Alex on 14.06.2017.
 */

public class JoinTeamFragment extends CustomFragment implements AppController {

    private JoinTeamModel model;
    private int teamToJoinId;
    private Team teamToJoin;
    private TextView teamName;
    private FeedbackTextView feedback;

    public JoinTeamFragment(int teamId) {
        this.teamToJoinId = teamId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_join_team, container, false);
        model = new JoinTeamModel(this);
        registerEventHandlers(view);
        setupControls(view);
        displayData();
        return view;
    }

    private void registerEventHandlers(View view) {
        Button joinTeamBt = (Button)view.findViewById(R.id.join_team_bt_joinTeam);
        joinTeamBt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //go to home fragment
                model.joinTeam(teamToJoinId, Registry.user.getId());
                replaceFragmentWith(getActivity(), R.id.fragment_container, new HomeFragment());
            }
        });
        Button abortBt = (Button)view.findViewById(R.id.join_team_bt_abort);
        abortBt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //go to read all unjoined teams fragment
                replaceFragmentWith(getActivity(), R.id.fragment_container, new ReadAllUnjoinedTeamsFragment());
            }
        });
    }

    private void setupControls(View view) {
        teamName = (TextView)view.findViewById(R.id.join_team_tv_teamName);
        feedback = new FeedbackTextView((TextView)view.findViewById(R.id.join_team_tv_feedback));
    }

    private void displayData() {
        teamToJoin = model.getTeam(teamToJoinId);
        teamName.setText(teamToJoin.getTeamName());
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
