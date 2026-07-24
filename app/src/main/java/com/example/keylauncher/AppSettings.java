package com.example.keylauncher;

import java.util.HashSet;
import java.util.Set;

public class AppSettings {

    private final PreferenceStore prefs;

    private static final String KEY_HIDDEN_APPS = "apps.hidden";
    private static final String KEY_SORT_MODE = "apps.sort_mode";

    public static final int SORT_NAME = 0;
    public static final int SORT_INSTALL_TIME = 1;
    public static final int SORT_LAST_UPDATE = 2;
    public static final int SORT_MANUAL = 3;

    public AppSettings(PreferenceStore prefs) {
        this.prefs = prefs;
    }

    /* ===========================
       Hidden Apps
       =========================== */

    public Set<String> getHiddenApps() {
        return prefs.getStringSet(KEY_HIDDEN_APPS);
    }

    public boolean isHidden(String packageName) {
        return getHiddenApps().contains(packageName);
    }

    public void hideApp(String packageName) {

        Set<String> set = getHiddenApps();
        set.add(packageName);

        prefs.putStringSet(KEY_HIDDEN_APPS, set);

    }

    public void showApp(String packageName) {

        Set<String> set = getHiddenApps();
        set.remove(packageName);

        prefs.putStringSet(KEY_HIDDEN_APPS, set);

    }

    public void clearHiddenApps() {
        prefs.remove(KEY_HIDDEN_APPS);
    }

    /* ===========================
       Custom Titles
       =========================== */

    public void setCustomTitle(String packageName, String title) {

        prefs.putString(
                "apps.title." + packageName,
                title
        );

    }

    public String getCustomTitle(String packageName) {

        return prefs.getString(
                "apps.title." + packageName,
                null
        );

    }

    public void removeCustomTitle(String packageName) {

        prefs.remove(
                "apps.title." + packageName
        );

    }

    /* ===========================
       Sort Mode
       =========================== */

    public void setSortMode(int mode) {

        prefs.putInt(KEY_SORT_MODE, mode);

    }

    public int getSortMode() {

        return prefs.getInt(
                KEY_SORT_MODE,
                SORT_NAME
        );

    }

    /* ===========================
       Reset
       =========================== */

    public void restoreDefaults() {

        clearHiddenApps();
        setSortMode(SORT_NAME);

    }

}
