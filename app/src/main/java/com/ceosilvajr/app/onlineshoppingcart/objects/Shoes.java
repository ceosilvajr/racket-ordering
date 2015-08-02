package com.ceosilvajr.app.onlineshoppingcart.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ceosilvajr on 8/3/15.
 */
public class Shoes implements Parcelable {

    private String name;

    private String description;

    private double price;

    private int drawableImage;

    protected Shoes(Parcel in) {
        name = in.readString();
        description = in.readString();
        price = in.readDouble();
        drawableImage = in.readInt();
    }

    public static final Creator<Shoes> CREATOR = new Creator<Shoes>() {
        @Override
        public Shoes createFromParcel(Parcel in) {
            return new Shoes(in);
        }

        @Override
        public Shoes[] newArray(int size) {
            return new Shoes[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeDouble(price);
        dest.writeInt(drawableImage);
    }
}
