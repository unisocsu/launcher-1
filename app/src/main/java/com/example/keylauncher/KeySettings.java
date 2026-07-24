package com.example.keylauncher;

import android.view.KeyEvent;

public class KeySettings {

    private final PreferenceStore prefs;

    private static final String KEY_CALL_SHORT_PRESS = "keys.call.short_press";
    private static final String KEY_CALL_LONG_PRESS = "keys.call.long_press";
    private static final String KEY_LONG_PRESS_TIMEOUT = "keys.long_press_timeout";
    private static final String KEY_ENABLE_HARDWARE_KEYS = "keys.hardware.enabled";

    /*
     * פעולות
     */
    public static final int ACTION_NONE = 0;
    public static final int ACTION_TOGGLE_MOUSE = 1;
    public static final int ACTION_OPEN_DIALER = 2;
    public static final int ACTION_OPEN_SEARCH = 3;
    public static final int ACTION_OPEN_SETTINGS = 4;
    public static final int ACTION_SHOW_APPS = 5;

    public KeySettings(PreferenceStore prefs) {
        this.prefs = prefs;
    }

    /* ===========================
       Hardware Keys
       =========================== */

    public boolean isHardwareKeysEnabled() {
        return prefs.getBoolean(KEY_ENABLE_HARDWARE_KEYS, true);
    }

    public void setHardwareKeysEnabled(boolean enabled) {
        prefs.putBoolean(KEY_ENABLE_HARDWARE_KEYS, enabled);
    }

    /* ===========================
       KEYCODE_CALL Short Press
       =========================== */

    public int getCallShortPressAction() {
        return prefs.getInt(KEY_CALL_SHORT_PRESS, ACTION_TOGGLE_MOUSE);
    }

    public void setCallShortPressAction(int action) {
        prefs.putInt(KEY_CALL_SHORT_PRESS, action);
    }

    /* ===========================
       KEYCODE_CALL Long Press
       =========================== */

    public int getCallLongPressAction() {
        return prefs.getInt(KEY_CALL_LONG_PRESS, ACTION_OPEN_DIALER);
    }

    public void setCallLongPressAction(int action) {
        prefs.putInt(KEY_CALL_LONG_PRESS, action);
    }

    /* ===========================
       Long Press Timeout
       =========================== */

    public int getLongPressTimeout() {
        return prefs.getInt(KEY_LONG_PRESS_TIMEOUT, 500);
    }

    public void setLongPressTimeout(int timeout) {

        if (timeout < 200)
            timeout = 200;

        if (timeout > 3000)
            timeout = 3000;

        prefs.putInt(KEY_LONG_PRESS_TIMEOUT, timeout);
    }

    /* ===========================
       Restore Defaults
       =========================== */

    public void restoreDefaults() {

        setHardwareKeysEnabled(true);

        setCallShortPressAction(ACTION_TOGGLE_MOUSE);

        setCallLongPressAction(ACTION_OPEN_DIALER);

        setLongPressTimeout(500);

    }

}
