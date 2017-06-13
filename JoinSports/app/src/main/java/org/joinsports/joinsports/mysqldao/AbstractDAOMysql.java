package org.joinsports.joinsports.mysqldao;

import org.joinsports.joinsports.dao.CommonDAO;
import org.json.JSONObject;

/**
 * Created by Alex on 22.04.2017.
 */

public abstract class AbstractDAOMysql implements CommonDAO {

    protected DBConnector dbConnector;
    protected String errorUserMsg = "";
    protected String errorLogMsg = "";

    protected boolean checkQuerySuccess(JSONObject responseJson) {
        if (JsonHelper.isSuccess(responseJson)) {
            //no error
            errorUserMsg = "";
            return true;
        } else {
            errorUserMsg = JsonHelper.getErrorUserMsg(responseJson);
            errorLogMsg = JsonHelper.getErrorLogMsg(responseJson);
            return false;
        }
    }

    public AbstractDAOMysql(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public String getLastErrorUserMsg() {
        return errorUserMsg;
    }

    @Override
    public String getLastErrorLogMsg() {
        return errorLogMsg;
    }

}
