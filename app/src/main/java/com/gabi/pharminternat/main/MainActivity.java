package com.gabi.pharminternat.main;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gabi.main.R;
import com.gabi.pharminternat.dao.DAO;
import com.gabi.pharminternat.model.PharmaFile;
import com.gabi.pharminternat.model.PharmaSection;
import com.gabi.pharminternat.utils.Constant;
import com.gabi.pharminternat.utils.PharmaFileAdapter;
import com.gabi.pharminternat.utils.Utils;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the com.gabi.pharaminternat.com.gabi.pharmaInternat.com.gabi.pharmInternat.com.com.gabi.pharaminternat.main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }


    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private View rootView;
        private ListView pharmaFileListView;
        private TextView sectionTitle;
        private ArrayList<PharmaFile> pharmaFiles;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            this.rootView = inflater.inflate(R.layout.fragment_main, container, false);
            this.sectionTitle = (TextView) this.rootView.findViewById(R.id.sectionTitle);
            this.pharmaFileListView = (ListView) this.rootView.findViewById(R.id.pharmaFile_listView);
            DAO dao = DAO.getInstance(this.getActivity());
            int section = getArguments().getInt(ARG_SECTION_NUMBER);
            PharmaSection pharmaSection;

            if(section == Constant.TODOSECTION){
                pharmaSection = new PharmaSection(Constant.TODOSECTION, Constant.TODOSECTIONTITLE);
                this.pharmaFiles = dao.getTodoPharamaFiles();
            }else if(section == Constant.LATESECTION){
                pharmaSection = new PharmaSection(Constant.LATESECTION, Constant.LATESECTIONTITLE);
                this.pharmaFiles = dao.getLatePharamaFiles();
            }else {
                pharmaSection = dao.getPharamaSection(section);
                this.pharmaFiles = dao.getSectionPharamaFiles(section);
            }

            PharmaFileAdapter adapter = new PharmaFileAdapter(this.rootView.getContext(), this.pharmaFiles);
            if (pharmaSection != null) {
                this.sectionTitle.setText(pharmaSection.getSection() + ". " + pharmaSection.getSectionTitle());
            }

            this.pharmaFileListView.setAdapter(adapter);
            this.pharmaFileListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    PharmaFile pharmaFile = pharmaFiles.get(position);
                    DAO dao = DAO.getInstance(view.getContext());
                    TextView lastReview = (TextView) view.findViewById(R.id.last_review);
                    TextView reviewCounter = (TextView) view.findViewById(R.id.review_counter);
                    Date currDate = new Date();
                    pharmaFile.setLastReview(currDate);
                    pharmaFile.incrementReviewCounter();
                    reviewCounter.setText(pharmaFile.getReviewCounter() + "");
                    lastReview.setText(Utils.getDateTime());

                    if (pharmaFile.getTodoDate() != null &&
                            pharmaFile.getTodoDate().after(Utils.currentWeek()) &&
                            (pharmaFile.getTodoDate().before(Utils.nextWeek()) ||
                                    pharmaFile.getTodoDate().equals(Utils.nextWeek())) &&
                            currDate.before(pharmaFile.getTodoDate()) &&
                            currDate.after(Utils.currentWeek())) {
                        pharmaFileListView.getAdapter().getView(position, view, parent);
                    }

                    dao.incrementReviewCounter(pharmaFile.getId());
                    dao.setReviewDate(pharmaFile.getId());


                }
            });
            return this.rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);

        }
    }

}
