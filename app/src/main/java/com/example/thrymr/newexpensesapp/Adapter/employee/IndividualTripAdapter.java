package com.example.thrymr.newexpensesapp.Adapter.employee;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Views.CustomFontTextView;
import com.example.thrymr.newexpensesapp.listners.employee.TripClickListner;
import com.example.thrymr.newexpensesapp.models.TripIndividualModel;

import java.util.ArrayList;

/**
 * Created by thrymr on 28/7/17.
 */

public class IndividualTripAdapter extends RecyclerView.Adapter<IndividualTripAdapter.TripViewHolder> {
    private TripClickListner tripClickListner;
    private ArrayList<TripIndividualModel> listOfTrips;

    public IndividualTripAdapter(ArrayList<TripIndividualModel> listOfTrips) {
        this.listOfTrips = listOfTrips;
    }

    @Override
    public TripViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_individual_list, parent, false);

        TripViewHolder itemViewHolder = new TripViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final TripViewHolder holder, final int listPosition) {
        final TripIndividualModel trips = listOfTrips.get(listPosition);
        holder.tripVechicalTypeTv.setText(trips.getVichicalType());
        holder.dateTv.setText(trips.getTripDate());
        holder.moneyTv.setText(trips.getCostOfMoney());
        holder.statusTv.setText(trips.getTripStatus());
    }

    @Override
    public int getItemCount() {
        return listOfTrips.size();
    }

    public static class TripViewHolder extends RecyclerView.ViewHolder {
        private CustomFontTextView tripVechicalTypeTv;
        private CustomFontTextView dateTv;
        private CustomFontTextView statusTv;
        private CustomFontTextView moneyTv;

        public TripViewHolder(View itemView) {
            super(itemView);
            tripVechicalTypeTv = (CustomFontTextView) itemView.findViewById(R.id.trip_vechical_type_tv);
            dateTv = (CustomFontTextView) itemView.findViewById(R.id.date_tv);
            statusTv = (CustomFontTextView) itemView.findViewById(R.id.status_tv);
            moneyTv = (CustomFontTextView) itemView.findViewById(R.id.money_tv);

        }
    }
}