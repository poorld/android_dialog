package com.teenyda.bean;

/**
 * Created by Administrator on 2018-07-29.
 */

public class Tip {
    private int imageId;
    private String message;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Tip{" +
                "imageId=" + imageId +
                ", message='" + message + '\'' +
                '}';
    }
}
