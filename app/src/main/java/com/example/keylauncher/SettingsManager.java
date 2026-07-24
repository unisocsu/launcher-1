package com.example.keylauncher.settings;

import android.content.Context;

public class SettingsManager {

    private final PreferenceStore store;

    private final DisplaySettings displaySettings;
    private final DesktopSettings desktopSettings;
    private final AppSettings appSettings;
    private final WidgetSettings widgetSettings;
    private final FolderSettings folderSettings;
    private final KeySettings keySettings;
    private final MouseSettings mouseSettings;
    private final BackupSettings backupSettings;

    public SettingsManager(Context context) {

        store = new PreferenceStore(context);

        displaySettings = new DisplaySettings(store);
        desktopSettings = new DesktopSettings(store);
        appSettings = new AppSettings(store);
        widgetSettings = new WidgetSettings(store);
        folderSettings = new FolderSettings(store);
        keySettings = new KeySettings(store);
        mouseSettings = new MouseSettings(store);
        backupSettings = new BackupSettings(store);

    }

    public DisplaySettings display() {
        return displaySettings;
    }

    public DesktopSettings desktop() {
        return desktopSettings;
    }

    public AppSettings apps() {
        return appSettings;
    }

    public WidgetSettings widgets() {
        return widgetSettings;
    }

    public FolderSettings folders() {
        return folderSettings;
    }

    public KeySettings keys() {
        return keySettings;
    }

    public MouseSettings mouse() {
        return mouseSettings;
    }

    public BackupSettings backup() {
        return backupSettings;
    }

}
