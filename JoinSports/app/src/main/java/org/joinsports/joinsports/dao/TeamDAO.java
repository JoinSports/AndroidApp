package org.joinsports.joinsports.dao;

import org.joinsports.joinsports.entity.Team;

import java.util.List;

/**
 * Created by Alex on 19.04.2017.
 */

public interface TeamDAO extends CommonDAO {

    //a team has to have a team leader
    public boolean create(Team team, int teamLeaderId);

    public Team retrieveById(int id);

    public boolean update(Team team);

    public boolean deleteById(int id);

    public List<Team> retrieveAllTeamsByUserId(int userId);

    public List<Team> retrieveAllTeamsByTeamLeaderId(int teamLeaderId);

}
