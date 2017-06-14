package org.joinsports.joinsports;

/**
 * Created by Timo on 31.05.2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.joinsports.joinsports.entity.Team;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<ListElementTeamsViewHolder> {

    private List<Team> teamList;

    public TeamAdapter(List<Team> moviesList) {
        this.teamList = moviesList;
    }

    @Override
    public ListElementTeamsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listElement = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element_teams, parent, false);
        return new ListElementTeamsViewHolder(listElement);
    }

    @Override
    public void onBindViewHolder(ListElementTeamsViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.teamName.setText(team.getTeamName());
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }
}
