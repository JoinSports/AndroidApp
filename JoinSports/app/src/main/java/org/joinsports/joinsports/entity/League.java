package org.joinsports.joinsports.entity;

import org.joinsports.joinsports.entity.Ranking;
import org.joinsports.joinsports.entity.Team;

import java.util.ArrayList;

/**
 * Created by Timo on 23.11.2016.
 */

public class League {
    // Attributes
    private ArrayList<Team> teams;
    private int numberOfTeams;
    private Ranking leagueTable;


    // Constructor
    League() {

    }

    // Functions

    void sortLeagueTable() {

    }

    // CreateMatchplan --> creates only the games not the date/time (that defines the TeamLeader)
}
