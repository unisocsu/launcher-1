package com.example.keylauncher;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private SettingsManager settingsManager;

    private ListView listView;

    private final String[] items = {

            "מסך הבית",

            "ווידג'טים",

            "אפליקציות",

            "תיקיות",

            "מקשים",

            "עכבר",

            "גיבוי ושחזור",

            "אודות"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settingsManager = new SettingsManager(this);

        listView = new ListView(this);

        listView.setDividerHeight(1);

        listView.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items));

        setContentView(listView);

        setTitle("הגדרות");

        listView.setOnItemClickListener((parent, view, position, id) -> {

            switch (position) {

                case 0:
                    // מסך הבית
                    break;

                case 1:
                    // ווידג'טים
                    break;

                case 2:
                    // אפליקציות
                    break;

                case 3:
                    // תיקיות
                    break;

                case 4:
                    // מקשים
                    break;

                case 5:
                    // עכבר
                    break;

                case 6:
                    // גיבוי
                    break;

                case 7:
                    // אודות
                    break;

            }

        });

    }

}
