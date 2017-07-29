package com.example.thrymr.newexpensesapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;


import com.example.thrymr.newexpensesapp.Activity.MainActivity;
import com.example.thrymr.newexpensesapp.Adapter.NavigationAdapter;
import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Views.CircularImageView;
import com.example.thrymr.newexpensesapp.Views.CustomFontTextView;
import com.example.thrymr.newexpensesapp.listners.DrawerItemClickListner;
import com.example.thrymr.newexpensesapp.models.NavDrawerItem;

import java.util.ArrayList;

public class NavDrawerFragment extends Fragment implements View.OnClickListener {
    private NavigationDrawerCallbacks mCallbacks;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private View mFragmentContainerView;

    private RecyclerView rcv_nav;

    private String[] navMenuTitles;


    public ArrayList<NavDrawerItem> titleMenu;

    private Context context;


    private CustomFontTextView tv_emp_name;
    private CustomFontTextView tv_emp_id;
    private CircularImageView imv_upload_photo;
    //private NavigationDrawerCallbacks mCallbacks;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Indicate that this fragment would like to influence the set of actions in the action bar.
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        rcv_nav = (RecyclerView) v.findViewById(R.id.rcv_nav);
        tv_emp_name = (CustomFontTextView) v.findViewById(R.id.tv_emp_name);
        tv_emp_id = (CustomFontTextView) v.findViewById(R.id.tv_emp_id);
        imv_upload_photo = (CircularImageView) v.findViewById(R.id.emp_photo);
        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        loadMenu();

    }

    private void loadMenu() { // load slide menu items
        navMenuTitles = getActivity().getResources().getStringArray(R.array.nav_drawer_items);
        setParentGroups();
        rcv_nav.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rcv_nav.setAdapter(new NavigationAdapter(getActivity(), titleMenu, new DrawerItemClickListner() {
            @Override
            public void itemClickListner(int position) {
                mCallbacks.onNavigationDrawerItemSelected(position);
                mDrawerLayout.closeDrawers();

            }
        }));


        // LISTENERS FOR CHILD AND PARENT SELECTION ON CLICK


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    public void setUp(int paramInt, DrawerLayout paramDrawerLayout
    ) {
        this.mFragmentContainerView = getActivity().findViewById(paramInt);
        this.mDrawerLayout = paramDrawerLayout;
        // enabling action bar app icon and behaving it as toggle button

        ActionBar localActionBar = this.getActionBar();
        localActionBar.setDisplayHomeAsUpEnabled(true);
        localActionBar.setHomeButtonEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout,
                // nav menu toggle icon
                R.string.app_name, // nav drawer open - description for
                // accessibility
                R.string.app_name // nav drawer close - description for
                // accessibility
        ) {
            @Override
            public void onDrawerClosed(View view) {
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                //HIding Soft keyboard When Clicked on Navigation Drawer ....EMp 32
                InputMethodManager inputManager = (InputMethodManager) drawerView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                IBinder binder = drawerView.getWindowToken();
                inputManager.hideSoftInputFromWindow(binder, InputMethodManager.HIDE_NOT_ALWAYS);
                getActivity().invalidateOptionsMenu();
            }
        };

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);

    }

    private ActionBar getActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    private void setParentGroups() {
        //  icons = new ArrayList<Integer>();
        // addIcons();

        // ADDING TITLE VIEWS
        titleMenu = new ArrayList<NavDrawerItem>();
        Log.d("yyyyyyyyyy", "------" + titleMenu);
        for (int i = 0; i < navMenuTitles.length; i++) {

            titleMenu.add(new NavDrawerItem(navMenuTitles[i]));
        }
        Log.d("ccccccccccccccccccccc", "------" + titleMenu);
    }

   /* private void addIcons() {
        icons.add(R.drawable.attandance);
        icons.add(R.drawable.chat);

        icons.add(R.drawable.proj_tasks);

        icons.add(R.drawable.changepassword);

        icons.add(R.drawable.logout);

    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.emp_photo:
                break;

        }
    }


    public interface NavigationDrawerCallbacks {
        /**
         * Called when an item in the navigation drawer is selected.
         */
        void onNavigationDrawerItemSelected(int position);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        try {
            this.mCallbacks = (NavigationDrawerCallbacks) context;
        } catch (final ClassCastException e) {
            throw new ClassCastException(
                    "Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }


}
