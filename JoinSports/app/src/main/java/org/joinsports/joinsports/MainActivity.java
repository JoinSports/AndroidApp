package org.joinsports.joinsports;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void onClick_login(View v)
    {
        NormalUser user = new NormalUser();
        user.setEmailAddress("@gmail");
        user.setFirstName("Günther");
        user.setLastName("Stängel");
        user.setPassword("123456");
        user.setUsername("günnie");

        DBDriver dbd = DBDriver.getInstance();
        dbd.createUser(user);
    }
}
