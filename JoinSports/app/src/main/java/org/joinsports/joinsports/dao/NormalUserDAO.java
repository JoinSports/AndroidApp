package org.joinsports.joinsports.dao;

import org.joinsports.joinsports.entity.NormalUser;

import java.util.List;

/**
 * Created by Alex on 18.04.2017.
 */

public interface NormalUserDAO extends CommonDAO {

    public boolean checkCredentials(String username, String password);

    public boolean create(NormalUser user);

    //returns null if there is no user with given username
    public NormalUser retrieveByUsername(String username);

    public NormalUser retrieveById(int id);

    public boolean update(NormalUser user);

    public boolean deleteById(int id);

    public NormalUser retrieveEventHostByEventId(int eventId);

    public NormalUser retrieveTeamLeaderByTeamId(int teamId);

    public List<Integer> retrieveAllTeamMemberIdsByTeamId(int teamId);

}
