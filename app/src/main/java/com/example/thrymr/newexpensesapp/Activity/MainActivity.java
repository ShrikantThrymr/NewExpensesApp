package com.example.thrymr.newexpensesapp.Activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.thrymr.newexpensesapp.Fragments.admin.AdminTripFragment;
import com.example.thrymr.newexpensesapp.Fragments.admin.EmployeeNameFragment;
import com.example.thrymr.newexpensesapp.Fragments.NavDrawerFragment;
import com.example.thrymr.newexpensesapp.R;
import com.example.thrymr.newexpensesapp.Utils.Constants;
import com.example.thrymr.newexpensesapp.Views.CustomFontTextView;

public class MainActivity extends AppCompatActivity implements NavDrawerFragment.NavigationDrawerCallbacks, EmployeeNameFragment.OnFragmentInteractionListener {

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ((CustomFontTextView) toolbar.findViewById(R.id.text_title)).setText(R.string.employee_expenses_list);
        setSupportActionBar(toolbar);

        //set Navigation drawable menu
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavDrawerFragment mNavDrawerFragment = ((NavDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer));
        mNavDrawerFragment.setUp(R.id.container, drawer);


        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        setTabLayout(tabLayout);
        setTabIndicator(0);

        startNewFragment(new AdminTripFragment(), Constants.ADMIN_TRIP_FRAGMENT,false);
    }

    private void setTabLayout(final TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setCustomView(getCustomTabView(Constants.TRIP)).setTag(Constants.TRIP));
        tabLayout.addTab(tabLayout.newTab().setCustomView(getCustomTabView(Constants.INDIVIDUAl)).setTag(Constants.INDIVIDUAl));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabSelectedView(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabUnSelectedView(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tabSelectedView(tab);
            }
        });

    }

    private void setTabIndicator(int postion) {
        if (tabLayout != null) {
            if (tabLayout.getTabAt(postion) != null) {
                tabLayout.getTabAt(postion).select();
            }
        }
    }

    private LinearLayout getCustomTabView(String text) {
        LinearLayout tabIconLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_tab_icon, null);
        TextView tabIconText = (TextView) tabIconLayout.findViewById(R.id.tab_text);
        tabIconText.setText(text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // tabIconImage.setImageDrawable(getResources().getDrawable(drawableId, null));
        } else {
            //tabIconImage.setImageDrawable(getResources().getDrawable(drawableId));
        }
        return tabIconLayout;
    }

    private void tabSelectedView(TabLayout.Tab tab) {
        Object tag = tab.getTag();
        if (tag != null) {
            String tagStr = tag.toString();
            switch (tagStr) {
                case Constants.TRIP:
                    if (!(getSupportFragmentManager().findFragmentById(R.id.container) instanceof AdminTripFragment)) {
                        clearPopUpBackStack();
                        startNewFragment(new AdminTripFragment(), Constants.ADMIN_TRIP_FRAGMENT,false);
                    }
                    break;
            }
        }
    }

    void clearPopUpBackStack() {
        if (getSupportFragmentManager() != null) {
            for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); ++i) {
                getSupportFragmentManager().popBackStack();
            }
        }
    }


    private void tabUnSelectedView(TabLayout.Tab tab) {
        Object tag = tab.getTag();
        if (tag != null) {
            String tagStr = tag.toString();
            // Log.d("Tap String", tagStr);
            switch (tagStr) {
                case Constants.TRIP:
                 //   reuseCustomTabView((LinearLayout) tab.getCustomView());
                    break;
                case Constants.INDIVIDUAl:
                   // reuseCustomTabView((LinearLayout) tab.getCustomView());
                    break;

            }
        }
    }

  /*  private void reuseCustomTabView(LinearLayout tabLayout) {
        ImageView tabIconImage = (ImageView) tabLayout.findViewById(R.id.tab_icon);
        tabIconImage.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_ATOP);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tabIconImage.setImageDrawable(getResources().getDrawable(drawableId, null));
        } else {
            tabIconImage.setImageDrawable(getResources().getDrawable(drawableId));

        }
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

  /*  //TODO: set start new fragment
    void startNewFragment(final Fragment frag, final String tag) {
        final FragmentTransaction ftr = this.getSupportFragmentManager().beginTransaction();
        if (this.getSupportFragmentManager().findFragmentById(R.id.container) != null) {
            ftr.replace(R.id.container, frag, tag);
        } else
            ftr.add(R.id.container, frag, tag);
        //ftr.commit();

        ftr.commitAllowingStateLoss();

    }*/


    void startNewFragment(final Fragment frag, final String tag, boolean backstack) {
        final FragmentTransaction ftr = this.getSupportFragmentManager()
                .beginTransaction();
        if (this.getSupportFragmentManager().findFragmentById(R.id.container) != null) {
            ftr.replace(R.id.container, frag, tag);
            if (backstack) {
                ftr.addToBackStack(null);
            }
        } else {
            ftr.add(R.id.container, frag, tag);
        }

        ftr.commitAllowingStateLoss();
    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch (position) {
            case 0:
                startNewFragment(new AdminTripFragment(), Constants.employee_name_fragment,false);
                break;

        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
