package org.joinsports.joinsports;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.joinsports.joinsports.dao.TeamDAO;
import org.joinsports.joinsports.entity.Team;
import org.joinsports.joinsports.mysqldao.DBConnector;
import org.joinsports.joinsports.mysqldao.TeamDAOMysql;

public class CreateTeam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);
    }


    public void onClick_CreateTeam (View w) {
        System.out.println("##################");
        //get fields
        String teamname = ((EditText)findViewById(R.id.create_team_tf_teamname)).getText().toString();
        Team team = new Team();
        team.setTeamName(teamname);
        DBConnector dbc = new DBConnector(
                Global.authusername, Global.authusername, Global.dbServerUrl);
        TeamDAO teamDAO = new TeamDAOMysql(dbc);
        boolean result = teamDAO.create(team, Global.userid);

        if (!result) {
            TextView feedback = (TextView) findViewById(R.id.create_team_tv_feedback);
            feedback.setText(teamDAO.getLastErrorUserMsg());
            feedback.setTextColor(Color.RED);
            return;
        }

        TextView feedback = (TextView) findViewById(R.id.create_team_tv_feedback);
        feedback.setText("Team wurde erfolgreich erstellt.");
        feedback.setTextColor(Color.BLACK);

        // change view: CreateUser-Activity --> StartScreen-Activity
        Intent k = new Intent(CreateTeam.this, StartScreen.class);
        startActivity(k);
        this.finish();
    }
}
