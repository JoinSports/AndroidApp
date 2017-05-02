package org.joinsports.joinsports.mysqldao;

import org.json.JSONObject;

/**
 * Created by Alex on 22.04.2017.
 */

public abstract class AbstractDAOMysql {

    protected DBConnector dbConnector;
    protected String errorUserMsg = "";

    protected boolean checkQuerySuccess(JSONObject responseJson) {
        if (JsonHelper.isSuccess(responseJson)) {
            //no error
            errorUserMsg = "";
            return true;
        } else {
            errorUserMsg = JsonHelper.getErrorUserMsg(responseJson);
            return false;
        }
    }

    public AbstractDAOMysql(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public String getErrorUserMsg() {
        return errorUserMsg;
    }

}
