package org.joinsports.joinsports.dao;

import org.joinsports.joinsports.entity.Team;

import java.util.List;

/**
 * Created by Alex on 19.04.2017.
 */

public interface TeamDAO extends CommonDAO {

    //a team has to have a team leader
    public boolean create(Team team, int teamLeaderId);

    public boolean doesTeamNameExist(String teamName);

    public Team retrieveById(int id);

    public boolean update(Team team);

    public boolean deleteById(int id);

    public List<Integer> retrieveAllTeamIdsByUserId(int userId);

    public List<Integer> retrieveAllTeamIdsByTeamLeaderId(int teamLeaderId);

}
