package org.joinsports.joinsports;

import org.joinsports.joinsports.dao.TeamDAO;
import org.joinsports.joinsports.entity.Team;
import org.joinsports.joinsports.mysqldao.TeamDAOMysql;

/**
 * Created by Alex on 13.06.2017.
 */

public class CreateTeamModel {

    private AppController controller;

    public CreateTeamModel(AppController controller) {
        this.controller = controller;
    }

    public boolean createNewTeam(String teamName) {
        if (!checkTeamName(teamName)) {
            controller.showError("Teamname existiert bereits.");
            return false;
        }
        if (doCreateNewTeam(teamName, Registry.user.getId())) {
            controller.showSuccess("Team wurde erstellt.");
            return true;
        } else {
            controller.showError("Team konnte nicht erstellt werden.");
            return false;
        }
    }

    private boolean checkTeamName(String teamName) {
        //check empty
        if (teamName.equals("")) {
            controller.showError("Teamname darf nicht leer sein.");
            return false;
        }
        //check existing duplicate
        TeamDAO teamDAO = new TeamDAOMysql(Registry.dbc);
        return teamDAO.doesTeamNameExist(teamName);
    }

    private boolean doCreateNewTeam(String teamName, int teamLeaderId) {
        TeamDAO teamDAO = new TeamDAOMysql(Registry.dbc);
        Team newTeam = new Team();
        newTeam.setTeamName(teamName);
        return teamDAO.create(newTeam, teamLeaderId);
    }

}
