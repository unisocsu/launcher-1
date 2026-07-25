package com.example.keylauncher;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AppSearchDialog {

    private final Context context;

    private final List<LauncherItem> sourceItems;
    private final List<LauncherItem> filteredItems;

    private Dialog dialog;

    private EditText searchBox;
    private RecyclerView recyclerView;

    private LauncherAdapter adapter;

    public AppSearchDialog(Context context,
                           List<LauncherItem> launcherItems,
                           SettingsManager settings) {

        this.context = context;

        sourceItems = new ArrayList<>(launcherItems);
        filteredItems = new ArrayList<>(launcherItems);

        dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.dialog_app_search);

        Window window = dialog.getWindow();

        if (window != null) {

            window.setLayout(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT);

        }

        searchBox =
                dialog.findViewById(R.id.searchBox);

        recyclerView =
                dialog.findViewById(R.id.searchRecycler);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(context));

        adapter =
                new LauncherAdapter(
                        context,
                        settings);

        adapter.setItems(filteredItems);

        recyclerView.setAdapter(adapter);

        searchBox.addTextChangedListener(
                new TextWatcher() {

                    @Override
                    public void beforeTextChanged(CharSequence s,
                                                  int start,
                                                  int count,
                                                  int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s,
                                              int start,
                                              int before,
                                              int count) {

                        filter(s.toString());

                    }

                    @Override
                    public void afterTextChanged(
                            Editable editable) {
                    }

                });

    }

    private void filter(String text) {

        filteredItems.clear();

        String query =
                text.toLowerCase(Locale.getDefault());

        for (LauncherItem item : sourceItems) {

            if (!item.isApplication())
                continue;

            String title =
                    item.getTitle();

            if (title == null)
                title = "";

            if (title.toLowerCase(Locale.getDefault())
                    .contains(query)) {

                filteredItems.add(item);

            }

        }

        adapter.setItems(filteredItems);

    }

    public void show() {

        filter("");

        dialog.show();

        searchBox.requestFocus();

    }

    public void dismiss() {

        dialog.dismiss();

    }

    public boolean isShowing() {

        return dialog.isShowing();

    }

}
