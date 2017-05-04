package org.joinsports.joinsports.mysqldao;

import org.joinsports.joinsports.dao.NormalUserDAO;
import org.joinsports.joinsports.entity.NormalUser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 22.04.2017.
 */

public class NormalUserDAOMysql extends AbstractDAOMysql implements NormalUserDAO {

    public NormalUserDAOMysql(DBConnector dbConnector) {
        super(dbConnector);
    }

    @Override
    public boolean create(NormalUser user) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("username", user.getUsername());
            queryJson.put("password", user.getPassword());
            queryJson.put("emailAddress", user.getEmailAddress());
            queryJson.put("firstName", user.getFirstName());
            queryJson.put("lastName", user.getLastName());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("NormalUser_create", queryJson);
        return checkQuerySuccess(responseJson);
    }

    @Override
    public NormalUser retrieveByUsername(String username) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("username", username);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("NormalUser_retrieveByUsername", queryJson);
        if (checkQuerySuccess(responseJson)) {
            //query successful, create NormalUser object
            NormalUser user = new NormalUser();
            try {
                user.setId(Integer.parseInt(responseJson.getString("id")));
                user.setUsername(responseJson.getString("username"));
                user.setPassword(responseJson.getString("password"));
                user.setEmailAddress(responseJson.getString("emailAddress"));
                user.setFirstName(responseJson.getString("firstName"));
                user.setLastName(responseJson.getString("lastName"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            return user;
        } else {
            //query not successful
            return null;
        }
    }

    @Override
    public NormalUser retrieveById(int id) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("id", id);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("NormalUser_retrieveById", queryJson);
        if (checkQuerySuccess(responseJson)) {
            //query successful, create NormalUser object
            NormalUser user = new NormalUser();
            try {
                user.setId(Integer.parseInt(responseJson.getString("id")));
                user.setUsername(responseJson.getString("username"));
                user.setPassword(responseJson.getString("password"));
                user.setEmailAddress(responseJson.getString("emailAddress"));
                user.setFirstName(responseJson.getString("firstName"));
                user.setLastName(responseJson.getString("lastName"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            return user;
        } else {
            //query not successful
            return null;
        }
    }

    @Override
    public boolean update(NormalUser user) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("id", user.getId());
            queryJson.put("username", user.getUsername());
            queryJson.put("password", user.getPassword());
            queryJson.put("emailAddress", user.getEmailAddress());
            queryJson.put("firstName", user.getFirstName());
            queryJson.put("lastName", user.getLastName());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("NormalUser_update", queryJson);
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
        JSONObject responseJson = dbConnector.query("NormalUser_deleteById", queryJson);
        return checkQuerySuccess(responseJson);
    }

    @Override
    public NormalUser retrieveEventHostByEventId(int eventId) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("eventId", eventId);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("NormalUser_retrieveByEventId", queryJson);
        if (checkQuerySuccess(responseJson)) {
            //query successful, create NormalUser object
            NormalUser user = new NormalUser();
            try {
                user.setId(Integer.parseInt(responseJson.getString("id")));
                user.setUsername(responseJson.getString("username"));
                user.setPassword(responseJson.getString("password"));
                user.setEmailAddress(responseJson.getString("emailAddress"));
                user.setFirstName(responseJson.getString("firstName"));
                user.setLastName(responseJson.getString("lastName"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            return user;
        } else {
            //query not successful
            return null;
        }
    }

    @Override
    public NormalUser retrieveTeamLeaderByTeamId(int teamId) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("teamId", teamId);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("NormalUser_retrieveTeamLeaderByTeamId", queryJson);
        if (checkQuerySuccess(responseJson)) {
            //query successful, create NormalUser object
            NormalUser user = new NormalUser();
            try {
                user.setId(Integer.parseInt(responseJson.getString("id")));
                user.setUsername(responseJson.getString("username"));
                user.setPassword(responseJson.getString("password"));
                user.setEmailAddress(responseJson.getString("emailAddress"));
                user.setFirstName(responseJson.getString("firstName"));
                user.setLastName(responseJson.getString("lastName"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            return user;
        } else {
            //query not successful
            return null;
        }
    }

    @Override
    public List<Integer> retrieveAllTeamMemberIdsByTeamId(int teamId) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("teamId", teamId);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("NormalUser_retrieveAllTeamMemberIdsByTeamId", queryJson);
        if (checkQuerySuccess(responseJson)) {
            //query successful, create NormalUser id list
            List<Integer> normalUserIds = new ArrayList<>();
            try {
                JSONArray ids = responseJson.getJSONArray("memberIds");
                for (int i = 0; i < ids.length(); i++) {
                    int id = ids.getInt(i);
                    normalUserIds.add(id);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            return normalUserIds;
        } else {
            //query not successful, return empty list
            return new ArrayList<>();
        }
    }

}
