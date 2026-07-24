package com.example.keylauncher;

import android.content.Context;

public class SettingsManager {

    private final Context context;
    private final PreferenceStore store;

    public final DisplaySettings display;
    public final DesktopSettings desktop;
    public final AppSettings apps;
    public final WidgetSettings widgets;
    public final FolderSettings folders;
    public final KeySettings keys;
    public final MouseSettings mouse;
    public final BackupSettings backup;

    public SettingsManager(Context context) {

        this.context = context.getApplicationContext();

        store = new PreferenceStore(this.context);

        display = new DisplaySettings(store);
        desktop = new DesktopSettings(store);
        apps = new AppSettings(store);
        widgets = new WidgetSettings(store);
        folders = new FolderSettings(store);
        keys = new KeySettings(store);
        mouse = new MouseSettings(store);
        backup = new BackupSettings(store);

    }

    public Context getContext() {
        return context;
    }

    public PreferenceStore getStore() {
        return store;
    }

    /**
     * מוחק את כל ההגדרות של הלאנצ'ר.
     */
    public void resetAll() {

        store.clear();

    }

    /**
     * טוען את כל ההגדרות לזיכרון.
     * כרגע כל מחלקה קוראת ישירות מה-PreferenceStore,
     * אך בעתיד ניתן יהיה לממש כאן טעינה מראש (Preload)
     * אם יהיה בכך צורך.
     */
    public void load() {
        // Reserved for future use.
    }

    /**
     * שומר את כל ההגדרות.
     * כרגע כל מחלקה שומרת ישירות ל-SharedPreferences.
     */
    public void save() {
        // Reserved for future use.
    }

}
