package org.joinsports.joinsports.entity;

import java.util.Date;

/**
 * Created by Alex on 02.05.2017.
 */

public class CompetitiveMatch extends Match {

    private boolean requestAccepted;

    public boolean isRequestAccepted() {
        return requestAccepted;
    }

    public void setRequestAccepted(boolean requestAccepted) {
        this.requestAccepted = requestAccepted;
    }

}

