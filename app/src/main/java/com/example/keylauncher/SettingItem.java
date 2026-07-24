package com.example.keylauncher;

public class SettingItem {

    private final String title;
    private final String summary;

    public SettingItem(String title, String summary) {
        this.title = title;
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

}
