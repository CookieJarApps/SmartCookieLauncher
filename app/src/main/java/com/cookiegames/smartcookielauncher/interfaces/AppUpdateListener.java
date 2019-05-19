package com.cookiegames.smartcookielauncher.interfaces;

import com.cookiegames.smartcookielauncher.model.App;

import java.util.List;

public interface AppUpdateListener {
    boolean onAppUpdated(List<App> apps);
}
