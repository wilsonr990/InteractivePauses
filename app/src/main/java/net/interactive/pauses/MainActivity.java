package net.interactive.pauses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
