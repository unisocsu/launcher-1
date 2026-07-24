package com.example.keylauncher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class AppLoader {

    private final PackageManager packageManager;

    public AppLoader(PackageManager packageManager) {
        this.packageManager = packageManager;
    }

    public List<DesktopItem> loadApplications() {

        List<DesktopItem> result = new ArrayList<>();

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> apps =
                packageManager.queryIntentActivities(intent, 0);

        final Collator collator = Collator.getInstance(new Locale("he"));

        Collections.sort(apps, new Comparator<ResolveInfo>() {
            @Override
            public int compare(ResolveInfo a, ResolveInfo b) {
                return collator.compare(
                        a.loadLabel(packageManager).toString(),
                        b.loadLabel(packageManager).toString()
                );
            }
        });

        for (ResolveInfo info : apps) {

            DesktopItem item = new DesktopItem(DesktopItem.TYPE_APP);

            item.setTitle(
                    info.loadLabel(packageManager).toString()
            );

            item.setPackageName(
                    info.activityInfo.packageName
            );

            result.add(item);

        }

        return result;
    }

}
