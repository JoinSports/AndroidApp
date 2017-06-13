package org.joinsports.joinsports;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.joinsports.joinsports.dao.NormalUserDAO;
import org.joinsports.joinsports.entity.NormalUser;
import org.joinsports.joinsports.mysqldao.DBConnector;
import org.joinsports.joinsports.mysqldao.NormalUserDAOMysql;

public class LoginUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
    }

    public void onClick_Login(View w)
    {
        //get fields
        String username = ((EditText)findViewById(R.id.login_user_tf_username)).getText().toString();
        String password = ((EditText)findViewById(R.id.login_user_tf_password)).getText().toString();

        setupGlobalVars(username, password);

        //check credentials
        NormalUserDAO normalUserDAO = new NormalUserDAOMysql(Registry.dbc);
        if (normalUserDAO.checkCredentials(Registry.authusername, Registry.authpasswort) == false)
        {
            TextView feedback = (TextView) findViewById(R.id.login_user_tv_feedback);
            feedback.setText("Benutzername oder Kennwort falsch!");
            feedback.setTextColor(Color.RED);
            return;
        }

        TextView feedback = (TextView) findViewById(R.id.login_user_tv_feedback);
        feedback.setText("Anmeldung erfolgreich.");
        feedback.setTextColor(Color.BLACK);

        // change Activity: CreateUser-Activity --> NavigationDrawer-Activity
        Intent intent = new Intent(LoginUser.this, NavigationDrawer.class);
        intent.addFlags(Intent. FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        //this.finish();
    }

    private void setupGlobalVars(String username, String password) {
        //set global authentication username and password
        Registry.authusername = username;
        Registry.authpasswort = password;
        //create global database connector instance
        Registry.dbc = new DBConnector(Registry.authusername, Registry.authpasswort, Registry.dbServerUrl);
        //set global user id of current user
        NormalUserDAO normalUserDAO = new NormalUserDAOMysql(Registry.dbc);
        NormalUser currentUser = normalUserDAO.retrieveByUsername(Registry.authusername);
        if (currentUser != null) {
            Registry.user = currentUser;
        } else {
            throw new RuntimeException("couldn't retrieve current user by username");
        }
    }
}
