package org.joinsports.joinsports.mysqldao;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Alex on 24.04.2017.
 */

public class JsonHelper {

    public static boolean isSuccess(JSONObject json) {
        try {
            if (json.getString("status").equals("success")) return true;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return false;
    };

    public static String getErrorUserMsg(JSONObject json) {
        try {
            return json.getString("errorUserMsg");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getErrorLogMsg(JSONObject json) {
        try {
            return json.getString("errorLogMsg");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
