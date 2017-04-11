package org.joinsports.joinsports;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateTeam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);
    }

    public void onClick_CreateTeam (View w) {
        System.out.println("##################");
        //get fields
        String teamname = ((EditText)findViewById(R.id.abdul)).getText().toString();

        // send data to DB & create user entry
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setUsername(Global.authusername);
        teamLeader.setPassword(Global.authpasswort);
        Team team = new Team(teamLeader);
        team.setTeamName(teamname);

        DBDriver dbd = DBDriver.getInstance();
        try {
            dbd.createTeam(team);
        }
        catch (DatabaseException e) {
            TextView feedback = (TextView) findViewById(R.id.ali);
            feedback.setText(e.getMessage());
            feedback.setTextColor(Color.RED);
            return; //abort function
        }

        TextView feedback = (TextView) findViewById(R.id.ali);
        feedback.setText("Team wurde erfolgreich erstellt.");
        feedback.setTextColor(Color.BLACK);

        // change view: CreateUser-Activity --> StartScreen-Activity
        Intent k = new Intent(CreateTeam.this, StartScreen.class);
        startActivity(k);
        this.finish();

        return;
    }
}
