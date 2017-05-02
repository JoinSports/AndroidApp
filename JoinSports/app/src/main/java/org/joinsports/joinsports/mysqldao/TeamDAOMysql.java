package org.joinsports.joinsports.mysqldao;

import org.joinsports.joinsports.dao.TeamDAO;
import org.joinsports.joinsports.entity.Team;

/**
 * Created by Alex on 22.04.2017.
 */

public class TeamDAOMysql extends AbstractDAOMysql implements TeamDAO {

    private DBConnector dbConnector;

    public TeamDAOMysql(DBConnector dbConnector) {
        super(dbConnector);
    }

    @Override
    public boolean create(Team team) {
        return false;
    }

    @Override
    public Team retrieveByTeamname(String teamname) {
        return null;
    }

    @Override
    public boolean update(Team team) {
        return false;
    }

    @Override
    public boolean delete(Team team) {
        return false;
    }

}
