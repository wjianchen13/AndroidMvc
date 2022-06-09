package com.example.androidmvc.mvvm.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liang on 2016/8/23.
 */
//实现Parcelable接口，可以让类在网络或进程中传递
public class User implements Parcelable{
    public String username;
    public String password;

    public User(String username,String password){
        this.username=username;
        this.password=password;
    }

    public User(Parcel in) {
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR=new Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int i) {
            return new User[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.password);
    }
}