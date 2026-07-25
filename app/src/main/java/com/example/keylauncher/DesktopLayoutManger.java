package com.example.keylauncher;

import java.util.ArrayList;
import java.util.List;

public class DesktopLayoutManager {

    private final SettingsManager settings;

    private final List<LauncherItem> desktopItems =
            new ArrayList<>();

    public DesktopLayoutManager(SettingsManager settings) {

        this.settings = settings;

    }

    public void setItems(List<LauncherItem> items) {

        desktopItems.clear();

        if (items != null) {
            desktopItems.addAll(items);
        }

    }

    public List<LauncherItem> getItems() {
        return desktopItems;
    }

    public void moveItem(LauncherItem source,
                         int newCellX,
                         int newCellY) {

        for (LauncherItem item : desktopItems) {

            if (item == source)
                continue;

            if (item.getCellX() == newCellX &&
                    item.getCellY() == newCellY) {

                int oldX = source.getCellX();
                int oldY = source.getCellY();

                source.setCellX(newCellX);
                source.setCellY(newCellY);

                item.setCellX(oldX);
                item.setCellY(oldY);

                save();

                return;

            }

        }

        source.setCellX(newCellX);
        source.setCellY(newCellY);

        save();

    }

    public void save() {

        /*
         * כאן בהמשך נבנה DesktopSerializer
         * שיהפוך את desktopItems ל-JSON
         * וישמור דרך:
         *
         * settings.desktop.setLayout(json);
         */

    }

}
