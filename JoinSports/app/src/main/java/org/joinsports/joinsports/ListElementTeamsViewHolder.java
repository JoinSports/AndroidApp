package org.joinsports.joinsports;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Alex on 14.06.2017.
 */

public class ListElementTeamsViewHolder extends RecyclerView.ViewHolder {

    public TextView teamName;

    public ListElementTeamsViewHolder(View view) {
        super(view);
        teamName = (TextView)view.findViewById(R.id.tv_team_name);
    }

}