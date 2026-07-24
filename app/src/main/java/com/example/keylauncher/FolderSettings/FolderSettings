package com.example.keylauncher;

public class FolderSettings {

    private final PreferenceStore prefs;

    private static final String KEY_DEFAULT_NAME = "folders.default_name";
    private static final String KEY_AUTO_CLOSE = "folders.auto_close";
    private static final String KEY_CONFIRM_DELETE = "folders.confirm_delete";
    private static final String KEY_OPEN_ANIMATION = "folders.open_animation";
    private static final String KEY_SHOW_ITEM_COUNT = "folders.show_item_count";
    private static final String KEY_MAX_COLUMNS = "folders.max_columns";

    public FolderSettings(PreferenceStore prefs) {
        this.prefs = prefs;
    }

    /* ===========================
       Default Folder Name
       =========================== */

    public String getDefaultFolderName() {
        return prefs.getString(KEY_DEFAULT_NAME, "תיקייה");
    }

    public void setDefaultFolderName(String name) {

        if (name == null || name.trim().isEmpty()) {
            name = "תיקייה";
        }

        prefs.putString(KEY_DEFAULT_NAME, name);
    }

    /* ===========================
       Auto Close Folder
       =========================== */

    public boolean isAutoCloseEnabled() {
        return prefs.getBoolean(KEY_AUTO_CLOSE, true);
    }

    public void setAutoCloseEnabled(boolean enabled) {
        prefs.putBoolean(KEY_AUTO_CLOSE, enabled);
    }

    /* ===========================
       Confirm Delete
       =========================== */

    public boolean isConfirmDeleteEnabled() {
        return prefs.getBoolean(KEY_CONFIRM_DELETE, true);
    }

    public void setConfirmDeleteEnabled(boolean enabled) {
        prefs.putBoolean(KEY_CONFIRM_DELETE, enabled);
    }

    /* ===========================
       Folder Animation
       =========================== */

    public boolean isOpenAnimationEnabled() {
        return prefs.getBoolean(KEY_OPEN_ANIMATION, true);
    }

    public void setOpenAnimationEnabled(boolean enabled) {
        prefs.putBoolean(KEY_OPEN_ANIMATION, enabled);
    }

    /* ===========================
       Show Item Count
       =========================== */

    public boolean isShowItemCountEnabled() {
        return prefs.getBoolean(KEY_SHOW_ITEM_COUNT, true);
    }

    public void setShowItemCountEnabled(boolean enabled) {
        prefs.putBoolean(KEY_SHOW_ITEM_COUNT, enabled);
    }

    /* ===========================
       Folder Columns
       =========================== */

    public int getMaxColumns() {
        return prefs.getInt(KEY_MAX_COLUMNS, 4);
    }

    public void setMaxColumns(int columns) {

        if (columns < 2)
            columns = 2;

        if (columns > 6)
            columns = 6;

        prefs.putInt(KEY_MAX_COLUMNS, columns);
    }

    /* ===========================
       Restore Defaults
       =========================== */

    public void restoreDefaults() {

        setDefaultFolderName("תיקייה");
        setAutoCloseEnabled(true);
        setConfirmDeleteEnabled(true);
        setOpenAnimationEnabled(true);
        setShowItemCountEnabled(true);
        setMaxColumns(4);

    }

}
