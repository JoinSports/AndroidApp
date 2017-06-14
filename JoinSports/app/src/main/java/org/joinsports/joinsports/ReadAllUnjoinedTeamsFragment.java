package org.joinsports.joinsports;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.joinsports.joinsports.entity.Team;
import org.joinsports.joinsports.utils.CustomFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadAllUnjoinedTeamsFragment extends CustomFragment {

    private RecyclerView recyclerView;
    private List<Team> teamList;
    private TeamAdapter teamAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_all_unjoined_teams, container, false);
        registerEventHandlers(view);
        setupControls(view);
        return view;
    }

    private void registerEventHandlers(View view) {
        Button bt = (Button)view.findViewById(R.id.read_all_unjoined_teams_bt_createTeam);
        bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //go to home fragment
                replaceFragmentWith(getActivity(), R.id.fragment_container, new CreateTeamFragment());
            }
        });
    }

    private void setupControls(View view) {
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        teamList = new ArrayList<>();
        teamAdapter = new TeamAdapter(teamList);
        //add layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        //add animator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // add ItemDecoration
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        // set the Adapter
        recyclerView.setAdapter(teamAdapter);
        // add OnItemTouchListener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Team team = teamList.get(position);
                Toast.makeText(getActivity().getApplicationContext(), team.getTeamName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        addSampleData();
    }

    private void addSampleData() {
        Team team;
        team = new Team();
        team.setTeamName("A Team");
        teamList.add(team);
        team = new Team();
        team.setTeamName("B Team");
        teamList.add(team);
        team = new Team();
        team.setTeamName("C Team");
        teamList.add(team);
        team = new Team();
        team.setTeamName("D Team");
        teamList.add(team);
    }

}
