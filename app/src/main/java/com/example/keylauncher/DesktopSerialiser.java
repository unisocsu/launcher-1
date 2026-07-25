package com.example.keylauncher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DesktopSerializer {

    public String serialize(List<LauncherItem> items) {

        JSONArray array = new JSONArray();

        try {

            for (LauncherItem item : items) {

                JSONObject object = new JSONObject();

                object.put("id", item.getId());
                object.put("type", item.getType());

                object.put("title", item.getTitle());

                object.put("packageName",
                        item.getPackageName());

                object.put("className",
                        item.getClassName());

                object.put("widgetId",
                        item.getAppWidgetId());

                object.put("cellX",
                        item.getCellX());

                object.put("cellY",
                        item.getCellY());

                object.put("spanX",
                        item.getSpanX());

                object.put("spanY",
                        item.getSpanY());

                object.put("hidden",
                        item.isHidden());

                object.put("movable",
                        item.isMovable());

                object.put("customData",
                        item.getCustomData());

                array.put(object);

            }

        } catch (JSONException e) {

            e.printStackTrace();

        }

        return array.toString();

    }

    public List<LauncherItem> deserialize(String json) {

        List<LauncherItem> items =
                new ArrayList<>();

        if (json == null)
            return items;

        if (json.trim().length() == 0)
            return items;

        try {

            JSONArray array =
                    new JSONArray(json);

            for (int i = 0; i < array.length(); i++) {

                JSONObject object =
                        array.getJSONObject(i);

                LauncherItem item =
                        new LauncherItem();

                item.setId(
                        object.optLong("id"));

                item.setType(
                        object.optInt("type"));

                item.setTitle(
                        object.optString("title"));

                item.setPackageName(
                        object.optString("packageName"));

                item.setClassName(
                        object.optString("className"));

                item.setAppWidgetId(
                        object.optInt("widgetId", -1));

                item.setCellX(
                        object.optInt("cellX"));

                item.setCellY(
                        object.optInt("cellY"));

                item.setSpanX(
                        object.optInt("spanX", 1));

                item.setSpanY(
                        object.optInt("spanY", 1));

                item.setHidden(
                        object.optBoolean("hidden"));

                item.setMovable(
                        object.optBoolean("movable", true));

                item.setCustomData(
                        object.optString("customData"));

                items.add(item);

            }

        } catch (JSONException e) {

            e.printStackTrace();

        }

        return items;

    }

}
