package com.ceosilvajr.app.onlineshoppingcart;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ceosilvajr.app.onlineshoppingcart.manager.UserManager;
import com.ceosilvajr.app.onlineshoppingcart.objects.User;

public class RegistrationActivity extends AppCompatActivity {

    private EditText mEdtUsername;
    private EditText mEdtEmail;
    private EditText mEdtPassword;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        // Set an OnMenuItemClickListener to handle menu item clicks
        toolbar.setNavigationOnClickListener(mToolbarBackClicked);

        mEdtUsername = (EditText) findViewById(R.id.edt_username);
        mEdtEmail = (EditText) findViewById(R.id.edt_email);
        mEdtPassword = (EditText) findViewById(R.id.edt_password);

        Button btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(mBtnRegisterClicked);
    }

    private View.OnClickListener mToolbarBackClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private View.OnClickListener mBtnRegisterClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username = mEdtUsername.getText().toString();
            String email = mEdtEmail.getText().toString();
            String password = mEdtPassword.getText().toString();
            if (username.isEmpty()) {
                mEdtUsername.setError("Please enter Username");
                return;
            }
            if (email.isEmpty()) {
                mEdtEmail.setError("Please enter Email");
                return;
            }
            if (password.isEmpty()) {
                mEdtPassword.setError("Please enter Password");
                return;
            }
            User user = new User(username, email, password);
            RegisterTask registerTask = new RegisterTask(user);
            registerTask.execute();
        }
    };

    private class RegisterTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog pd;
        User mUser;

        RegisterTask(User user) {
            this.mUser = user;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(mContext);
            pd.setMessage("Registration on process...");
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

            //saves new user
            UserManager.save(mUser, mContext);

            popAlert("Successful registration you can now login with your account.");
        }
    }

    private void popAlert(String message) {
        final AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.setTitle(getString(R.string.app_name));
        alertDialog.setMessage(message);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "DONE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                finish();
            }
        });
        alertDialog.show();
    }

}
