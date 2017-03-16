package net.interactive.pauses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import net.interactive.pauses.R.id;
import net.interactive.pauses.R.layout;
import net.interactive.pauses.logic.login.LoginHandler;
import net.interactive.pauses.logic.login.LoginListener;

public class LoginActivity extends Activity implements LoginListener {
    public static final String LOGIN_NAME = "com.example.myfirstapp.MESSAGE";
    private int selectedAvatar;
    private LoginHandler loginHandler;

    // UI references.
    private EditText name;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login);

        name = (EditText) findViewById(id.name);
        progressBar = (ProgressBar) findViewById(id.progress_bar);
    }

    public void facebookLogin(View view) {
        //TODO: Run facebook login process
        name.setError("Currently Your Name is the only login available");
    }

    public void googleLogin(View view) {
        //TODO: Run google login process
        name.setError("Currently Your Name is the only login available");
    }

    public void simpleLogin(View view) {
        String typedName = name.getText().toString();
        if (typedName.isEmpty()) {
            name.setError("You should type your name here");
        }
        if (loginHandler == null) {
            loginHandler = new LoginHandler(this);
            loginHandler.execute(typedName, String.valueOf(selectedAvatar));
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    public void avatarSelected(View view) {
        selectedAvatar = view.getId();
    }

    @Override
    public void onLoginFinished(Boolean ok, String message) {
        //change to login window
        if (ok) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(LOGIN_NAME, name.getText());
            startActivity(intent);
        } else {
            name.setError(message);
        }
        //hide progress bar
        progressBar.setVisibility(View.GONE);
        loginHandler = null;
    }
}
