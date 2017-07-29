package com.example.thrymr.newexpensesapp.Adapter.admin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Views.CustomFontTextView;
import com.example.thrymr.newexpensesapp.listners.admin.AdminTripItemClickListner;
import com.example.thrymr.newexpensesapp.models.AdminTrip;

import java.util.List;

/**
 * Created by Shrikant on 28/7/17.
 */

public class IndividualExpensesViewAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<AdminTrip> adminTripList;
    private Context context;
    private AdminTripItemClickListner adminTripItemClickListner;

    public IndividualExpensesViewAdpater(Context context, List<AdminTrip> adminTripList, AdminTripItemClickListner adminTripItemClickListner) {
        this.context = context;
        this.adminTripList = adminTripList;
        this.adminTripItemClickListner = adminTripItemClickListner;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_admin_individual_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DetailsViewHolder detailsViewHolder = (DetailsViewHolder) holder;
        final AdminTrip adminTrip = adminTripList.get(position);
        if (adminTrip != null) {
            if (adminTrip.getEmpName() != null) {
                detailsViewHolder.empName.setText(adminTrip.getEmpName());
            } else {
                detailsViewHolder.empName.setText("Rahul");
            }
            if (adminTrip.getEmpId() != null) {
                detailsViewHolder.empID.setText(adminTrip.getEmpId());
            } else {
                detailsViewHolder.empID.setText("137");
            }
            if (adminTrip.getTripName() != null) {
                detailsViewHolder.tripName.setText(adminTrip.getTripName());
            } else {
                detailsViewHolder.tripName.setText("Cab");
            }
            if (adminTrip.getTripDate() != null) {
                detailsViewHolder.tripDate.setText(adminTrip.getTripDate());
            } else {
                detailsViewHolder.tripDate.setText("12-07-2017");
            }
            if (adminTrip.getTotalAmount() != null) {
                detailsViewHolder.tripAmount.setText(adminTrip.getTotalAmount());
            } else {
                detailsViewHolder.tripAmount.setText("$500");
            }
            if (adminTrip.getTripStatus() != null) {
                detailsViewHolder.tripStatus.setText(adminTrip.getTripStatus());
            } else {
                detailsViewHolder.tripStatus.setText("Pending");
            }

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminTripItemClickListner.itemOnClickListner(adminTrip);
            }
        });


    }

    @Override
    public int getItemCount() {
        return adminTripList.size();
    }


    private class DetailsViewHolder extends RecyclerView.ViewHolder {
        private final CustomFontTextView empID;
        private final CustomFontTextView tripStatus;
        private CustomFontTextView empName;
        private CustomFontTextView tripName;
        private CustomFontTextView tripDate;
        private CustomFontTextView tripAmount;

        public DetailsViewHolder(View view) {
            super(view);
            empName = (CustomFontTextView) view.findViewById(R.id.emp_name);
            tripName = (CustomFontTextView) view.findViewById(R.id.trip_name);
            tripDate = (CustomFontTextView) view.findViewById(R.id.trip_date);
            tripAmount = (CustomFontTextView) view.findViewById(R.id.trip_amount);
            empID = (CustomFontTextView) view.findViewById(R.id.emp_id);
            tripStatus = (CustomFontTextView) view.findViewById(R.id.status);
        }
    }
}
