package org.joinsports.joinsports;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.joinsports.joinsports.dao.TeamDAO;
import org.joinsports.joinsports.entity.Team;
import org.joinsports.joinsports.mysqldao.TeamDAOMysql;
import org.joinsports.joinsports.utils.CustomFragment;


public class CreateTeamFragment extends CustomFragment {

    private EditText teamName;
    private FeedbackTextView feedback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_team, container, false);
        registerEventHandlers(view) ;
        setupControlls(view);
        return view;
    }

    private void registerEventHandlers(View view) {
        Button bt = (Button)view.findViewById(R.id.create_team_bt_createTeam);
        bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //go to home fragment
                //replaceFragmentWith(getActivity(), R.id.fragment_container, new CreateTeamFragment());
                doCreateNewTeam();
            }
        });
    }

    private void setupControlls(View view) {
        teamName = (EditText)view.findViewById(R.id.create_team_tf_teamName);
        feedback = new FeedbackTextView((TextView)view.findViewById(R.id.create_team_tv_feedback));
    }

    private void doCreateNewTeam() {
        if (!checkTeamName(teamName.getText().toString())) {
            feedback.displayError("Teamname existiert bereits.");
            return;
        }
        TeamDAO teamDAO = new TeamDAOMysql(Global.dbc);
        if (createTeam(teamName.getText().toString(), Global.user.getId())) {
            feedback.displaySuccess("Team wurde erstellt.");
            //go to Home Fragment
            replaceFragmentWith(getActivity(), R.id.fragment_container, new HomeFragment());
        } else {
            feedback.displayError("Team konnte nicht erstellt werden.");
        }
    }

    private boolean checkTeamName(String teamName) {
        TeamDAO teamDAO = new TeamDAOMysql(Global.dbc);
        return teamDAO.doesTeamNameExist(teamName);
    }

    private boolean createTeam(String teamName, int teamLeaderId) {
        TeamDAO teamDAO = new TeamDAOMysql(Global.dbc);
        Team newTeam = new Team();
        newTeam.setTeamName(teamName);
        return teamDAO.create(newTeam, teamLeaderId);
    }

}
