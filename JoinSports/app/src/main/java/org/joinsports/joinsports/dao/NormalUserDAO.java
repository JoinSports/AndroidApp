package org.joinsports.joinsports.dao;

import org.joinsports.joinsports.entity.NormalUser;

/**
 * Created by Alex on 18.04.2017.
 */

public interface NormalUserDAO {

    public boolean create(NormalUser user);

    //returns null if there is no user with given username
    public NormalUser retrieveByUsername(String username);

    public boolean update(NormalUser user);

    public boolean delete(NormalUser user);

    //returns error id if last operation caused an error. Returning '0' means no error.
    public int getLastError();

}
