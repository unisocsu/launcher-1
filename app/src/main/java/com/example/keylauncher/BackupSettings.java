package com.example.keylauncher;

public class BackupSettings {

    private final PreferenceStore prefs;

    private static final String KEY_BACKUP_ENABLED =
            "backup.enabled";

    private static final String KEY_BACKUP_PATH =
            "backup.path";

    private static final String KEY_LAST_BACKUP =
            "backup.last_time";

    private static final String KEY_AUTO_BACKUP =
            "backup.auto";

    private static final String KEY_BACKUP_NAME =
            "backup.file_name";

    public BackupSettings(PreferenceStore prefs) {
        this.prefs = prefs;
    }

    /* ===========================
       Backup Enabled
       =========================== */

    public boolean isEnabled() {
        return prefs.getBoolean(KEY_BACKUP_ENABLED, true);
    }

    public void setEnabled(boolean enabled) {
        prefs.putBoolean(KEY_BACKUP_ENABLED, enabled);
    }

    /* ===========================
       Backup Path
       =========================== */

    public String getBackupPath() {
        return prefs.getString(KEY_BACKUP_PATH, "");
    }

    public void setBackupPath(String path) {

        if (path == null)
            path = "";

        prefs.putString(KEY_BACKUP_PATH, path);
    }

    /* ===========================
       Backup File Name
       =========================== */

    public String getBackupFileName() {
        return prefs.getString(KEY_BACKUP_NAME,
                "KeyLauncher_Backup.json");
    }

    public void setBackupFileName(String name) {

        if (name == null || name.trim().isEmpty())
            name = "KeyLauncher_Backup.json";

        prefs.putString(KEY_BACKUP_NAME, name);
    }

    /* ===========================
       Auto Backup
       =========================== */

    public boolean isAutoBackupEnabled() {
        return prefs.getBoolean(KEY_AUTO_BACKUP, false);
    }

    public void setAutoBackupEnabled(boolean enabled) {
        prefs.putBoolean(KEY_AUTO_BACKUP, enabled);
    }

    /* ===========================
       Last Backup Time
       =========================== */

    public long getLastBackupTime() {
        return prefs.getLong(KEY_LAST_BACKUP, 0);
    }

    public void setLastBackupTime(long time) {
        prefs.putLong(KEY_LAST_BACKUP, time);
    }

    /* ===========================
       Restore Defaults
       =========================== */

    public void restoreDefaults() {

        setEnabled(true);
        setBackupPath("");
        setBackupFileName("KeyLauncher_Backup.json");
        setAutoBackupEnabled(false);
        setLastBackupTime(0);

    }

}
