package com.example.keylauncher;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsManager {

    private static final String PREFS = "keylauncher_settings";

    private final SharedPreferences prefs;

    public SettingsManager(Context context) {
        prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    /*
     * ==========================
     * Grid
     * ==========================
     */

    public int getGridColumns() {
        return prefs.getInt("grid_columns", 4);
    }

    public void setGridColumns(int value) {
        prefs.edit().putInt("grid_columns", value).apply();
    }

    /*
     * ==========================
     * Hidden Apps
     * ==========================
     */

    public boolean isShowHiddenApps() {
        return prefs.getBoolean("show_hidden_apps", false);
    }

    public void setShowHiddenApps(boolean value) {
        prefs.edit().putBoolean("show_hidden_apps", value).apply();
    }

    /*
     * ==========================
     * Desktop Lock
     * ==========================
     */

    public boolean isDesktopLocked() {
        return prefs.getBoolean("desktop_locked", false);
    }

    public void setDesktopLocked(boolean value) {
        prefs.edit().putBoolean("desktop_locked", value).apply();
    }

    /*
     * ==========================
     * Icon Size
     * ==========================
     */

    public int getIconSize() {
        return prefs.getInt("icon_size", 56);
    }

    public void setIconSize(int value) {
        prefs.edit().putInt("icon_size", value).apply();
    }

    /*
     * ==========================
     * Text Size
     * ==========================
     */

    public int getTextSize() {
        return prefs.getInt("text_size", 12);
    }

    public void setTextSize(int value) {
        prefs.edit().putInt("text_size", value).apply();
    }

}
