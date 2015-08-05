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

    public Shoes (){

    }

    public Shoes(String name, String description, double price, int drawableImage) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.drawableImage = drawableImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDrawableImage() {
        return drawableImage;
    }

    public void setDrawableImage(int drawableImage) {
        this.drawableImage = drawableImage;
    }

    public static Creator<Shoes> getCREATOR() {
        return CREATOR;
    }

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
