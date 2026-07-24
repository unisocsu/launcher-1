package com.example.keylauncher;

public class WidgetSettings {

    private final PreferenceStore prefs;

    private static final String KEY_WIDGET_LAYOUT = "widgets.layout";
    private static final String KEY_WIDGET_ENABLED = "widgets.enabled";
    private static final String KEY_WIDGET_COUNT = "widgets.count";
    private static final String KEY_LAST_WIDGET_ID = "widgets.last_id";

    public WidgetSettings(PreferenceStore prefs) {
        this.prefs = prefs;
    }

    /* ===========================
       Widgets Enabled
       =========================== */

    public boolean isWidgetsEnabled() {
        return prefs.getBoolean(KEY_WIDGET_ENABLED, true);
    }

    public void setWidgetsEnabled(boolean enabled) {
        prefs.putBoolean(KEY_WIDGET_ENABLED, enabled);
    }

    /* ===========================
       Widget Layout
       =========================== */

    public String getLayout() {
        return prefs.getString(KEY_WIDGET_LAYOUT, "");
    }

    public void setLayout(String json) {

        if (json == null) {
            json = "";
        }

        prefs.putString(KEY_WIDGET_LAYOUT, json);
    }

    /* ===========================
       Widget Count
       =========================== */

    public int getWidgetCount() {
        return prefs.getInt(KEY_WIDGET_COUNT, 0);
    }

    public void setWidgetCount(int count) {

        if (count < 0) {
            count = 0;
        }

        prefs.putInt(KEY_WIDGET_COUNT, count);
    }

    /* ===========================
       Last Widget Id
       =========================== */

    public int getLastWidgetId() {
        return prefs.getInt(KEY_LAST_WIDGET_ID, -1);
    }

    public void setLastWidgetId(int id) {
        prefs.putInt(KEY_LAST_WIDGET_ID, id);
    }

    /* ===========================
       Reset
       =========================== */

    public void restoreDefaults() {

        setWidgetsEnabled(true);
        setLayout("");
        setWidgetCount(0);
        setLastWidgetId(-1);

    }

}
