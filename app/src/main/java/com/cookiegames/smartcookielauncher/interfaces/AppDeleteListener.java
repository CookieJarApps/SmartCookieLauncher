package com.cookiegames.smartcookielauncher.interfaces;

import com.cookiegames.smartcookielauncher.model.App;

import java.util.List;

public interface AppDeleteListener {
    boolean onAppDeleted(List<App> apps);
}
