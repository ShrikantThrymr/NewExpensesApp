package com.example.thrymr.newexpensesapp.Fragments.employee;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thrymr.newexpensesapp.Activity.employee.AddIndividualExpensesActivity;
import com.example.thrymr.newexpensesapp.Adapter.employee.IndividualExpensesAdapter;
import com.example.thrymr.newexpensesapp.Adapter.employee.TripExpensesAdapter;
import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.listners.admin.IndividualExpensesItemClickListner;
import com.example.thrymr.newexpensesapp.listners.employee.TripExpensesItemClickListner;
import com.example.thrymr.newexpensesapp.models.AdminTrip;
import com.example.thrymr.newexpensesapp.models.IndividualExpenses;
import com.example.thrymr.newexpensesapp.models.TripExpenses;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IndividualExpensesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IndividualExpensesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndividualExpensesFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView individualRecycle;
    private FloatingActionButton floatingActionButton;

    public IndividualExpensesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IndividualExpensesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IndividualExpensesFragment newInstance(String param1, String param2) {
        IndividualExpensesFragment fragment = new IndividualExpensesFragment();
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
        return inflater.inflate(R.layout.fragment_individual_expenses, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        individualRecycle = (RecyclerView) view.findViewById(R.id.individual_trip_recycleview);

        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.individual_fab);
        floatingActionButton.setOnClickListener(this);
        setValues();
    }

    private void setValues() {
        individualRecycle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        List<IndividualExpenses> individualExpensesArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            IndividualExpenses individualExpenses = new IndividualExpenses();
            individualExpenses.setExpensesName("Cab");
            individualExpenses.setExpensesDate("12-07-2017");
            individualExpenses.setTotalAmount("$500");
            individualExpenses.setExpensesStatus("Accept");
            individualExpensesArrayList.add(individualExpenses);

        }
        individualRecycle.setAdapter(new IndividualExpensesAdapter(getActivity(), individualExpensesArrayList, new IndividualExpensesItemClickListner() {
            @Override
            public void itemOnClickListner(IndividualExpenses individualExpenses) {

            }
        }));


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String shri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(shri);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.individual_fab:
                Intent intent = new Intent(getActivity(), AddIndividualExpensesActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String shri);
    }
}
