package com.example.keylauncher;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LauncherAdapter.OnItemMoveListener {

    public static final int APPWIDGET_HOST_ID = 1024;

    private RecyclerView recyclerView;

    private GridLayoutManager gridLayoutManager;

    private LauncherAdapter launcherAdapter;

    private SettingsManager settings;

    private AppLoader appLoader;

    private DesktopLayoutManager desktopLayout;

    private AppWidgetManager appWidgetManager;

    private AppWidgetHost appWidgetHost;

    private List<LauncherItem> launcherItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initializeManagers();

        initializeRecyclerView();

        loadApplications();

        restoreWidgets();
    }

    private void initializeManagers() {

        settings = new SettingsManager(this);

        appLoader = new AppLoader(
                getPackageManager(),
                settings);

        desktopLayout =
                new DesktopLayoutManager(settings);

        appWidgetManager =
                AppWidgetManager.getInstance(this);

        appWidgetHost =
                new AppWidgetHost(
                        this,
                        APPWIDGET_HOST_ID);

    }

    private void initializeRecyclerView() {

        recyclerView =
                findViewById(R.id.recyclerView);

        gridLayoutManager =
                new GridLayoutManager(
                        this,
                        settings.display.getGridColumns());

        recyclerView.setLayoutManager(
                gridLayoutManager);

        launcherAdapter =
                new LauncherAdapter(
                        this,
                        settings);

        launcherAdapter.setOnItemMoveListener(this);

        recyclerView.setAdapter(
                launcherAdapter);

    }

    private void loadApplications() {

        launcherItems =
                appLoader.loadApplications();

        desktopLayout.setItems(
                launcherItems);

        launcherAdapter.setItems(
                launcherItems);

    }

    private void restoreWidgets() {

        appWidgetHost.startListening();

        /*
         * כאן בהמשך:
         *
         * 1. נקרא את JSON
         * 2. ניצור AppWidgetHostView
         * 3. נוסיף למסך
         */

    }

    @Override
    protected void onStart() {
        super.onStart();

        appWidgetHost.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();

        appWidgetHost.stopListening();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        appWidgetHost.stopListening();
    }

    @Override
    public void onMoveRequested(LauncherItem item) {

        /*
         * ייפתח מצב הזזת פריט.
         */

    }

}
