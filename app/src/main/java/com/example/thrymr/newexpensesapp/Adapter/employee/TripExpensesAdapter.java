package com.example.thrymr.newexpensesapp.Adapter.employee;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Views.CustomFontTextView;
import com.example.thrymr.newexpensesapp.Views.CustomImageView;
import com.example.thrymr.newexpensesapp.listners.employee.TripExpensesItemClickListner;
import com.example.thrymr.newexpensesapp.models.TripExpenses;

import java.util.List;

/**
 * Created by thrymr on 28/7/17.
 */

public class TripExpensesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<TripExpenses> tripExpensesList;
    private Context context;
    private TripExpensesItemClickListner tripExpensesItemClickListner;

    public TripExpensesAdapter(Context context, List<TripExpenses> tripExpensesList, TripExpensesItemClickListner tripExpensesItemClickListner) {
        this.context = context;
        this.tripExpensesList = tripExpensesList;
        this.tripExpensesItemClickListner = tripExpensesItemClickListner;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trip_expenses, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DetailsViewHolder detailsViewHolder = (DetailsViewHolder) holder;
        final TripExpenses tripExpenses= tripExpensesList.get(position);
        if (tripExpenses != null) {
            if (tripExpenses.getTripName() != null) {
                detailsViewHolder.tripAreaTv.setText(tripExpenses.getTripName());
            } else {
                detailsViewHolder.tripAreaTv.setText("Mumbai");
            }
            if (tripExpenses.getTripDate() != null) {
                detailsViewHolder.tripDateTv.setText(tripExpenses.getTripDate());
            } else {
                detailsViewHolder.tripDateTv.setText("12-07-2017");
            }
            if (tripExpenses.getTripStatus() != null) {
                detailsViewHolder.tripStatusTv.setText(tripExpenses.getTripStatus());
            } else {
                detailsViewHolder.tripStatusTv.setText("Accept");
            }
            if (tripExpenses.getTotalAmount() != null) {
                detailsViewHolder.tripCostTv.setText(tripExpenses.getTotalAmount());
            } else {
                detailsViewHolder.tripCostTv.setText("$30");
            }

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tripExpensesItemClickListner.itemOnClickListner(tripExpenses);
            }
        });



    }

    @Override
    public int getItemCount() {
        return tripExpensesList.size();
    }



    private class DetailsViewHolder extends RecyclerView.ViewHolder {


        private  CustomFontTextView tripCostTv;
        private  CustomFontTextView tripStatusTv;
        private  CustomFontTextView tripDateTv;
        private  CustomFontTextView tripAreaTv;

        public DetailsViewHolder(View view) {
            super(view);
            tripAreaTv = (CustomFontTextView) view.findViewById(R.id.trip_area_tv);
            tripDateTv = (CustomFontTextView) view.findViewById(R.id.trip_date_tv);
            tripStatusTv = (CustomFontTextView) view.findViewById(R.id.trip_status_tv);
            tripCostTv = (CustomFontTextView) view.findViewById(R.id.trip_cost_tv);
        }
    }
}
