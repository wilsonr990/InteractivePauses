package net.interactive.pauses.logic.login;

import android.os.AsyncTask;

public class LoginHandler extends AsyncTask<String, Void, Boolean> {

    private final LoginListener listener;
    private String name;
    private int avatar;
    private String message;

    public LoginHandler(LoginListener listener) {
        super();
        this.listener = listener;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        name = params[0];
        avatar = Integer.parseInt(params[1]);
        // TODO: save user in memory to dont show login again!
        Boolean success = Boolean.FALSE;
        try {
            // Simulate time process.
            Thread.sleep(2000);
            if (name.length() >= 5) {
                success = Boolean.TRUE;
            }
            else{
                message = "Invalid Format";
            }
        } catch (InterruptedException ignored) {
            message = "Login Task Interrupted";
        }
        return success;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        listener.onLoginFinished(result, result ? "LOGIN SUCCEEDED" : message);
    }

    @Override
    protected void onCancelled() {
        listener.onLoginFinished(Boolean.FALSE, "LOGIN CANCELLED");
    }
}