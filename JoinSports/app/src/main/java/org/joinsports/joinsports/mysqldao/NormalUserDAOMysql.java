package org.joinsports.joinsports.mysqldao;

import org.joinsports.joinsports.dao.NormalUserDAO;
import org.joinsports.joinsports.entity.NormalUser;
import org.json.JSONException;
import org.json.JSONObject;

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
            //query successfull, create NormalUser object
            NormalUser user = new NormalUser();
            try {
                user.setUsername(responseJson.getString("username"));
                user.setPassword(responseJson.getString("password"));
                user.setEmailAddress(responseJson.getString("emailAddress"));
                user.setFirstName(responseJson.getString("firstName"));
                user.setLastName(responseJson.getString("lastName"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            return user;
        } else {
            //query not successfull
            return null;
        }
    }

    @Override
    public boolean update(NormalUser user) {
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
        JSONObject responseJson = dbConnector.query("NormalUser_update", queryJson);
        return checkQuerySuccess(responseJson);
    }

    @Override
    public boolean deleteByUsername(String username) {
        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("username", username);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = dbConnector.query("NormalUser_deleteByUsername", queryJson);
        return checkQuerySuccess(responseJson);
    }

}
