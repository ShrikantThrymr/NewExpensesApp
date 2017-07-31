package com.example.thrymr.newexpensesapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Views.CustomFontTextView;
import com.example.thrymr.newexpensesapp.models.NotificationModel;

import java.util.ArrayList;

/**
 * Created by thrymr on 28/7/17.
 */
public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    private ArrayList<NotificationModel> listOfNotifications;

    public NotificationAdapter(ArrayList<NotificationModel> listOfNotifications) {
        this.listOfNotifications = listOfNotifications;
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification_view, parent, false);

        NotificationViewHolder itemViewHolder = new NotificationViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
        final NotificationModel notifications = listOfNotifications.get(position);
        holder.notificationAreaTv.setText(notifications.getNotificationName());
        holder.notificationDateTv.setText(notifications.getNotificationDate());
        holder.notificationStatusTv.setText(notifications.getNotificationStatus());


    }


    @Override
    public int getItemCount() {
        return listOfNotifications.size();

    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder {
        private CustomFontTextView notificationAreaTv;
        private CustomFontTextView notificationDateTv;
        private CustomFontTextView notificationStatusTv;


        public NotificationViewHolder(View itemView) {
            super(itemView);
            notificationAreaTv = (CustomFontTextView) itemView.findViewById(R.id.notification_area_tv);
            notificationDateTv = (CustomFontTextView) itemView.findViewById(R.id.notification_date_tv);
            notificationStatusTv = (CustomFontTextView) itemView.findViewById(R.id.notification_status_tv);
        }
    }
}