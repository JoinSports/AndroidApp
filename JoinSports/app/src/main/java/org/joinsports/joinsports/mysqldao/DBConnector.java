package org.joinsports.joinsports.mysqldao;

/**
 * Created by Alex on 22.04.2017.
 */

public class DBConnector {

    private String authUsername;
    private String authPassword;
    private String serverUrl;
    private String serverPort;

    public DBConnector(String authUsername, String authPassword, String serverUrl, String serverPort) {
        this.authUsername = authUsername;
        this.authPassword = authPassword;
        this.serverUrl = serverUrl;
        this.serverPort = serverPort;
    }

}
