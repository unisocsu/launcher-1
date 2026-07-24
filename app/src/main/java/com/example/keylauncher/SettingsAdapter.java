package com.example.keylauncher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {

    private final Context context;
    private final List<SettingItem> items;
    private final SettingsManager settings;

    public SettingsAdapter(Context context,
                           List<SettingItem> items,
                           SettingsManager settings) {

        this.context = context;
        this.items = items;
        this.settings = settings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_setting, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        SettingItem item = items.get(position);

        holder.title.setText(item.getTitle());
        holder.summary.setText(item.getSummary());

        holder.itemView.setOnClickListener(v -> {

            switch (position) {

                case 0:
                    Toast.makeText(context,
                            "הגדרות מסך הבית",
                            Toast.LENGTH_SHORT).show();
                    break;

                case 1:
                    Toast.makeText(context,
                            "הגדרות ווידג'טים",
                            Toast.LENGTH_SHORT).show();
                    break;

                case 2:
                    Toast.makeText(context,
                            "הגדרות אפליקציות",
                            Toast.LENGTH_SHORT).show();
                    break;

                case 3:
                    Toast.makeText(context,
                            "הגדרות תיקיות",
                            Toast.LENGTH_SHORT).show();
                    break;

                case 4:
                    Toast.makeText(context,
                            "הגדרות מקשים",
                            Toast.LENGTH_SHORT).show();
                    break;

                case 5:
                    Toast.makeText(context,
                            "הגדרות עכבר",
                            Toast.LENGTH_SHORT).show();
                    break;

                case 6:
                    Toast.makeText(context,
                            "גיבוי ושחזור",
                            Toast.LENGTH_SHORT).show();
                    break;

                case 7:
                    Toast.makeText(context,
                            "KeyLauncher",
                            Toast.LENGTH_SHORT).show();
                    break;

            }

        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView summary;

        ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.settingTitle);
            summary = itemView.findViewById(R.id.settingSummary);
        }

    }

}
