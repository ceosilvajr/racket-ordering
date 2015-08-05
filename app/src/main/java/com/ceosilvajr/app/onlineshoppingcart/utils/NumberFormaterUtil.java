package com.ceosilvajr.app.onlineshoppingcart.utils;

import java.text.DecimalFormat;

/**
 * Created by ceosilvajr on 10/29/14.
 */
public class NumberFormaterUtil {
    public static String numberToMoney(double amount) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return df.format(amount);
    }
}
