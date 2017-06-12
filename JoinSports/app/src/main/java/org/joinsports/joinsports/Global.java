package org.joinsports.joinsports;

import org.joinsports.joinsports.mysqldao.DBConnector;

/**
 * Created by Alex on 13.12.2016.
 */

public class Global {

    //database connection information
    public static String dbServerUrl = "http://joinsports.hosting5858.af939.netcup.net";

    //data base connector
    public static DBConnector dbc = null;

    //user information
    public static String authusername = "";
    public static String authpasswort = "";
    public static int userId = 0;

}
