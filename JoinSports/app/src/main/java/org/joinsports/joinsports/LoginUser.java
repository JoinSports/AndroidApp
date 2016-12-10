package org.joinsports.joinsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
    }

    public void onClick_StartScreen(View w)
    {
        // send data to DB & get Message if user exists

//        NormalUser user = new NormalUser();
//        user.setEmailAddress("@gmx");         // get data from TextFields
//        user.setFirstName("Tim");
//        user.setLastName("Lang");
//        user.setPassword("123456");
//        user.setUsername("Testuser1000");

        DBDriver dbd = DBDriver.getInstance();
        dbd.loginUser("123","123");



        // change view: CreateUser-Activity --> StartScreen-Activity
        Intent k = new Intent(LoginUser.this, StartScreen.class);
        startActivity(k);
        this.finish();

    }
}
