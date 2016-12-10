package org.joinsports.joinsports;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageView;

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

        // set picture for ImageView
        ImageView iv = (ImageView) findViewById(R.id.imageView_logo);
        iv.setImageResource(R.mipmap.js_logo1_transparent);

/*        // Timer, for waiting before showing something
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                // warten
            }

            public void onFinish() {
                // Sprung zu neuer Activity
                System.out.println("Test");
            }
        }.start();*/

    }

    public void onClick_gotoCreateUser(View w)
    {
        Intent k = new Intent(MainActivity.this, CreateUser.class);
        startActivity(k);
    }

    public void onClick_gotoLoginUser(View w)
    {
        Intent k = new Intent(MainActivity.this, LoginUser.class);
        startActivity(k);
    }

/*    public void onClick_gotoUpdateUser(View w)
    {
        Intent k = new Intent(MainActivity.this, UpdateUser.class);
        startActivity(k);
    }*/
}
