package org.joinsports.joinsports.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Timo on 23.11.2016.
 */

public class Event {
    /* A match without any competitive intention */

    // Attributes
    private EventHost eventHost;
    private ArrayList<NormalUser> eventMembers;
    private Location location;
    private Date date;
    private String description;

    // Constructor
    Event(EventHost pEventHost) {
        eventHost = pEventHost;
        eventMembers = new ArrayList();
    }

    // Functions



    // Get- & Set- Methods
    public EventHost getEventHost() {
        return eventHost;
    }

    public void setEventHost(EventHost eventHost) {
        this.eventHost = eventHost;
    }

    public ArrayList<NormalUser> getEventMembers() {
        return eventMembers;
    }

    /*
    public void setEventMembers(ArrayList<NormalUser> eventMembers) {
        this.eventMembers = eventMembers;
    }*/

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
