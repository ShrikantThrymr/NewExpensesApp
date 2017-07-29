package com.example.thrymr.newexpensesapp.Fragments.employee;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thrymr.newexpensesapp.Activity.employee.AddTripNameAcitvity;
import com.example.thrymr.newexpensesapp.Activity.employee.TripNameExpensesActivity;
import com.example.thrymr.newexpensesapp.Adapter.employee.TripExpensesAdapter;
import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.listners.employee.TripExpensesItemClickListner;
import com.example.thrymr.newexpensesapp.models.TripExpenses;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TripExpensesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TripExpensesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TripExpensesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView tripExpensesRecyle;
    private FloatingActionButton floatingActionButton;

    public TripExpensesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TripExpensesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TripExpensesFragment newInstance(String param1, String param2) {
        TripExpensesFragment fragment = new TripExpensesFragment();
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
        return inflater.inflate(R.layout.fragment_trip_expenses, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tripExpensesRecyle=(RecyclerView)view.findViewById(R.id.trip_recycle_view);
        floatingActionButton= (FloatingActionButton) view.findViewById(R.id.fragment_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), AddTripNameAcitvity.class);
                startActivity(intent);
            }
        });
        setValues();
    }

    private void setValues() {
        tripExpensesRecyle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ArrayList<TripExpenses> adminTripArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TripExpenses tripExpenses = new TripExpenses();
            tripExpenses.setTripName("Mumbai");
            tripExpenses.setTripDate("12-07-2017");
            tripExpenses.setTotalAmount("$500");
            tripExpenses.setTripStatus("Accept");
            adminTripArrayList.add(tripExpenses);

        }
        tripExpensesRecyle.setAdapter(new TripExpensesAdapter(getActivity(), adminTripArrayList, new TripExpensesItemClickListner() {
            @Override
            public void itemOnClickListner(TripExpenses tripExpenses) {
                startActivity(new Intent(getActivity(), TripNameExpensesActivity.class));
            }

        }));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentInteraction();
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
        void onFragmentInteraction();
    }
}
