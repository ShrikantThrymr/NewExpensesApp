package com.example.thrymr.newexpensesapp.Fragments.admin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thrymr.newexpensesapp.Adapter.EmlpoyeeListAdapter;
import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.listners.EmployeeListItemClickListner;
import com.example.thrymr.newexpensesapp.models.EmployeeName;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EmployeeNameFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EmployeeNameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeNameFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView employeeListRecycle;
    private TabLayout tabLayout;

    public EmployeeNameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmployeeNameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmployeeNameFragment newInstance(String param1, String param2) {
        EmployeeNameFragment fragment = new EmployeeNameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_employee_name, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        employeeListRecycle = (RecyclerView) view.findViewById(R.id.employee_list_recycle);

        setvalues();
    }

    private void setvalues() {

        employeeListRecycle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ArrayList<EmployeeName> employeeNameArrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            EmployeeName employeeName = new EmployeeName();
            employeeName.setEmpImage("Shrikant");
            employeeName.setEmpId("#EMPID-001");
            employeeNameArrayList.add(employeeName);

        }

        employeeListRecycle.setAdapter(new EmlpoyeeListAdapter(getActivity(), employeeNameArrayList, new EmployeeListItemClickListner() {
            @Override
            public void itemClickListner(EmployeeName employeeName) {

            }
        }));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
