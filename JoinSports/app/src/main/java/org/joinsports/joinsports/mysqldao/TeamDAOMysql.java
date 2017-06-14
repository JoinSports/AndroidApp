package org.joinsports.joinsports.mysqldao;

import org.joinsports.joinsports.dao.TeamDAO;
import org.joinsports.joinsports.entity.Team;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 22.04.2017.
 */

public class TeamDAOMysql extends AbstractDAOMysql implements TeamDAO {

    public TeamDAOMysql(DBConnector dbConnector) {
        super(dbConnector);
    }


    @Override
    public boolean create(Team team, int teamLeaderId) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("teamLeaderId", teamLeaderId);
            queryJson.put("teamName", team.getTeamName());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("Team_create", queryJson);
        return checkQuerySuccess(responseJson);
    }

    @Override
    public boolean doesTeamNameExist(String teamName) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("teamName", teamName);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("Team_doesTeamNameExist", queryJson);
        return checkQuerySuccess(responseJson);
    }

    @Override
    public Team retrieveById(int id) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("id", id);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("Team_retrieveById", queryJson);
        if (checkQuerySuccess(responseJson)) {
            //query successful, create NormalUser object
            Team team = new Team();
            try {
                team.setId(responseJson.getInt("id"));
                team.setTeamName(responseJson.getString("teamName"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            return team;
        } else {
            //query not successful
            return null;
        }
    }

    @Override
    public boolean update(Team team) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("id", team.getId());
            queryJson.put("teamName", team.getTeamName());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("Team_update", queryJson);
        return checkQuerySuccess(responseJson);
    }

    @Override
    public boolean deleteById(int id) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("id", id);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("Team_deleteById", queryJson);
        return checkQuerySuccess(responseJson);
    }

    @Override
    public List<Integer> retrieveAllTeamIdsByUserId(int userId) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("userId", userId);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("Team_retrieveAllTeamIdsByUserId", queryJson);
        if (checkQuerySuccess(responseJson)) {
            //query successful, create team id list
            List<Integer> teamIds = new ArrayList<>();
            try {
                JSONArray ids = responseJson.getJSONArray("teamIds");
                for (int i = 0; i < ids.length(); i++) {
                    int id = ids.getInt(i);
                    teamIds.add(id);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            return teamIds;
        } else {
            //query not successful, return empty list
            return new ArrayList<>();
        }
    }

    @Override
    public List<Integer> retrieveAllTeamIdsByTeamLeaderId(int teamLeaderId) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("teamLeaderId", teamLeaderId);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("Team_retrieveAllTeamIdsByTeamLeaderId", queryJson);
        if (checkQuerySuccess(responseJson)) {
            //query successful, create team id list
            List<Integer> teamIds = new ArrayList<>();
            try {
                JSONArray ids = responseJson.getJSONArray("teamIds");
                for (int i = 0; i < ids.length(); i++) {
                    int id = ids.getInt(i);
                    teamIds.add(id);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            return teamIds;
        } else {
            //query not successful, return empty list
            return new ArrayList<>();
        }
    }

    @Override
    public List<Integer> retrieveAllUnjoinedTeamsByUserId(int userId) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("userId", userId);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("Team_retrieveAllUnjoinedTeamsByUserId", queryJson);
        System.out.println(responseJson);
        if (checkQuerySuccess(responseJson)) {
            //query successful, create team id list
            List<Integer> teamIds = new ArrayList<>();
            try {
                JSONArray ids = responseJson.getJSONArray("teamIds");
                for (int i = 0; i < ids.length(); i++) {
                    int id = ids.getInt(i);
                    teamIds.add(id);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            return teamIds;
        } else {
            //query not successful, return empty list
            return new ArrayList<>();
        }
    }

    @Override
    public boolean joinTeamById(int teamId, int userId) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("userId", userId);
            queryJson.put("teamId", teamId);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("Team_joinTeamById", queryJson);
        if (checkQuerySuccess(responseJson)) {
           return true;
        } else {
            return false;
        }
    }
}
