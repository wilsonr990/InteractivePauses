package net.interactive.pauses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import net.interactive.pauses.R.id;
import net.interactive.pauses.R.layout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        Intent intent = getIntent();
        String name = intent.getStringExtra(LoginActivity.LOGIN_NAME);
        TextView textView = (TextView) findViewById(id.username);
        if (textView != null) {
            textView.setText(' ' + name);
        }
    }

    public void goToActivities(View view) {
        Intent intent = new Intent(this, ActivitiesActivity.class);
        startActivity(intent);
    }

    public void goToSchedule(View view) {
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }

    public void goToConfiguration(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void goToProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
