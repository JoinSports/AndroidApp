package org.joinsports.joinsports.mysqldao;

import org.json.JSONObject;

/**
 * Created by Alex on 22.04.2017.
 */

public abstract class AbstractDAOMysql {

    protected DBConnector dbConnector;
    protected int errorId = 0;
    protected String errorUserMsg = "";
    protected String errorLogMsg = "";

    protected boolean checkQuerySuccess(JSONObject responseJson) {
        if (JsonHelper.isSuccess(responseJson)) {
            //no error
            errorId = 0;
            errorUserMsg = "";
            errorLogMsg = "";
            return true;
        } else {
            errorId = JsonHelper.getErrorId(responseJson);
            errorUserMsg = JsonHelper.getErrorUserMsg(responseJson);
            errorLogMsg = JsonHelper.getErrorLogMsg(responseJson);
            return false;
        }
    }

    public AbstractDAOMysql(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public int getErrorId() {
        return errorId;
    }

    public String getErrorUserMsg() {
        return errorUserMsg;
    }

    public String getErrorLogMsg() {
        return errorLogMsg;
    }

}
