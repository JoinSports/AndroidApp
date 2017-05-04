package org.joinsports.joinsports.dao;

import org.joinsports.joinsports.entity.Location;

/**
 * Created by Alex on 02.05.2017.
 */

public interface LocationDAO {

    public boolean create(Location location);

    public Location retrieveById(int id);

    public boolean update(Location location);

    public boolean deleteById(int id);

    public Location retrieveEventLocationByEventId(int eventId);

    public Location retrieveMatchLocationByMatchId(int matchId);

}
