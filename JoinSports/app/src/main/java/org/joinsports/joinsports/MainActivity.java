package org.joinsports.joinsports;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.joinsports.joinsports.DBDriver;
import org.joinsports.joinsports.NormalUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //JUST DO IT
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void onClick_gotoCreateUser(View w)
    {
        Intent k = new Intent(MainActivity.this, CreateUser.class);
        startActivity(k);
    }

    public void onClick_gotoUpdateUser(View w)
    {
        Intent k = new Intent(MainActivity.this, UpdateUser.class);
        startActivity(k);
    }

    public void onClick_login(View v)
    {
        NormalUser user = new NormalUser();
        user.setEmailAddress("@gmail");
        user.setFirstName("Alexü");
        user.setLastName("Stängel");
        user.setPassword("123456");
        user.setUsername("Alexö");

        DBDriver dbd = DBDriver.getInstance();
        try {
            dbd.createUser(user);
        }
        catch (DatabaseException e) {
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }
    }
}
