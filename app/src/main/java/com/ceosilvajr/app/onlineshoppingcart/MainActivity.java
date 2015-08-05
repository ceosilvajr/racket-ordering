package com.ceosilvajr.app.onlineshoppingcart;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.ceosilvajr.app.onlineshoppingcart.manager.UserManager;
import com.ceosilvajr.app.onlineshoppingcart.objects.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SplashTask splashTask = new SplashTask();
        splashTask.execute();

    }

    private class SplashTask extends AsyncTask<Void, Void, Void> {
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

            User user = UserManager.get(MainActivity.this);
            Intent intent = null;
            if (user == null) {
                intent = new Intent(MainActivity.this, LoginActivity.class);
            } else {
                intent = new Intent(MainActivity.this, ItemListActivity.class);
            }
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        //
    }
}
