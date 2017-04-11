package org.joinsports.joinsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

<<<<<<< HEAD
    public void onClick_gotoCreateTeam(View w) {
=======
    public void onClick_goto_createTeam(View w) {
>>>>>>> 667cb1bd248fe7c2632b99df8af1ec5e507783c9
        Intent k = new Intent(StartScreen.this, CreateTeam.class);
        startActivity(k);
        this.finish();
    }
}
