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

    private JSONObject makeRequest(String urlString, String jsonString)
    {
        JSONObject json = new JSONObject();

        try {
            URL url = new URL(server+urlString); //Enter URL here
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST"); // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.
            httpURLConnection.setRequestProperty("Content-Type", "application/json"); // here you are setting the `Content-Type` for the data you are sending which is `application/json`
            httpURLConnection.connect();

            DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
            wr.writeBytes(jsonString);
            wr.flush();
            wr.close();

            int HttpResult =httpURLConnection.getResponseCode();
            if(HttpResult ==httpURLConnection.HTTP_OK){
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        httpURLConnection.getInputStream(),"utf-8"));
                String line = null;

                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                System.out.println(""+sb.toString());

                try {
                    json = new JSONObject(sb.toString());
                }
                catch (JSONException e)
                {
                    //Toast.makeText(getApplicationContext(),"Error generating JSON",Toast.LENGTH_SHORT).show();
                }


            }else{
                System.out.println(httpURLConnection.getResponseMessage());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    };

    public void createUser(NormalUser user)
    {
        JSONObject json = new JSONObject();
        try {
            json.put("username", user.getUsername());
            json.put("password" ,user.getPassword());
            json.put("fistName" ,user.getFirstName());
            json.put("lastName" ,user.getFirstName());
            json.put("emailAddress" ,user.getEmailAddress());

            makeRequest("create_user.php" ,json.toString());
            return;
        }
        catch (JSONException e)
        {
            //Toast.makeText(getApplicationContext(),"Error generating JSON",Toast.LENGTH_SHORT).show();
        }
        finally {
        }
    }

}
