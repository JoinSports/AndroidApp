package org.joinsports.joinsports.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Timo on 23.11.2016.
 */

public class Event {

    private int id;
    private String name;
    private String description;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
