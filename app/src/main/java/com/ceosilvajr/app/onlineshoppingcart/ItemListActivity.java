package com.ceosilvajr.app.onlineshoppingcart;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.ceosilvajr.app.onlineshoppingcart.manager.UserManager;
import com.ceosilvajr.app.onlineshoppingcart.objects.Shoes;
import com.ceosilvajr.app.onlineshoppingcart.objects.User;
import com.ceosilvajr.app.onlineshoppingcart.utils.NumberFormaterUtil;

public class ItemListActivity extends AppCompatActivity {

    private TextView mTVTotalPrice;
    private double mTotalPrice = 0.0;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.inflateMenu(R.menu.menu_item_list);

        initViews();
    }

    private void initViews() {

        mTVTotalPrice = (TextView) findViewById(R.id.txt_total_peso);
        mTVTotalPrice.setText("PHP 0.00");

        User user = UserManager.get(this);
        TextView tvUserName = (TextView) findViewById(R.id.txt_username);
        TextView tvEmail = (TextView) findViewById(R.id.txt_user_email);
        tvUserName.setText(user.getUsername());
        tvEmail.setText(user.getEmail());

        InitFirstItem();
        InitSecondItem();
        InitThirdItem();
    }

    private void InitFirstItem() {
        LinearLayout llContainer = (LinearLayout) findViewById(R.id.item_container_1);
        ImageView tvItemImage = (ImageView) findViewById(R.id.item_image_1);
        TextView tvItemName = (TextView) findViewById(R.id.item_name_1);
        TextView tvItemDescription = (TextView) findViewById(R.id.item_description_1);
        TextView tvItemPrice = (TextView) findViewById(R.id.item_price_1);
        Switch swItemSelected = (Switch) findViewById(R.id.item_switch_1);

        final Shoes shoes = new Shoes("Lebron VII", "The Nike Air Max LeBron VII was released on October 4th, 2009 after a complete overhauling of previous Nike LeBron designs.", 10000.00, R.drawable.img_lebron_vii);
        tvItemImage.setImageResource(shoes.getDrawableImage());
        tvItemName.setText(shoes.getName());
        tvItemDescription.setText(shoes.getDescription());
        tvItemPrice.setText("PHP " + NumberFormaterUtil.numberToMoney(shoes.getPrice()));

        llContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemListActivity.this, ItemDetailsActivity.class);
                intent.putExtra("shoes", shoes);
                startActivity(intent);
            }
        });

        swItemSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mTotalPrice = mTotalPrice + shoes.getPrice();
                } else {
                    mTotalPrice = mTotalPrice - shoes.getPrice();
                }
                Handler handler = new Handler(getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTVTotalPrice.setText("PHP " +
                                NumberFormaterUtil.numberToMoney(mTotalPrice));
                    }
                });
            }
        });
    }

    private void InitSecondItem() {
        LinearLayout llContainer = (LinearLayout) findViewById(R.id.item_container_2);
        ImageView tvItemImage = (ImageView) findViewById(R.id.item_image_2);
        TextView tvItemName = (TextView) findViewById(R.id.item_name_2);
        TextView tvItemDescription = (TextView) findViewById(R.id.item_description_2);
        TextView tvItemPrice = (TextView) findViewById(R.id.item_price_2);
        Switch swItemSelected = (Switch) findViewById(R.id.item_switch_2);

        final Shoes shoes = new Shoes("Lebron VIIII", "The Nike LeBron 9 Swin Cash PE takes on a blue base, brightened up by bright yellow accents and midsole speckling. This player exclusive sports Chicago Sky team.", 15000.00, R.drawable.img_lebron_viiii);
        tvItemImage.setImageResource(shoes.getDrawableImage());
        tvItemName.setText(shoes.getName());
        tvItemDescription.setText(shoes.getDescription());
        tvItemPrice.setText("PHP " + NumberFormaterUtil.numberToMoney(shoes.getPrice()));

        llContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemListActivity.this, ItemDetailsActivity.class);
                intent.putExtra("shoes", shoes);
                startActivity(intent);
            }
        });

        swItemSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mTotalPrice = mTotalPrice + shoes.getPrice();
                } else {
                    mTotalPrice = mTotalPrice - shoes.getPrice();
                }
                Handler handler = new Handler(getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTVTotalPrice.setText("PHP " + NumberFormaterUtil.numberToMoney(mTotalPrice));
                    }
                });
            }
        });
    }

    private void InitThirdItem() {
        LinearLayout llContainer = (LinearLayout) findViewById(R.id.item_container_3);
        ImageView tvItemImage = (ImageView) findViewById(R.id.item_image_3);
        TextView tvItemName = (TextView) findViewById(R.id.item_name_3);
        TextView tvItemDescription = (TextView) findViewById(R.id.item_description_3);
        TextView tvItemPrice = (TextView) findViewById(R.id.item_price_3);
        Switch swItemSelected = (Switch) findViewById(R.id.item_switch_3);

        final Shoes shoes = new Shoes("Lebron X", "Forged by time, heat and pressure, the diamond inspires LeBron James' tenth Nike signature shoe.", 25000.00, R.drawable.img_lebron_x);
        tvItemImage.setImageResource(shoes.getDrawableImage());
        tvItemName.setText(shoes.getName());
        tvItemDescription.setText(shoes.getDescription());
        tvItemPrice.setText("PHP " + NumberFormaterUtil.numberToMoney(shoes.getPrice()));

        llContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemListActivity.this, ItemDetailsActivity.class);
                intent.putExtra("shoes", shoes);
                startActivity(intent);
            }
        });

        swItemSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mTotalPrice = mTotalPrice + shoes.getPrice();
                } else {
                    mTotalPrice = mTotalPrice - shoes.getPrice();
                }
                Handler handler = new Handler(getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTVTotalPrice.setText("PHP " + NumberFormaterUtil.numberToMoney(mTotalPrice));
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            onCartClicked();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onCartClicked() {

        if (mTotalPrice > 0) {
            Intent intent = new Intent(ItemListActivity.this, CheckoutActivity.class);
            intent.putExtra("total_price", mTotalPrice);
            startActivity(intent);
            return;
        }

        final AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.setTitle(getString(R.string.app_name));
        alertDialog.setMessage("You have not selected any item yet. Please select at least 1 to continue.");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getString(R.string.app_name));
        alertDialog.setMessage("Are you sure you want to exit the app? You will be logout if you continue.");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "CONTINUE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                UserManager.delete(mContext);
                finish();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
