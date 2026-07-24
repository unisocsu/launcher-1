package com.example.keylauncher;

public class DesktopSettings {

    private final PreferenceStore prefs;

    /* Preference Keys */

    private static final String KEY_LAYOUT = "desktop.layout";
    private static final String KEY_LOCKED = "desktop.locked";
    private static final String KEY_EDIT_MODE = "desktop.edit_mode";
    private static final String KEY_HOME_PAGE = "desktop.home_page";
    private static final String KEY_PAGE_COUNT = "desktop.page_count";
    private static final String KEY_SHOW_WIDGETS = "desktop.show_widgets";
    private static final String KEY_AUTO_SAVE = "desktop.auto_save";

    public DesktopSettings(PreferenceStore prefs) {
        this.prefs = prefs;
    }

    /* ===========================
       Desktop Layout
       =========================== */

    public String getLayout() {
        return prefs.getString(KEY_LAYOUT, "");
    }

    public void setLayout(String json) {

        if (json == null)
            json = "";

        prefs.putString(KEY_LAYOUT, json);
    }

    /* ===========================
       Desktop Locked
       =========================== */

    public boolean isLocked() {
        return prefs.getBoolean(KEY_LOCKED, false);
    }

    public void setLocked(boolean value) {
        prefs.putBoolean(KEY_LOCKED, value);
    }

    /* ===========================
       Edit Mode
       =========================== */

    public boolean isEditMode() {
        return prefs.getBoolean(KEY_EDIT_MODE, false);
    }

    public void setEditMode(boolean value) {
        prefs.putBoolean(KEY_EDIT_MODE, value);
    }

    /* ===========================
       Home Page
       =========================== */

    public int getHomePage() {
        return prefs.getInt(KEY_HOME_PAGE, 0);
    }

    public void setHomePage(int page) {

        if (page < 0)
            page = 0;

        prefs.putInt(KEY_HOME_PAGE, page);
    }

    /* ===========================
       Page Count
       =========================== */

    public int getPageCount() {
        return prefs.getInt(KEY_PAGE_COUNT, 1);
    }

    public void setPageCount(int count) {

        if (count < 1)
            count = 1;

        prefs.putInt(KEY_PAGE_COUNT, count);
    }

    /* ===========================
       Show Widgets
       =========================== */

    public boolean isShowWidgets() {
        return prefs.getBoolean(KEY_SHOW_WIDGETS, true);
    }

    public void setShowWidgets(boolean value) {
        prefs.putBoolean(KEY_SHOW_WIDGETS, value);
    }

    /* ===========================
       Auto Save
       =========================== */

    public boolean isAutoSave() {
        return prefs.getBoolean(KEY_AUTO_SAVE, true);
    }

    public void setAutoSave(boolean value) {
        prefs.putBoolean(KEY_AUTO_SAVE, value);
    }

    /* ===========================
       Restore Defaults
       =========================== */

    public void restoreDefaults() {

        setLayout("");
        setLocked(false);
        setEditMode(false);
        setHomePage(0);
        setPageCount(1);
        setShowWidgets(true);
        setAutoSave(true);

    }

}
