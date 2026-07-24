package com.example.keylauncher.settings;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class PreferenceStore {

    private static final String PREF_NAME = "keylauncher";

    private final SharedPreferences prefs;

    public PreferenceStore(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    /* ---------- Boolean ---------- */

    public void putBoolean(String key, boolean value) {
        prefs.edit().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key, boolean def) {
        return prefs.getBoolean(key, def);
    }

    /* ---------- Int ---------- */

    public void putInt(String key, int value) {
        prefs.edit().putInt(key, value).apply();
    }

    public int getInt(String key, int def) {
        return prefs.getInt(key, def);
    }

    /* ---------- Long ---------- */

    public void putLong(String key, long value) {
        prefs.edit().putLong(key, value).apply();
    }

    public long getLong(String key, long def) {
        return prefs.getLong(key, def);
    }

    /* ---------- Float ---------- */

    public void putFloat(String key, float value) {
        prefs.edit().putFloat(key, value).apply();
    }

    public float getFloat(String key, float def) {
        return prefs.getFloat(key, def);
    }

    /* ---------- String ---------- */

    public void putString(String key, String value) {
        prefs.edit().putString(key, value).apply();
    }

    public String getString(String key, String def) {
        return prefs.getString(key, def);
    }

    /* ---------- String Set ---------- */

    public void putStringSet(String key, Set<String> value) {
        prefs.edit().putStringSet(key, value).apply();
    }

    public Set<String> getStringSet(String key) {
        Set<String> set = prefs.getStringSet(key, null);

        if (set == null) {
            return new HashSet<>();
        }

        return new HashSet<>(set);
    }

    /* ---------- Remove ---------- */

    public void remove(String key) {
        prefs.edit().remove(key).apply();
    }

    /* ---------- Clear ---------- */

    public void clear() {
        prefs.edit().clear().apply();
    }

}
