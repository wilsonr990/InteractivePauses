package net.interactive.pauses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import net.interactive.pauses.R.id;
import net.interactive.pauses.R.layout;

public class LoginActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private int selectedAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login);
    }

    public void facebookLogin(View view) {
        //TODO: Run facebook login process
        doLogin("Facebook User", 0);
    }

    public void googleLogin(View view) {
        //TODO: Run google login process
        doLogin("Google User", 0);
    }

    public void simpleLogin(View view) {
        EditText editText = (EditText) findViewById(id.name);
        if (editText != null) {
            doLogin(editText.getText().toString(), selectedAvatar);
        }
    }

    void doLogin(String name, int avatar) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, name);
        startActivity(intent);
    }

    public void avatarSelected(View view) {
        selectedAvatar = view.getId();
    }

    @Override
    public String toString() {
        return "LoginActivity{" +
                "selectedAvatar=" + selectedAvatar +
                '}';
    }
}
