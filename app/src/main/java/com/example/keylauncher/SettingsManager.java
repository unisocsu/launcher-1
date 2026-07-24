package com.example.keylauncher;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class SettingsManager {

    private static final String PREF_NAME = "keylauncher";

    private final SharedPreferences prefs;

    public SettingsManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    /*
     * ===================================
     * Keys
     * ===================================
     */

    public static final String GRID_COLUMNS = "grid_columns";
    public static final String ICON_SIZE = "icon_size";
    public static final String TEXT_SIZE = "text_size";
    public static final String SHOW_HIDDEN = "show_hidden";
    public static final String DESKTOP_LOCKED = "desktop_locked";

    public static final String HIDDEN_APPS = "hidden_apps";
    public static final String CUSTOM_TITLES = "custom_titles";
    public static final String DESKTOP_LAYOUT = "desktop_layout";
    public static final String WIDGET_LAYOUT = "widget_layout";

    /*
     * ===================================
     * Generic API
     * ===================================
     */

    public void putBoolean(String key, boolean value) {
        prefs.edit().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key, boolean def) {
        return prefs.getBoolean(key, def);
    }

    public void putInt(String key, int value) {
        prefs.edit().putInt(key, value).apply();
    }

    public int getInt(String key, int def) {
        return prefs.getInt(key, def);
    }

    public void putString(String key, String value) {
        prefs.edit().putString(key, value).apply();
    }

    public String getString(String key, String def) {
        return prefs.getString(key, def);
    }

    public void putStringSet(String key, Set<String> value) {
        prefs.edit().putStringSet(key, value).apply();
    }

    public Set<String> getStringSet(String key) {
        Set<String> value = prefs.getStringSet(key, null);
        return value == null ? new HashSet<>() : new HashSet<>(value);
    }

    public void remove(String key) {
        prefs.edit().remove(key).apply();
    }

    public void clearAll() {
        prefs.edit().clear().apply();
    }
}
