package com.cookiegames.smartcookielauncher.activity.homeparts;

import android.graphics.Point;

import com.cookiegames.smartcookielauncher.activity.HomeActivity;
import com.cookiegames.smartcookielauncher.interfaces.DialogListener;
import com.cookiegames.smartcookielauncher.manager.Setup;
import com.cookiegames.smartcookielauncher.model.Item;
import com.cookiegames.smartcookielauncher.util.Definitions.ItemPosition;
import com.cookiegames.smartcookielauncher.widget.Desktop;
import com.cookiegames.smartcookielauncher.widget.Dock;

public class HpAppEditApplier implements DialogListener.OnEditDialogListener {
    private HomeActivity _homeActivity;
    private Item _item;

    public HpAppEditApplier(HomeActivity homeActivity) {
        _homeActivity = homeActivity;
    }

    public void onEditItem(final Item item) {
        _item = item;
        Setup.eventHandler().showEditDialog(_homeActivity, item, this);
    }

    @Override
    public void onRename(String name) {
        _item.setLabel(name);
        Setup.dataManager().saveItem(_item);
        Point point = new Point(_item._x, _item._y);

        if (_item._location.equals(ItemPosition.Desktop)) {
            Desktop desktop = _homeActivity.getDesktop();
            desktop.removeItem(desktop.getCurrentPage().coordinateToChildView(point), false);
            desktop.addItemToCell(_item, _item._x, _item._y);
        } else {
            Dock dock = _homeActivity.getDock();
            _homeActivity.getDock().removeItem(dock.coordinateToChildView(point), false);
            dock.addItemToCell(_item, _item._x, _item._y);
        }
    }
}
