package org.joinsports.joinsports;

import org.joinsports.joinsports.dao.NormalUserDAO;
import org.joinsports.joinsports.dao.TeamDAO;
import org.joinsports.joinsports.entity.Team;
import org.joinsports.joinsports.mysqldao.NormalUserDAOMysql;
import org.joinsports.joinsports.mysqldao.TeamDAOMysql;

/**
 * Created by Alex on 14.06.2017.
 */

public class JoinTeamModel {

    AppController controller;

    public JoinTeamModel(AppController controller) {
        this.controller = controller;
    }

    public Team getTeam(int teamId) {
        TeamDAO teamDAO = new TeamDAOMysql(Registry.dbc);
        Team teamToJoin = teamDAO.retrieveById(teamId);
        if (teamToJoin == null) {
            throw new RuntimeException();
        }
        return teamToJoin;
    }

    public boolean joinTeam(int teamId, int userId) {
        TeamDAO teamDAO = new TeamDAOMysql(Registry.dbc);
        if (teamDAO.joinTeamById(teamId, userId)) {
            controller.showSuccess("Team beigetreten.");
            return true;
        } else {
            controller.showError("Dem Team konnte nicht beigetreten werden.");
            return false;
        }
    }

}
