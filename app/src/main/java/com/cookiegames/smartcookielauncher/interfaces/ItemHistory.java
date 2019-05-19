package com.cookiegames.smartcookielauncher.interfaces;

import android.view.View;

import com.cookiegames.smartcookielauncher.model.Item;

public interface ItemHistory {
    void setLastItem(Item item, View view);

    void revertLastItem();

    void consumeLastItem();
}
