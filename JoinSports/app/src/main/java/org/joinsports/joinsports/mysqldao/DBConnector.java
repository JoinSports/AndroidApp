package org.joinsports.joinsports.mysqldao;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Alex on 22.04.2017.
 */

public class DBConnector {

    private String authUsername;
    private String authPassword;
    private String serverUrl;

    public DBConnector(String authUsername, String authPassword, String serverUrl) {
        this.authUsername = authUsername;
        this.authPassword = authPassword;
        this.serverUrl = serverUrl;
    }

    public JSONObject query(String site, JSONObject queryJson) {
        try {
            //add credentials to query json
            queryJson.put("authusername", authUsername);
            queryJson.put("authpassword", authPassword);

            //send http request
            URL url = new URL(serverUrl+"/" + site + ".php"); //Enter URL here
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST"); // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); // here you are setting the `Content-Type` for the data you are sending which is `application/json`
            httpURLConnection.setRequestProperty("charset", "UTF-8");
            httpURLConnection.connect();
            String jsonStringEncoded = URLEncoder.encode(queryJson.toString(), "UTF-8");
            System.out.println(queryJson);
            System.out.println(jsonStringEncoded);
            DataOutputStream dos = new DataOutputStream(httpURLConnection.getOutputStream());
            dos.writeBytes("json="+jsonStringEncoded);
            dos.flush();
            dos.close();

            //receive http response
            String responseJsonString = null;
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
                responseJsonString = sb.toString();
            }
            else {
                throw new RuntimeException("Could not connect to server");
            }

            //create response json object
            JSONObject responseJson = new JSONObject(responseJsonString);
            return responseJson;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
