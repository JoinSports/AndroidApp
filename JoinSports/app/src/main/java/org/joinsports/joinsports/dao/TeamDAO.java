package org.joinsports.joinsports.dao;

import org.joinsports.joinsports.entity.Team;

/**
 * Created by Alex on 19.04.2017.
 */

public interface TeamDAO {

    public boolean create(Team team);

    //returns null if there is no user with given username
    public Team retrieveByTeamname(String teamname);

    public boolean update(Team team);

    public boolean delete(Team team);

}
