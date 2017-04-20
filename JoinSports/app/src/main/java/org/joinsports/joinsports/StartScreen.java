package org.joinsports.joinsports;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

// Options-Menu
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class StartScreen extends AppCompatActivity {
    // ============================= Attributs ============================= //

    // ============================= Methods ============================= //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    // ++++++++++++++ Options-Menu ++++++++++++++ //
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.home:
                // Show new Activity

                return true;
            case R.id.help:
                // Show new Activity

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Button pressed
    public void onClick_gotoCreateTeam(View w) {
        Intent k = new Intent(StartScreen.this, CreateTeam.class);
        startActivity(k);
        this.finish();
    }
}
