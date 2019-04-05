package com.example.androidassignment2;

import android.media.Image;
import android.widget.ImageView;

public class item {
    String Name;
    String Message;
    int icon;

    public item(String name, String message, int icon) {
        Name = name;
        Message = message;
        this.icon = icon;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
