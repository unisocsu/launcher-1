package com.example.keylauncher;

public class DesktopItem {

    public static final int TYPE_APP = 0;
    public static final int TYPE_FOLDER = 1;
    public static final int TYPE_WIDGET = 2;

    private int type;

    private String title;

    private String packageName;

    private int appWidgetId = -1;

    private int cellX;
    private int cellY;

    private int spanX = 1;
    private int spanY = 1;

    private boolean hidden;

    public DesktopItem(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getAppWidgetId() {
        return appWidgetId;
    }

    public void setAppWidgetId(int appWidgetId) {
        this.appWidgetId = appWidgetId;
    }

    public int getCellX() {
        return cellX;
    }

    public void setCellX(int cellX) {
        this.cellX = cellX;
    }

    public int getCellY() {
        return cellY;
    }

    public void setCellY(int cellY) {
        this.cellY = cellY;
    }

    public int getSpanX() {
        return spanX;
    }

    public void setSpanX(int spanX) {
        this.spanX = spanX;
    }

    public int getSpanY() {
        return spanY;
    }

    public void setSpanY(int spanY) {
        this.spanY = spanY;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

}
