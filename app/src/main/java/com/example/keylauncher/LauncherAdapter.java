package com.example.keylauncher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LauncherAdapter extends RecyclerView.Adapter<LauncherAdapter.ViewHolder> {

    public interface OnItemMoveListener {
        void onMoveRequested(LauncherItem item);
    }

    private final Context context;
    private final SettingsManager settings;
    private final List<LauncherItem> items = new ArrayList<>();

    private OnItemMoveListener moveListener;

    public LauncherAdapter(Context context,
                           SettingsManager settings) {

        this.context = context;
        this.settings = settings;
    }

    public void setItems(List<LauncherItem> list) {

        items.clear();

        if (list != null) {
            items.addAll(list);
        }

        notifyDataSetChanged();
    }

    public LauncherItem getItem(int position) {
        return items.get(position);
    }

    public void setOnItemMoveListener(OnItemMoveListener listener) {
        moveListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                         int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_launcher,
                        parent,
                        false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,
                                 int position) {

        LauncherItem item = items.get(position);

        holder.title.setText(item.getTitle());

        holder.icon.setImageDrawable(item.getIcon());

        holder.itemView.setOnClickListener(v -> {

            if (!item.isApplication())
                return;

            Intent intent =
                    context.getPackageManager()
                            .getLaunchIntentForPackage(
                                    item.getPackageName());

            if (intent != null) {
                context.startActivity(intent);
            }

        });

        holder.itemView.setOnLongClickListener(v -> {

            PopupMenu menu = new PopupMenu(context, v);

            MenuInflater inflater = menu.getMenuInflater();

            inflater.inflate(R.menu.app_menu,
                    menu.getMenu());

            menu.setOnMenuItemClickListener(menuItem -> {

                switch (menuItem.getItemId()) {

                    case R.id.menuRename:

                        return true;

                    case R.id.menuHide:

                        settings.apps.hideApp(
                                item.getPackageName());

                        items.remove(holder.getAdapterPosition());

                        notifyItemRemoved(holder.getAdapterPosition());

                        return true;

                    case R.id.menuMove:

                        if (moveListener != null) {
                            moveListener.onMoveRequested(item);
                        }

                        return true;

                    case R.id.menuUninstall:

                        Intent uninstall =
                                new Intent(
                                        Intent.ACTION_DELETE,
                                        Uri.parse(
                                                "package:"
                                                        + item.getPackageName()));

                        context.startActivity(uninstall);

                        return true;

                }

                return false;

            });

            menu.show();

            return true;

        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title;

        ViewHolder(View itemView) {

            super(itemView);

            icon = itemView.findViewById(R.id.icon);

            title = itemView.findViewById(R.id.title);

        }

    }

}
