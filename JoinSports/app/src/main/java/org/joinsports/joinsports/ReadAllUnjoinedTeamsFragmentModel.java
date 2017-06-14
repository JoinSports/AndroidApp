package org.joinsports.joinsports;

import org.joinsports.joinsports.dao.TeamDAO;
import org.joinsports.joinsports.entity.Team;
import org.joinsports.joinsports.mysqldao.TeamDAOMysql;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 14.06.2017.
 */

public class ReadAllUnjoinedTeamsFragmentModel {

    public List<Team> getUnjoinedTeams() {
        List<Team> result = new ArrayList<>();
        TeamDAO teamDAO = new TeamDAOMysql(Registry.dbc);
        //retrieve ids of all unjoined teams
        List<Integer> unjoinedTeamIds = teamDAO.retrieveAllUnjoinedTeamsByUserId(Registry.user.getId());
        //retrieve every unjoined team
        for (int unjoinedTeamId: unjoinedTeamIds) {
            Team unjoinedTeam = teamDAO.retrieveById(unjoinedTeamId);
            if (unjoinedTeam != null) {
                result.add(unjoinedTeam);
            }
        }
        System.out.println(result);
        //return unjoined teams
        return result;
    }

}
