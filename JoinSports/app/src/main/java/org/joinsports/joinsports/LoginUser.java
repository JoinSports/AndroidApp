package org.joinsports.joinsports;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        DBDriver dbd = DBDriver.getInstance();
        dbd.setLoginData(username, passw);
        if (!dbd.loginUser(username, passw))
        {
            TextView feedback = (TextView) findViewById(R.id.login_user_tv_feedback);
            feedback.setText("Benutzername oder Kennwort falsch!");
            feedback.setTextColor(Color.RED);
            return;
        };

        TextView feedback = (TextView) findViewById(R.id.login_user_tv_feedback);
        feedback.setText("Anmeldung erfolgreich.");
        feedback.setTextColor(Color.BLACK);

        // change view: CreateUser-Activity --> StartScreen-Activity
        Intent k = new Intent(LoginUser.this, StartScreen.class);
        startActivity(k);
        this.finish();

    }
}
