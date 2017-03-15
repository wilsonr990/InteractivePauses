package net.interactive.pauses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivitiesActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
    }

    public void openActivity(View view) {
        Intent intent = new Intent(this, JustAnActivity.class);
        startActivity(intent);
    }
}
