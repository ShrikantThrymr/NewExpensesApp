package com.example.thrymr.newexpensesapp.Adapter.admin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Views.CustomFontTextView;
import com.example.thrymr.newexpensesapp.Views.CustomImageView;
import com.example.thrymr.newexpensesapp.listners.employee.TripNameExpensesItemClicklistner;
import com.example.thrymr.newexpensesapp.models.IndividualExpenses;

import java.util.List;

/**
 * Created by thrymr on 29/7/17.
 */

public class TripExpensesItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<IndividualExpenses> individualExpensesList;
    private Context context;
    private TripNameExpensesItemClicklistner tripNameExpensesItemClicklistner;

    public TripExpensesItemAdapter(Context context, List<IndividualExpenses> individualExpensesList, TripNameExpensesItemClicklistner tripNameExpensesItemClicklistner) {
        this.context = context;
        this.individualExpensesList = individualExpensesList;
        this.tripNameExpensesItemClicklistner = tripNameExpensesItemClicklistner;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_individual_expenses, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DetailsViewHolder detailsViewHolder = (DetailsViewHolder) holder;
        final IndividualExpenses individualExpenses = individualExpensesList.get(position);
        if (individualExpenses != null) {
            if (individualExpenses.getExpensesName() != null) {
                detailsViewHolder.tripAreaTv.setText(individualExpenses.getExpensesName());
            } else {
                detailsViewHolder.tripAreaTv.setText("Cab");
            }
            if (individualExpenses.getExpensesDate() != null) {
                detailsViewHolder.tripDateTv.setText(individualExpenses.getExpensesDate());
            } else {
                detailsViewHolder.tripDateTv.setText("12-07-2017");
            }
            if (individualExpenses.getExpensesStatus() != null) {
                detailsViewHolder.tripStatusTv.setText(individualExpenses.getExpensesStatus());
            } else {
                detailsViewHolder.tripStatusTv.setText("Accept");
            }
            if (individualExpenses.getTotalAmount() != null) {
                detailsViewHolder.tripCostTv.setText(individualExpenses.getTotalAmount());
            } else {
                detailsViewHolder.tripCostTv.setText("$30");
            }
        }
        detailsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tripNameExpensesItemClicklistner.itrmOnClickListner(individualExpenses);
            }
        });

    }

    @Override
    public int getItemCount() {
        return individualExpensesList.size();
    }


    private class DetailsViewHolder extends RecyclerView.ViewHolder {


        private CustomImageView nextScreenTv;
        private CustomFontTextView tripCostTv;
        private CustomFontTextView tripStatusTv;
        private CustomFontTextView tripDateTv;
        private CustomFontTextView tripAreaTv;

        public DetailsViewHolder(View view) {
            super(view);
            tripAreaTv = (CustomFontTextView) view.findViewById(R.id.trip_area_tv);
            tripDateTv = (CustomFontTextView) view.findViewById(R.id.trip_date_tv);
            tripStatusTv = (CustomFontTextView) view.findViewById(R.id.trip_status_tv);
            tripCostTv = (CustomFontTextView) view.findViewById(R.id.trip_cost_tv);
        }
    }
}