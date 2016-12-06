package org.joinsports.joinsports;

import java.util.ArrayList;

/**
 * Created by Timo on 23.11.2016.
 */

public class Team {
    // Attributes
    private ArrayList<NormalUser> teamMembers;
    private TeamLeader teamLeader;
    private int numberOfMebers;

    private int numberOfWins;
    private int numberOfDraws;
    private int numberOfLosses;

    // Constructor
    Team(TeamLeader pTeamLeader) {      // as parameter is given a NormalUser, who is then type casted in an TeamLeader
        teamLeader = pTeamLeader;
    }

    // Functions

    // AddMember/RemoveMember

    // Get- & Set - Methods


    public ArrayList<NormalUser> getTeamMembers() {
        return teamMembers;
    }

    /*
    public void setTeamMembers(ArrayList<NormalUser> teamMembers) {
        this.teamMembers = teamMembers;
    } */

    public TeamLeader getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(TeamLeader teamLeader) {
        this.teamLeader = teamLeader;
    }

    public int getNumberOfMebers() {
        return numberOfMebers;
    }

    public void setNumberOfMebers(int numberOfMebers) {
        this.numberOfMebers = numberOfMebers;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws = numberOfDraws;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public void setNumberOfLosses(int numberOfLosses) {
        this.numberOfLosses = numberOfLosses;
    }

}
