package com.example.keylauncher;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;

    private SettingsManager settings;

    private SettingsAdapter adapter;

    private final List<SettingItem> items = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        settings = new SettingsManager(this);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerView = findViewById(R.id.settingsRecycler);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        createItems();

        adapter = new SettingsAdapter(
                this,
                items,
                settings
        );

        recyclerView.setAdapter(adapter);
    }

    private void createItems() {

        items.clear();

        items.add(new SettingItem(
                "מסך הבית",
                "רשת, אייקונים וטקסט"));

        items.add(new SettingItem(
                "ווידג'טים",
                "ניהול והוספה"));

        items.add(new SettingItem(
                "אפליקציות",
                "הסתרה ושמות"));

        items.add(new SettingItem(
                "תיקיות",
                "ניהול תיקיות"));

        items.add(new SettingItem(
                "מקשים",
                "מקשי חומרה"));

        items.add(new SettingItem(
                "עכבר",
                "מצב עכבר"));

        items.add(new SettingItem(
                "גיבוי ושחזור",
                "שמירת ההגדרות"));

        items.add(new SettingItem(
                "אודות",
                "מידע על הלאנצ'ר"));

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
