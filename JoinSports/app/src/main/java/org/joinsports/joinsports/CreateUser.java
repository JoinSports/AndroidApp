package org.joinsports.joinsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.joinsports.joinsports.DBDriver;
import org.joinsports.joinsports.NormalUser;

public class CreateUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
    }

    public void onClick_gotoStartScreen(View w)
    {
        // send data to DB & create user entry
        NormalUser user = new NormalUser();
        user.setEmailAddress("@gmx");         // get data from TextFields
        user.setFirstName("Tim");
        user.setLastName("Lang");
        user.setPassword("123456");
        user.setUsername("Testuser1000");

        DBDriver dbd = DBDriver.getInstance();
        try {
            dbd.createUser(user);
            System.out.println("Test1");
        }
        catch (DatabaseException e) {
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }

        System.out.println("Test2");
        // change view: CreateUser-Activity --> StartScreen-Activity
        Intent k = new Intent(CreateUser.this, StartScreen.class);
        startActivity(k);
        this.finish();

    }
}
