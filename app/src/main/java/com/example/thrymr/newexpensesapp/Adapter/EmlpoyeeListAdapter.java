package com.example.thrymr.newexpensesapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Utils.ImageCacheHandler;
import com.example.thrymr.newexpensesapp.Views.CircularImageView;
import com.example.thrymr.newexpensesapp.Views.CustomFontTextView;
import com.example.thrymr.newexpensesapp.listners.EmployeeListItemClickListner;
import com.example.thrymr.newexpensesapp.models.EmployeeName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shrikant
 */

public class EmlpoyeeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<EmployeeName> employeeNameList;
    private Context context;
    private EmployeeListItemClickListner employeeListItemClickListner;

    public EmlpoyeeListAdapter(Context context, List<EmployeeName> employeeNameList, EmployeeListItemClickListner employeeListItemClickListner) {
        this.context = context;
        this.employeeNameList = employeeNameList;
        this.employeeListItemClickListner = employeeListItemClickListner;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_employee, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DetailsViewHolder detailsViewHolder = (DetailsViewHolder) holder;
        final EmployeeName employeeName = employeeNameList.get(position);
        if (employeeName != null) {
            if (employeeName.getEmpName() != null) {
                detailsViewHolder.tvEmployeeName.setText("Shrikant Tripathi");
            } else {
                detailsViewHolder.tvEmployeeName.setText("Shrikant Tripathi");
            }
            if (employeeName.getEmpId() != null) {
                detailsViewHolder.tvEmpId.setText("EMP-Id 139");
            } else {
                detailsViewHolder.tvEmpId.setText("---");
            }
           /* if (employeeName.getEmpImage() != null) {
                ImageCacheHandler.getInstance(context).setImage(detailsViewHolder.imvEmployee, employeeName.getEmpImage(), employeeName.getEmpImage());

            } else {
                detailsViewHolder.imvEmployee.setImageResource(R.drawable.shrikant);
            }*/
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employeeListItemClickListner.itemClickListner(employeeName);
            }
        });



    }

    @Override
    public int getItemCount() {
        return employeeNameList.size();
    }



    private class DetailsViewHolder extends RecyclerView.ViewHolder {
        private final CircularImageView imvEmployee;
        private final CustomFontTextView tvEmployeeName;
        private final CustomFontTextView tvEmpId;


        public DetailsViewHolder(View view) {
            super(view);
            imvEmployee = (CircularImageView) view.findViewById(R.id.imv_employee);
            tvEmployeeName = (CustomFontTextView) view.findViewById(R.id.tv_employee_name);
            tvEmpId = (CustomFontTextView) view.findViewById(R.id.tv_emp_id);
        }
    }
}
