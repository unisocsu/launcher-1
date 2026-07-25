package com.example.keylauncher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * מנהל את פריסת מסך הבית.
 *
 * אחראי על:
 * - מיקום פריטים
 * - החלפת מיקומים
 * - מציאת תא פנוי
 * - שמירה וטעינה
 */
public class DesktopLayoutManager {

    private final SettingsManager settings;
    private final DesktopSerializer serializer;

    private final List<LauncherItem> items =
            new ArrayList<>();

    public DesktopLayoutManager(SettingsManager settings) {

        this.settings = settings;

        this.serializer =
                new DesktopSerializer(
                        settings.desktop);

    }

    public List<LauncherItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public void setItems(List<LauncherItem> list) {

        items.clear();

        if (list != null) {
            items.addAll(list);
        }

        sort();

    }

    public void addItem(LauncherItem item) {

        if (item == null)
            return;

        items.add(item);

        sort();

    }

    public void removeItem(LauncherItem item) {

        items.remove(item);

    }

    public LauncherItem findById(long id) {

        for (LauncherItem item : items) {

            if (item.getId() == id)
                return item;

        }

        return null;

    }

    public LauncherItem findItemAt(int cellX,
                                   int cellY) {

        for (LauncherItem item : items) {

            if (item.getCellX() == cellX &&
                    item.getCellY() == cellY) {

                return item;

            }

        }

        return null;

    }

    public boolean isCellOccupied(int cellX,
                                  int cellY) {

        return findItemAt(cellX, cellY) != null;

    }

    public boolean moveItem(LauncherItem item,
                            int newCellX,
                            int newCellY) {

        if (item == null)
            return false;

        LauncherItem other =
                findItemAt(newCellX,
                        newCellY);

        if (other == null) {

            item.setCellX(newCellX);
            item.setCellY(newCellY);

            save();

            return true;

        }

        int oldX = item.getCellX();
        int oldY = item.getCellY();

        other.setCellX(oldX);
        other.setCellY(oldY);

        item.setCellX(newCellX);
        item.setCellY(newCellY);

        save();

        return true;

    }

    public int[] findFirstFreeCell(int columns) {

        if (columns < 1)
            columns = 4;

        int row = 0;

        while (true) {

            for (int col = 0; col < columns; col++) {

                if (!isCellOccupied(col, row)) {

                    return new int[]{
                            col,
                            row
                    };

                }

            }

            row++;

        }

    }

    public void normalize(int columns) {

        if (columns < 1)
            columns = 4;

        sort();

        int x = 0;
        int y = 0;

        for (LauncherItem item : items) {

            item.setCellX(x);
            item.setCellY(y);

            x++;

            if (x >= columns) {

                x = 0;
                y++;

            }

        }

        save();

    }

    public void sort() {

        Collections.sort(items,
                new Comparator<LauncherItem>() {

                    @Override
                    public int compare(LauncherItem a,
                                       LauncherItem b) {

                        if (a.getCellY() != b.getCellY()) {

                            return a.getCellY()
                                    - b.getCellY();

                        }

                        return a.getCellX()
                                - b.getCellX();

                    }

                });

    }

    public void save() {

        serializer.save(items);

    }

    public void load() {

        items.clear();

        items.addAll(serializer.load());

        sort();

    }

    public void reset() {

        items.clear();

        serializer.clear();

    }

    public int size() {

        return items.size();

    }

}
