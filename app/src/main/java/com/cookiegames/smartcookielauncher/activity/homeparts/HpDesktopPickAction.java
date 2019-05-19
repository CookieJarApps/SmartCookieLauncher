package com.cookiegames.smartcookielauncher.activity.homeparts;

import android.graphics.Point;

import com.cookiegames.smartcookielauncher.R;
import com.cookiegames.smartcookielauncher.activity.HomeActivity;
import com.cookiegames.smartcookielauncher.interfaces.DialogListener;
import com.cookiegames.smartcookielauncher.manager.Setup;
import com.cookiegames.smartcookielauncher.model.Item;
import com.cookiegames.smartcookielauncher.util.Tool;

public class HpDesktopPickAction implements DialogListener.OnActionDialogListener {
    private HomeActivity _homeActivity;

    public HpDesktopPickAction(HomeActivity homeActivity) {
        _homeActivity = homeActivity;
    }

    public void onPickDesktopAction() {
        Setup.eventHandler().showPickAction(_homeActivity, this);
    }

    @Override
    public void onAdd(int type) {
        Point pos = _homeActivity.getDesktop().getCurrentPage().findFreeSpace();
        if (pos != null) {
            _homeActivity.getDesktop().addItemToCell(Item.newActionItem(type), pos.x, pos.y);
        } else {
            Tool.toast(_homeActivity, R.string.toast_not_enough_space);
        }
    }
}
