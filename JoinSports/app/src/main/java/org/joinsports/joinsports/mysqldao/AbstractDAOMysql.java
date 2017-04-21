package org.joinsports.joinsports.mysqldao;

/**
 * Created by Alex on 22.04.2017.
 */

public abstract class AbstractDAOMysql {

    protected DBConnector dbConnector;

    public AbstractDAOMysql(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

}
