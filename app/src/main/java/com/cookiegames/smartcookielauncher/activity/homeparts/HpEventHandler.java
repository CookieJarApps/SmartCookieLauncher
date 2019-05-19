package com.cookiegames.smartcookielauncher.activity.homeparts;

import android.content.Context;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.cookiegames.smartcookielauncher.interfaces.DialogListener;
import com.cookiegames.smartcookielauncher.manager.Setup;
import com.cookiegames.smartcookielauncher.model.Item;
import com.cookiegames.smartcookielauncher.util.Definitions;
import com.cookiegames.smartcookielauncher.util.LauncherAction;
import com.cookiegames.smartcookielauncher.viewutil.DialogHelper;

public class HpEventHandler implements Setup.EventHandler {
    @Override
    public void showLauncherSettings(Context context) {
        LauncherAction.RunAction(LauncherAction.Action.LauncherSettings, context);
    }

    @Override
    public void showPickAction(Context context, final DialogListener.OnActionDialogListener listener) {
        DialogHelper.selectDesktopActionDialog(context, new MaterialDialog.ListCallback() {
            @Override
            public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                if (position == 0) {
                    listener.onAdd(Definitions.ACTION_LAUNCHER);
                }
            }
        });
    }

    @Override
    public void showEditDialog(Context context, Item item, final DialogListener.OnEditDialogListener listener) {
        DialogHelper.editItemDialog("Edit Item", item.getLabel(), context, new DialogHelper.OnItemEditListener() {
            @Override
            public void itemLabel(String label) {
                listener.onRename(label);
            }
        });
    }

    @Override
    public void showDeletePackageDialog(Context context, Item item) {
        DialogHelper.deletePackageDialog(context, item);
    }
}
