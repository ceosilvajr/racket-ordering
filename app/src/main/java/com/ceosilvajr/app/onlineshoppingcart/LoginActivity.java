package com.ceosilvajr.app.onlineshoppingcart;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ceosilvajr.app.onlineshoppingcart.manager.UserManager;
import com.ceosilvajr.app.onlineshoppingcart.objects.User;

public class LoginActivity extends AppCompatActivity {

    private EditText mEdtEmail;
    private EditText mEdtPassword;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;

        mEdtEmail = (EditText) findViewById(R.id.edt_email);
        mEdtPassword = (EditText) findViewById(R.id.edt_password);

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        TextView tvRegister = (TextView) findViewById(R.id.tv_register);

        btnLogin.setOnClickListener(mLoginBtnClicked);
        tvRegister.setOnClickListener(mTVRegisterClicked);

    }

    private View.OnClickListener mLoginBtnClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String email = mEdtEmail.getText().toString();
            String password = mEdtPassword.getText().toString();

            if (email.isEmpty()) {
                mEdtEmail.setError("Enter your email");
                return;
            }

            if (password.isEmpty()) {
                mEdtPassword.setError("Enter your password");
                return;
            }

            User user = UserManager.get(mContext);
            if (user == null) {
                popAlert("User not found, please register");
                return;
            }

            if (email.equals(user.getEmail())) {
                if (password.equals(user.getPassword())) {
                    LoginTask loginTask = new LoginTask();
                    loginTask.execute();
                } else {
                    popAlert("Incorrect password.");
                }
            } else {
                popAlert("User not found, please register.");
            }

        }
    };

    private View.OnClickListener mTVRegisterClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
        }
    };

    private void popAlert(String message) {
        final AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.setTitle(getString(R.string.app_name));
        alertDialog.setMessage(message);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private class LoginTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(mContext);
            pd.setMessage("Login on process...");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pd.dismiss();
            Toast.makeText(mContext, "Successful login", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, ItemListActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
