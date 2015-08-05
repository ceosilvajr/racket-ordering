package com.ceosilvajr.app.onlineshoppingcart;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ceosilvajr.app.onlineshoppingcart.objects.Shoes;
import com.ceosilvajr.app.onlineshoppingcart.utils.NumberFormaterUtil;

public class ItemDetailsActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setTitle("Item Details");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        // Set an OnMenuItemClickListener to handle menu item clicks
        toolbar.setNavigationOnClickListener(mToolbarBackClicked);

        initView();

    }

    private void initView() {
        final Shoes shoes = getIntent().getExtras().getParcelable("shoes");
        if (shoes == null) {
            Toast.makeText(mContext, "Sorry Item not found", Toast.LENGTH_LONG).show();
            finish();
        }
        ImageView ivItemImage = (ImageView) findViewById(R.id.iv_item_image);
        TextView tvItemPrice = (TextView) findViewById(R.id.tv_item_price);
        TextView tvItemName = (TextView) findViewById(R.id.tv_item_name);
        TextView tvItemDescription = (TextView) findViewById(R.id.tv_item_description);

        ivItemImage.setImageResource(shoes.getDrawableImage());
        tvItemPrice.setText("PHP " + NumberFormaterUtil.numberToMoney(shoes.getPrice()));
        tvItemName.setText(shoes.getName());
        tvItemDescription.setText(shoes.getDescription());

        Button btnBuy = (Button) findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetailsActivity.this, CheckoutActivity.class);
                intent.putExtra("total_price", shoes.getPrice());
                startActivity(intent);
            }
        });
    }

    private View.OnClickListener mToolbarBackClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

}
