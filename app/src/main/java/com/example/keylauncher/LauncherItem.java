package com.example.keylauncher;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class LauncherItem implements Serializable {

    public static final int TYPE_APP = 0;
    public static final int TYPE_FOLDER = 1;
    public static final int TYPE_WIDGET = 2;
    public static final int TYPE_SHORTCUT = 3;

    private long id;

    private int type;

    private String title;

    private String packageName;

    private String className;

    private Drawable icon;

    private int appWidgetId = -1;

    private int cellX = 0;
    private int cellY = 0;

    private int spanX = 1;
    private int spanY = 1;

    private boolean hidden = false;

    private boolean movable = true;

    private String customData = "";

    public LauncherItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

        if (title == null)
            title = "";

        this.title = title;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {

        if (packageName == null)
            packageName = "";

        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {

        if (className == null)
            className = "";

        this.className = className;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
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

        if (spanX < 1)
            spanX = 1;

        this.spanX = spanX;
    }

    public int getSpanY() {
        return spanY;
    }

    public void setSpanY(int spanY) {

        if (spanY < 1)
            spanY = 1;

        this.spanY = spanY;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {

        if (customData == null)
            customData = "";

        this.customData = customData;
    }

    public boolean isApplication() {
        return type == TYPE_APP;
    }

    public boolean isFolder() {
        return type == TYPE_FOLDER;
    }

    public boolean isWidget() {
        return type == TYPE_WIDGET;
    }

    public boolean isShortcut() {
        return type == TYPE_SHORTCUT;
    }

}
