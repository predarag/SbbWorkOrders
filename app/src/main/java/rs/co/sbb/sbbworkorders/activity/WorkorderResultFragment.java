package rs.co.sbb.sbbworkorders.activity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rs.co.sbb.sbbworkorders.R;
import rs.co.sbb.sbbworkorders.entity.response.Etizlaz;

public class WorkorderResultFragment extends Fragment {

    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;
    private List<Etizlaz> etizlazList;


    public WorkorderResultFragment(){};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
          Bundle savedInstanceState) {


        etizlazList = (List<Etizlaz>) getArguments().getSerializable("etList");



        for(Etizlaz o : etizlazList)
            Log.i("IZLAZ: ",o.getAKCIJASKOPIS());

          View workorderView = inflater.inflate(R.layout.activity_workorder_result, container, false);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager(), etizlazList);

        mViewPager = (ViewPager) workorderView.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        return workorderView;


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getActivity().getMenuInflater().inflate(R.menu.menu_workorder_result, menu);
        return true;
    }



    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "etObject";

        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(Etizlaz etizlaz) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putSerializable(ARG_SECTION_NUMBER, (Serializable) etizlaz);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_workorder_result, container, false);


            Etizlaz etizlaz = (Etizlaz)getArguments().getSerializable(ARG_SECTION_NUMBER);

            TextView textViewTel1 = (TextView) rootView.findViewById(R.id.tel1);
            textViewTel1.setText( etizlaz.getTEL1());

            TextView textViewChouseNum2 = (TextView) rootView.findViewById(R.id.cHouseNum2);
            textViewChouseNum2.setText( etizlaz.getCHOUSENUM2());

            TextView textViewChouseNum1 = (TextView) rootView.findViewById(R.id.cHouseNum1);
            textViewChouseNum1.setText( etizlaz.getCHOUSENUM1());

            TextView textViewRoomNo = (TextView) rootView.findViewById(R.id.cRoomNumber);
            textViewRoomNo.setText( etizlaz.getCROOMNUMBER());

            return rootView;
        }
    }



    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private @Nullable List<Etizlaz> etizlazLis;

        public SectionsPagerAdapter(FragmentManager fm,List<Etizlaz>etizlazLis) {
            super(fm);
            this.etizlazLis = etizlazLis;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(etizlazLis.get(position));
        }

        @Override
        public int getCount() {

            return etizlazLis.size();
        }

       @Override
       public CharSequence getPageTitle(int position) {

            return etizlazLis.get(position).getSERVICE();
       }


    }
}
