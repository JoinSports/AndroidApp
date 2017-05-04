package org.joinsports.joinsports;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.joinsports.joinsports.dao.NormalUserDAO;
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
        String passw = ((EditText)findViewById(R.id.login_user_tf_password)).getText().toString();

        //write to global var
        Global.authusername = username;
        Global.authpasswort = passw;

        DBConnector dbc = new DBConnector(
                Global.authusername, Global.authpasswort, Global.dbServerUrl);
        NormalUserDAO normalUserDAO = new NormalUserDAOMysql(dbc);

        if (normalUserDAO.checkCredentials(Global.authusername, Global.authpasswort))
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
}
