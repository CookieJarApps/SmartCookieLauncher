package com.cookiegames.smartcookielauncher.viewutil;

import android.view.View;

import com.cookiegames.smartcookielauncher.interfaces.ItemHistory;
import com.cookiegames.smartcookielauncher.model.Item;

public interface DesktopCallback extends ItemHistory {
    boolean addItemToPoint(Item item, int x, int y);

    boolean addItemToPage(Item item, int page);

    boolean addItemToCell(Item item, int x, int y);

    void removeItem(View view, boolean animate);
}
