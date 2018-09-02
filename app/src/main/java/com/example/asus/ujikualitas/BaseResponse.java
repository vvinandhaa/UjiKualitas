package com.example.asus.ujikualitas;

/**
 * Created by Fegi on 8/20/2018.
 */

public class BaseResponse {

    private boolean error;
    private String message;

    public BaseResponse() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
