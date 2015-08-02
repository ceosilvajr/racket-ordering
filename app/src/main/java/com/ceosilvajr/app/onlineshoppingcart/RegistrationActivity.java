package com.ceosilvajr.app.onlineshoppingcart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        // Set an OnMenuItemClickListener to handle menu item clicks
        toolbar.setNavigationOnClickListener(mToolbarBackClicked);

    }

    private View.OnClickListener mToolbarBackClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
