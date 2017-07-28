package com.example.thrymr.newexpensesapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.thrymr.newexpensesapp.Adapter.EmlpoyeeListAdapter;
import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Views.CustomFontTextView;
import com.example.thrymr.newexpensesapp.listners.EmployeeListItemClickListner;
import com.example.thrymr.newexpensesapp.models.EmployeeName;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView employeeListRecycle;
    private EmlpoyeeListAdapter emlpoyeeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ((CustomFontTextView) toolbar.findViewById(R.id.text_title)).setText(R.string.employee_expenses_list);
        setvalues();
    }

    private void setvalues() {
        employeeListRecycle = (RecyclerView) findViewById(R.id.employee_list_recycle);

        employeeListRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ArrayList<EmployeeName> employeeNameArrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            EmployeeName employeeName = new EmployeeName();
            employeeName.setEmpImage("Shrikant");
            employeeName.setEmpId("#EMPID-001");
            employeeNameArrayList.add(employeeName);

        }

        employeeListRecycle.setAdapter(new EmlpoyeeListAdapter(this, employeeNameArrayList, new EmployeeListItemClickListner() {
            @Override
            public void itemClickListner(EmployeeName employeeName) {

            }
        }));
    }
}
