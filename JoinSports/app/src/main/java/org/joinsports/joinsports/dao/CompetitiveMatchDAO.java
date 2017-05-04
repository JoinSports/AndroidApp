package org.joinsports.joinsports.dao;

import org.joinsports.joinsports.entity.CompetitiveMatch;
import org.joinsports.joinsports.entity.Team;

import java.util.List;

/**
 * Created by Alex on 02.05.2017.
 */

public interface CompetitiveMatchDAO extends CommonDAO {

    public void create(CompetitiveMatch match, int requestingTeamId, int requestedTeamId, int locationId);

    public CompetitiveMatch retrieveById(int id);

    public boolean update(CompetitiveMatch match);

    public boolean deleteById(int id);

}
