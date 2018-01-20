package viewpagerwithfragmentsandadmobandroidsample.bharathvishal.com.viewpagerwithfragmentsandadmob;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdView;


/**
 * Created by bharathvishal on 20/01/18.
 */


public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    private ViewPager viewPager;
    private DrawerLayout drawer;

    Integer[] colors = {Color.WHITE, Color.YELLOW, Color.BLUE, Color.GREEN, Color.GRAY};


    private String[] pageTitle = {"Fragment 1", "Fragment 2", "Fragment 3", "Fragment 4", "Fragment 5"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);


        //setting Tab layout (number of Tabs = number of ViewPager pages)
        //tabLayout = findViewById(R.id.tab_layout);
        for (int i = 0; i < Constants.VIEWPAGER_COUNT; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
        }

        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        //set viewpager adapter
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);


        //change Tab selection when ViewPager is swiped
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                //For handling fragment background color change when tab is scrolled
                switch (tab.getPosition()) {
                    case 0:
                        viewPager.setBackgroundColor(colors[0]);
                        break;
                    case 1:
                        viewPager.setBackgroundColor(colors[1]);
                        break;
                    case 2:
                        viewPager.setBackgroundColor(colors[2]);
                        break;
                    case 3:
                        viewPager.setBackgroundColor(colors[3]);
                        break;
                    case 4:
                        viewPager.setBackgroundColor(colors[4]);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
