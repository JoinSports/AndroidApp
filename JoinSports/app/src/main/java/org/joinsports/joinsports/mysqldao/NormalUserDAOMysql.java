package org.joinsports.joinsports.mysqldao;

import org.joinsports.joinsports.dao.NormalUserDAO;
import org.joinsports.joinsports.entity.NormalUser;

/**
 * Created by Alex on 22.04.2017.
 */

public class NormalUserDAOMysql extends AbstractDAOMysql implements NormalUserDAO {

    public NormalUserDAOMysql(DBConnector dbConnector) {
        super(dbConnector);
    }

    @Override
    public boolean create(NormalUser user) {
        return false;
    }

    @Override
    public NormalUser retrieveByUsername(String username) {
        return null;
    }

    @Override
    public boolean update(NormalUser user) {
        return false;
    }

    @Override
    public boolean delete(NormalUser user) {
        return false;
    }

    @Override
    public int getLastError() {
        return 1;
    }
}
