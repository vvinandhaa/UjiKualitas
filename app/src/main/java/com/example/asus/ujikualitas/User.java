package com.example.asus.ujikualitas;

/**
 * Created by Fegi on 8/20/2018.
 */

public class User extends BaseResponse{
    private UserData data;

    public User() {
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}
