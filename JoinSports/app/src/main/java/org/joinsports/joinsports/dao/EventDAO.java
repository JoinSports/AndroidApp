package org.joinsports.joinsports.dao;

import org.joinsports.joinsports.entity.Event;
import org.joinsports.joinsports.entity.Location;
import org.joinsports.joinsports.entity.NormalUser;

/**
 * Created by Alex on 02.05.2017.
 */

public interface EventDAO extends CommonDAO {

    //an event has to have a location and an event host that can edit the event
    public boolean create(Event event, int locationId, int eventHost);

    public Event retrieveById(int id);

    public boolean update(Event event);

    public boolean deleteById(int id);

}
