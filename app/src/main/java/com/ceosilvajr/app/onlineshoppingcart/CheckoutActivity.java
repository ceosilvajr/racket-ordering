package com.ceosilvajr.app.onlineshoppingcart;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ceosilvajr.app.onlineshoppingcart.manager.UserManager;
import com.ceosilvajr.app.onlineshoppingcart.objects.User;
import com.ceosilvajr.app.onlineshoppingcart.utils.NumberFormaterUtil;

public class CheckoutActivity extends AppCompatActivity {

    private double mTotalPrice = 0.0;

    private RadioButton mRBCreditDebit;
    private RadioButton mRBPayPal;
    private RadioButton mRBCreditCard;
    private RadioButton mRBCash;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        // Set an OnMenuItemClickListener to handle menu item clicks
        toolbar.setNavigationOnClickListener(mToolbarBackClicked);

        mTotalPrice = getIntent().getDoubleExtra("total_price", 0);

        initView();
    }

    private void initView() {
        Button btnContinue = (Button) findViewById(R.id.btn_continue);
        btnContinue.setOnClickListener(onBuyBtnClicked);

        TextView tvTotalPrice = (TextView) findViewById(R.id.tv_total_price);
        tvTotalPrice.setText("PHP " + NumberFormaterUtil.numberToMoney(mTotalPrice));

        mRBCreditDebit = (RadioButton) findViewById(R.id.rb_credit_debit);
        mRBPayPal = (RadioButton) findViewById(R.id.rb_paypal);
        mRBCreditCard = (RadioButton) findViewById(R.id.rb_credit_card);
        mRBCash = (RadioButton) findViewById(R.id.rb_cash);

        mRBCreditDebit.setOnClickListener(onRadioButtonsClicked);
        mRBPayPal.setOnClickListener(onRadioButtonsClicked);
        mRBCreditCard.setOnClickListener(onRadioButtonsClicked);
        mRBCash.setOnClickListener(onRadioButtonsClicked);
    }

    private View.OnClickListener onBuyBtnClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            continueAlertPopup();
        }
    };

    private void continueAlertPopup() {
        final AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.setTitle(getString(R.string.app_name));
        alertDialog.setMessage("Are you sure you want to continue your purchase amounting to PHP "
                + NumberFormaterUtil.numberToMoney(mTotalPrice) + " ?");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                ContinueTask continueTask = new ContinueTask();
                continueTask.execute();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private View.OnClickListener onRadioButtonsClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rb_cash:
                    mRBCash.setChecked(true);
                    mRBCreditCard.setChecked(false);
                    mRBCreditDebit.setChecked(false);
                    mRBPayPal.setChecked(false);
                    break;
                case R.id.rb_credit_debit:
                    mRBCash.setChecked(false);
                    mRBCreditCard.setChecked(false);
                    mRBCreditDebit.setChecked(true);
                    mRBPayPal.setChecked(false);
                    break;
                case R.id.rb_credit_card:
                    mRBCash.setChecked(false);
                    mRBCreditCard.setChecked(true);
                    mRBCreditDebit.setChecked(false);
                    mRBPayPal.setChecked(false);
                    break;
                case R.id.rb_paypal:
                    mRBCash.setChecked(false);
                    mRBCreditCard.setChecked(false);
                    mRBCreditDebit.setChecked(false);
                    mRBPayPal.setChecked(true);
                    break;
                default:
                    mRBCash.setChecked(true);
                    mRBCreditCard.setChecked(false);
                    mRBCreditDebit.setChecked(false);
                    mRBPayPal.setChecked(false);
                    break;
            }
        }
    };

    private class ContinueTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(CheckoutActivity.this);
            pd.setMessage("Processing your purchase.");
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
            Toast.makeText(mContext, getString(R.string.thank_you), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(mContext, ItemListActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }

    private View.OnClickListener mToolbarBackClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

}
