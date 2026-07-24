package com.example.keylauncher;

public class MouseSettings {

    private final PreferenceStore prefs;

    private static final String KEY_MOUSE_ENABLED =
            "mouse.enabled";

    private static final String KEY_AUTO_ENABLE =
            "mouse.auto_enable";

    private static final String KEY_SUPPORT_LIST =
            "mouse.support_list";

    private static final String KEY_POINTER_SPEED =
            "mouse.pointer_speed";

    private static final String KEY_SHOW_CURSOR =
            "mouse.show_cursor";

    public MouseSettings(PreferenceStore prefs) {
        this.prefs = prefs;
    }

    /* ===========================
       Mouse Enabled
       =========================== */

    public boolean isEnabled() {
        return prefs.getBoolean(KEY_MOUSE_ENABLED, false);
    }

    public void setEnabled(boolean enabled) {
        prefs.putBoolean(KEY_MOUSE_ENABLED, enabled);
    }

    /* ===========================
       Auto Enable
       =========================== */

    public boolean isAutoEnable() {
        return prefs.getBoolean(KEY_AUTO_ENABLE, false);
    }

    public void setAutoEnable(boolean enabled) {
        prefs.putBoolean(KEY_AUTO_ENABLE, enabled);
    }

    /* ===========================
       Support List
       =========================== */

    public String getSupportList() {
        return prefs.getString(KEY_SUPPORT_LIST, "");
    }

    public void setSupportList(String value) {

        if (value == null) {
            value = "";
        }

        prefs.putString(KEY_SUPPORT_LIST, value);
    }

    /* ===========================
       Pointer Speed
       =========================== */

    public int getPointerSpeed() {
        return prefs.getInt(KEY_POINTER_SPEED, 5);
    }

    public void setPointerSpeed(int speed) {

        if (speed < 1)
            speed = 1;

        if (speed > 10)
            speed = 10;

        prefs.putInt(KEY_POINTER_SPEED, speed);
    }

    /* ===========================
       Cursor Visibility
       =========================== */

    public boolean isCursorVisible() {
        return prefs.getBoolean(KEY_SHOW_CURSOR, true);
    }

    public void setCursorVisible(boolean visible) {
        prefs.putBoolean(KEY_SHOW_CURSOR, visible);
    }

    /* ===========================
       Restore Defaults
       =========================== */

    public void restoreDefaults() {

        setEnabled(false);
        setAutoEnable(false);
        setSupportList("");
        setPointerSpeed(5);
        setCursorVisible(true);

    }

}
