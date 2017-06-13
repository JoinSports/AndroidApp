package org.joinsports.joinsports;

import org.joinsports.joinsports.dao.NormalUserDAO;
import org.joinsports.joinsports.entity.NormalUser;
import org.joinsports.joinsports.mysqldao.NormalUserDAOMysql;

/**
 * Created by Alex on 13.06.2017.
 */

public class UpdateUserModel {

    private AppController controller;

    public UpdateUserModel(AppController controller) {
        this.controller = controller;
    }

    public boolean updateUserData(String oldPassword, String newPassword, String newPasswordRepeat,
                                  String emailAddress, String emailAddressRepeat) {
        if(!checkPassword(oldPassword, newPassword, newPasswordRepeat)) return false;
        if(!checkEmail(emailAddress, emailAddressRepeat)) return false;
        //push new data to db
        NormalUserDAO userDAO = new NormalUserDAOMysql(Registry.dbc);
        NormalUser updatedUser = Registry.user;
        updatedUser.setEmailAddress(emailAddress);
        updatedUser.setPassword(newPassword);
        if (userDAO.update(updatedUser)) {
            //update successful
            //update global user
            Registry.onUpdatedUser(updatedUser);
            controller.showSuccess("Änderungen übernommen.");
            return true;
        } else {
            //update not successful
            controller.showError("Änderungen konnten nicht übernommen werden.");
            return false;
        }
    }

    private boolean checkPassword(String oldPassword, String newPassword,
                                  String newPasswordRepeat) {
        //check not empty
        if (newPassword.equals("")) {
            controller.showError("Das neue Kennwort darf nicht leer sein.");
            return false;
        }
        //check equality
        if (!newPassword.equals(newPasswordRepeat)) {
            controller.showError("Das neue Kennwort wurde falsch wiederholt.");
            return false;
        }
        //check if old password is valid
        NormalUserDAO userDAO = new NormalUserDAOMysql(Registry.dbc);
        if (!userDAO.checkCredentials(Registry.authusername, oldPassword)) {
            controller.showError("Das alte Kennwort ist nicht gültig.");
            return false;
        }
        return true;
    }

    private boolean checkEmail(String newEmail, String newEmailRepeat) {
        //check not empty
        if (newEmail.equals("")) {
            controller.showError("Die neue Email-Adresse darf nicht leer sein.");
            return false;
        }
        //check equality
        if (!newEmail.equals(newEmailRepeat)) {
            controller.showError("Die neue Email-Adresse wurde falsch wiederholt.");
            return false;
        }
        return true;
    }

}
