package org.joinsports.joinsports;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.joinsports.joinsports.dao.NormalUserDAO;
import org.joinsports.joinsports.entity.NormalUser;
import org.joinsports.joinsports.mysqldao.DBConnector;
import org.joinsports.joinsports.mysqldao.NormalUserDAOMysql;

public class CreateUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
    }

    public void onClick_CreateUser(View w)
    {
        //get fields
        String username = ((EditText)findViewById(R.id.create_user_tf_username)).getText().toString();
        String email = ((EditText)findViewById(R.id.create_user_tf_email)).getText().toString();
        String fname = ((EditText)findViewById(R.id.create_user_tf_firstname)).getText().toString();
        String lname = ((EditText)findViewById(R.id.create_user_tf_lastname)).getText().toString();
        String passw = ((EditText)findViewById(R.id.create_user_tf_password)).getText().toString();
        String passwrep = ((EditText)findViewById(R.id.create_user_tf_password_repeat)).getText().toString();

        //check if password is correct
        if (!passw.equals(passwrep)) {
            TextView feedback = (TextView) findViewById(R.id.create_user_tv_response);
            feedback.setText("Sie angegebenen Passwörter sind nicht identisch!");
            feedback.setTextColor(Color.RED);
            return; //abort function
        }

        // send data to DB & create user entry
        NormalUser user = new NormalUser();
        user.setEmailAddress(email);         // get data from TextFields
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setPassword(passw);
        user.setUsername(username);

        DBConnector dbc = new DBConnector(
                Registry.authusername, Registry.authusername, Registry.dbServerUrl);
        NormalUserDAO normalUserDAO = new NormalUserDAOMysql(dbc);
        boolean result = normalUserDAO.create(user);

        if (!result) {
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            TextView feedback = (TextView) findViewById(R.id.create_user_tv_response);
            feedback.setText(normalUserDAO.getLastErrorUserMsg());
            feedback.setTextColor(Color.RED);
            return; //abort function
        }

        TextView feedback = (TextView) findViewById(R.id.create_user_tv_response);
        feedback.setText("Benutzer wurde erfolgreich erstellt.");
        feedback.setTextColor(Color.BLACK);

        //update global variable
        Registry.authusername = username;
        Registry.authpasswort = passw;

        // change Activity: CreateUser-Activity --> NavigationDrawer-Activity
        Intent intent = new Intent(CreateUser.this, NavigationDrawer.class);
        intent.addFlags(Intent. FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        //this.finish();
    }
}
