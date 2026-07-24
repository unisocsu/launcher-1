package com.example.keylauncher;

public class DisplaySettings {

    private final PreferenceStore prefs;

    /* Preference Keys */
    private static final String KEY_GRID_COLUMNS = "display.grid_columns";
    private static final String KEY_ICON_SIZE = "display.icon_size";
    private static final String KEY_TEXT_SIZE = "display.text_size";
    private static final String KEY_ICON_LABELS = "display.icon_labels";
    private static final String KEY_STATUS_BAR = "display.status_bar";
    private static final String KEY_KEEP_SCREEN_ON = "display.keep_screen_on";
    private static final String KEY_DARK_MODE = "display.dark_mode";
    private static final String KEY_DESKTOP_PADDING = "display.desktop_padding";

    public DisplaySettings(PreferenceStore prefs) {
        this.prefs = prefs;
    }

    /* ===========================
       Grid Columns
       =========================== */

    public int getGridColumns() {
        return prefs.getInt(KEY_GRID_COLUMNS, 4);
    }

    public void setGridColumns(int columns) {

        if (columns < 3)
            columns = 3;

        if (columns > 8)
            columns = 8;

        prefs.putInt(KEY_GRID_COLUMNS, columns);
    }

    /* ===========================
       Icon Size (dp)
       =========================== */

    public int getIconSize() {
        return prefs.getInt(KEY_ICON_SIZE, 56);
    }

    public void setIconSize(int size) {

        if (size < 32)
            size = 32;

        if (size > 128)
            size = 128;

        prefs.putInt(KEY_ICON_SIZE, size);
    }

    /* ===========================
       Text Size (sp)
       =========================== */

    public int getTextSize() {
        return prefs.getInt(KEY_TEXT_SIZE, 12);
    }

    public void setTextSize(int size) {

        if (size < 8)
            size = 8;

        if (size > 24)
            size = 24;

        prefs.putInt(KEY_TEXT_SIZE, size);
    }

    /* ===========================
       Show Icon Labels
       =========================== */

    public boolean isShowLabels() {
        return prefs.getBoolean(KEY_ICON_LABELS, true);
    }

    public void setShowLabels(boolean value) {
        prefs.putBoolean(KEY_ICON_LABELS, value);
    }

    /* ===========================
       Status Bar
       =========================== */

    public boolean isStatusBarVisible() {
        return prefs.getBoolean(KEY_STATUS_BAR, true);
    }

    public void setStatusBarVisible(boolean value) {
        prefs.putBoolean(KEY_STATUS_BAR, value);
    }

    /* ===========================
       Keep Screen On
       =========================== */

    public boolean isKeepScreenOn() {
        return prefs.getBoolean(KEY_KEEP_SCREEN_ON, false);
    }

    public void setKeepScreenOn(boolean value) {
        prefs.putBoolean(KEY_KEEP_SCREEN_ON, value);
    }

    /* ===========================
       Dark Mode
       =========================== */

    public boolean isDarkMode() {
        return prefs.getBoolean(KEY_DARK_MODE, false);
    }

    public void setDarkMode(boolean value) {
        prefs.putBoolean(KEY_DARK_MODE, value);
    }

    /* ===========================
       Desktop Padding
       =========================== */

    public int getDesktopPadding() {
        return prefs.getInt(KEY_DESKTOP_PADDING, 8);
    }

    public void setDesktopPadding(int value) {

        if (value < 0)
            value = 0;

        if (value > 64)
            value = 64;

        prefs.putInt(KEY_DESKTOP_PADDING, value);
    }

    /* ===========================
       Restore Defaults
       =========================== */

    public void restoreDefaults() {

        setGridColumns(4);
        setIconSize(56);
        setTextSize(12);
        setShowLabels(true);
        setStatusBarVisible(true);
        setKeepScreenOn(false);
        setDarkMode(false);
        setDesktopPadding(8);

    }

}
