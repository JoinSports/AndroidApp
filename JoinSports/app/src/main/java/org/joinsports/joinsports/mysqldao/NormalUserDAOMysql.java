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

    private static final String JSON_ID = "id";
    private static final String JSON_USERNAME = "username";
    private static final String JSON_FIRSTNAME = "firstname";
    private static final String JSON_LASTNAME = "lastname";
    private static final String JSON_EMAIL_ADDRESS = "email";
    private static final String JSON_PASSWORD = "password";

    public NormalUserDAOMysql(DBConnector dbConnector) {
        super(dbConnector);
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("authusername", username);
            queryJson.put("passwordToCheck", password);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("NormalUser_checkCredentials", queryJson);
        return checkQuerySuccess(responseJson);
    }

    @Override
    public boolean create(NormalUser user) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put(JSON_USERNAME, user.getUsername());
            queryJson.put(JSON_PASSWORD, user.getPassword());
            queryJson.put(JSON_EMAIL_ADDRESS, user.getEmailAddress());
            queryJson.put(JSON_FIRSTNAME, user.getFirstName());
            queryJson.put(JSON_LASTNAME, user.getLastName());
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
            queryJson.put(JSON_USERNAME, username);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("NormalUser_retrieveByUsername", queryJson);
        if (checkQuerySuccess(responseJson)) {
            //query successful, create NormalUser object
            NormalUser user = new NormalUser();
            try {
                user.setId(responseJson.getInt(JSON_ID));
                user.setUsername(responseJson.getString(JSON_USERNAME));
                user.setPassword(responseJson.getString(JSON_PASSWORD));
                user.setEmailAddress(responseJson.getString(JSON_EMAIL_ADDRESS));
                user.setFirstName(responseJson.getString(JSON_FIRSTNAME));
                user.setLastName(responseJson.getString(JSON_LASTNAME));
            } catch (JSONException e) {
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
            queryJson.put(JSON_ID, id);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("NormalUser_retrieveById", queryJson);
        if (checkQuerySuccess(responseJson)) {
            //query successful, create NormalUser object
            NormalUser user = new NormalUser();
            try {
                user.setId(responseJson.getInt(JSON_ID));
                user.setUsername(responseJson.getString(JSON_USERNAME));
                user.setPassword(responseJson.getString(JSON_PASSWORD));
                user.setEmailAddress(responseJson.getString(JSON_EMAIL_ADDRESS));
                user.setFirstName(responseJson.getString(JSON_FIRSTNAME));
                user.setLastName(responseJson.getString(JSON_LASTNAME));
            } catch (JSONException e) {
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
            queryJson.put(JSON_ID, user.getId());
            queryJson.put(JSON_USERNAME, user.getUsername());
            queryJson.put(JSON_PASSWORD, user.getPassword());
            queryJson.put(JSON_EMAIL_ADDRESS, user.getEmailAddress());
            queryJson.put(JSON_FIRSTNAME, user.getFirstName());
            queryJson.put(JSON_LASTNAME, user.getLastName());
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
            queryJson.put(JSON_ID, id);
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
                user.setId(responseJson.getInt(JSON_ID));
                user.setUsername(responseJson.getString(JSON_USERNAME));
                user.setPassword(responseJson.getString(JSON_PASSWORD));
                user.setEmailAddress(responseJson.getString(JSON_EMAIL_ADDRESS));
                user.setFirstName(responseJson.getString(JSON_FIRSTNAME));
                user.setLastName(responseJson.getString(JSON_LASTNAME));
            } catch (JSONException e) {
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
                user.setId(responseJson.getInt(JSON_ID));
                user.setUsername(responseJson.getString(JSON_USERNAME));
                user.setPassword(responseJson.getString(JSON_PASSWORD));
                user.setEmailAddress(responseJson.getString(JSON_EMAIL_ADDRESS));
                user.setFirstName(responseJson.getString(JSON_FIRSTNAME));
                user.setLastName(responseJson.getString(JSON_LASTNAME));
            } catch (JSONException e) {
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
            }
            return normalUserIds;
        } else {
            //query not successful, return empty list
            return new ArrayList<>();
        }
    }

}
