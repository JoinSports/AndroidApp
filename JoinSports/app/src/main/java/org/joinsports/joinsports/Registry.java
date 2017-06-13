package org.joinsports.joinsports;

import org.joinsports.joinsports.entity.NormalUser;
import org.joinsports.joinsports.mysqldao.DBConnector;

/**
 * Created by Alex on 13.12.2016.
 */

public class Registry {

    //database connection information
    public static String dbServerUrl = "http://joinsports.hosting5858.af939.netcup.net";

    //data base connector
    public static DBConnector dbc = null;

    //user information
    public static String authusername = "";
    public static String authpasswort = "";
    public static NormalUser user;

    public static void onUpdatedUser(NormalUser updatedUser) {
        user = updatedUser;
        authusername = updatedUser.getUsername();
        authpasswort = updatedUser.getPassword();
        //renew database connector
        dbc = new DBConnector(authusername, authpasswort, dbServerUrl);
    }

}
