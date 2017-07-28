package com.example.thrymr.newexpensesapp.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Views.CustomFontTextView;
import com.example.thrymr.newexpensesapp.Views.CustomImageView;
import com.example.thrymr.newexpensesapp.listners.DrawerItemClickListner;
import com.example.thrymr.newexpensesapp.models.NavDrawerItem;

import java.util.ArrayList;


public class NavigationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<NavDrawerItem> navDrawerItemArrayList;
    private Context context;
    private DrawerItemClickListner drawerItemClickListner;

    public NavigationAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItemArrayList, DrawerItemClickListner drawerItemClickListner) {
        this.context = context;
        this.navDrawerItemArrayList = navDrawerItemArrayList;
        this.drawerItemClickListner = drawerItemClickListner;
        Log.d("rrrrrrrrrrrrrrrrr","------"+navDrawerItemArrayList);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.drawer_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        NavDrawerItem navDrawerItem = navDrawerItemArrayList.get(position);
        itemViewHolder.title.setText(navDrawerItem.getTitle());
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerItemClickListner.itemClickListner(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return navDrawerItemArrayList.size();
    }


    private class ItemViewHolder extends RecyclerView.ViewHolder {
        private CustomFontTextView title;

        ItemViewHolder(View v1) {
            super(v1);
            title = (CustomFontTextView) v1.findViewById(R.id.title);


        }
    }


}
