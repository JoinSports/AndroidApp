package org.joinsports.joinsports;

import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Alex on 05.12.2016.
 */
public class DBDriver {
    private String server = "http://joinsports.hosting5858.af939.netcup.net/";
    private static DBDriver ourInstance = new DBDriver();

    public static DBDriver getInstance() {
        return ourInstance;
    }

    private DBDriver() {
    }

    public void setLoginData(String username, String password) {
        //TODO refactor entire function, because it des nothing
    }

    private JSONObject makeRequest(String urlString, JSONObject json) throws DatabaseException
    {
        //JSONObject json = new JSONObject();
        try {
            json.put("authusername", Global.authusername);
            json.put("authpassword", Global.authpasswort);
        }
        catch (JSONException e) {
        }

        try {
            URL url = new URL(server+urlString); //Enter URL here
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST"); // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); // here you are setting the `Content-Type` for the data you are sending which is `application/json`
            httpURLConnection.setRequestProperty("charset", "UTF-8");
            httpURLConnection.connect();

            String jsonStringEncoded = URLEncoder.encode(json.toString(), "UTF-8");
            System.out.println(json);
            System.out.println(jsonStringEncoded);
            DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
            wr.writeBytes("json="+jsonStringEncoded);
            wr.flush();
            wr.close();

            //recieve http response
            int HttpResult = httpURLConnection.getResponseCode();
            if(HttpResult == httpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        httpURLConnection.getInputStream(),"UTF-8"));
                String line = null;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                System.out.println(""+sb.toString());
                try {
                    json = new JSONObject(sb.toString());
                    //check for error
                    if (!json.getString("status").equals("success")) {
                        throw new DatabaseException(json.getString("message"));
                    }
                }
                catch (JSONException e)
                {
                }
            }
            else {
                throw new DatabaseException("Could not connect to server");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    };

    public void createUser(NormalUser user) throws DatabaseException
    {
        JSONObject requestJson = new JSONObject();
        try {
            requestJson.put("username", user.getUsername());
            requestJson.put("password" ,user.getPassword());
            requestJson.put("firstname" ,user.getFirstName());
            requestJson.put("lastname" ,user.getLastName());
            requestJson.put("emailaddress" ,user.getEmailAddress());

            JSONObject responseJson = makeRequest("create_user.php" ,requestJson);
        }
        catch (JSONException e)
        {
        }
    }

    public NormalUser getUser(NormalUser user) throws DatabaseException
    {
        JSONObject requestJson = new JSONObject();
        NormalUser result = new NormalUser();
        try {
            requestJson.put("username", user.getUsername());
            requestJson.put("password" ,user.getPassword());
            requestJson.put("firstname" ,user.getFirstName());
            requestJson.put("lastname" ,user.getLastName());
            requestJson.put("emailaddress" ,user.getEmailAddress());

            JSONObject responseJson = makeRequest("create_user.php" ,requestJson);
            //json to user
            result.setUsername(responseJson.getString("username"));
            result.setPassword(responseJson.getString("password"));
            result.setEmailAddress(responseJson.getString("emailaddress"));
            result.setFirstName(responseJson.getString("firstname"));
            result.setLastName(responseJson.getString("lastname"));
            return result;
        }
        catch (JSONException e)
        {
        }
        return result;
    }

    public void updateUser(NormalUser user) throws DatabaseException
    {
        JSONObject requestJson = new JSONObject();
        try {
            requestJson.put("username", user.getUsername());
            requestJson.put("password" ,user.getPassword());
            requestJson.put("firstname" ,user.getFirstName());
            requestJson.put("lastname" ,user.getLastName());
            requestJson.put("emailaddress" ,user.getEmailAddress());

            JSONObject responseJson = makeRequest("update_user.php" ,requestJson);
        }
        catch (JSONException e)
        {
        }
    }

    public void deleteUser(NormalUser user) throws DatabaseException
    {
        JSONObject requestJson = new JSONObject();
        try {
            requestJson.put("username", user.getUsername());
            /* not necessary for deleting user
            requestJson.put("passwordHash" ,user.getPassword());
            requestJson.put("firstname" ,user.getFirstName());
            requestJson.put("lastname" ,user.getLastName());
            requestJson.put("emailaddress" ,user.getEmailAddress());
            */
            JSONObject responseJson = makeRequest("update_user.php" ,requestJson);
        }
        catch (JSONException e)
        {
        }
    }

    public boolean loginUser(String username, String password)
    {
        boolean success = true;
        JSONObject requestJson = new JSONObject();
        try {
            JSONObject responseJson = makeRequest("login_user.php" ,requestJson);
            //check if login was successfull
            if (responseJson.getString("success").equals("error")) success = false;
        }
        catch (DatabaseException e) {
            //when error occurs login was not successfull
            success = false;
        }
        catch (JSONException e) {
        }

        return success;
    }

    public void createTeam(Team team) throws DatabaseException
    {
        JSONObject requestJson = new JSONObject();
        try {
            requestJson.put("teamname", team.getTeamName());
            requestJson.put("teamleader", team.getTeamLeader().getUsername());
            /* not necessary, use default values in db script instead
            requestJson.put("numwins", 0);
            requestJson.put("numdraws", 0);
            requestJson.put("numlosses", 0);
            requestJson.put("nummembers", 0);
            */
            JSONObject responseJson = makeRequest("create_team.php" ,requestJson);
        }
        catch (JSONException e)
        {
        }
    }

    public void  deleteTeam(Team team) throws DatabaseException {
        JSONObject requestJson = new JSONObject();
        try {
            //only team name is necessary to delete user
            requestJson.put("teamname", team.getTeamName());
            JSONObject responseJson = makeRequest("update_user.php" ,requestJson);
        }
        catch (JSONException e)
        {
        }
    }

}

class DatabaseException extends Exception
{
    //Parameterless Constructor
    public DatabaseException() {}

    //Constructor that accepts a message
    public DatabaseException(String message)
    {
        super(message);
    }
}
