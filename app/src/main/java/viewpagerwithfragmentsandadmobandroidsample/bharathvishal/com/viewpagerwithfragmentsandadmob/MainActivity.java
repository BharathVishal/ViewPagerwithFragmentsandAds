package viewpagerwithfragmentsandadmobandroidsample.bharathvishal.com.viewpagerwithfragmentsandadmob;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


/**
 * Created by bharathvishal on 20/01/18.
 */


public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    Context context;
    private ViewPager2 viewPager;
    private final String[] pageTitle = {"Fragment 1", "Fragment 2", "Fragment 3", "Fragment 4", "Fragment 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        MobileAds.initialize(context, initializationStatus -> {
        });
        RelativeLayout adContainerView = findViewById(R.id.bottomRelativeLayout);
        mAdView = new AdView(this);

        //Test Ad id, replace with your own ad id later
        mAdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        adContainerView.addView(mAdView);
        loadAdaptiveBanner();

        viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);


        //setting Tab layout (number of Tabs = number of ViewPager pages)
        //tabLayout = findViewById(R.id.tab_layout);
        //setting Tab layout(number of Tabs = number of ViewPager pages)
        for (int i = 0; i < Constants.VIEWPAGER_COUNT; i++)
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));

        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //set viewpager adapter
        try {
            ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),getLifecycle());
            viewPager.setAdapter(pagerAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager,
                    new TabLayoutMediator.TabConfigurationStrategy() {
                        @Override
                        public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                            try {
                                tab.setText(pageTitle[position]);

                                switch (tab.getPosition()) {
                                    case 0:
                                        viewPager.setBackgroundColor(ContextCompat.getColor(context, R.color.Fragment1));
                                        break;
                                    case 1:
                                        viewPager.setBackgroundColor(ContextCompat.getColor(context, R.color.Fragment2));
                                        break;
                                    case 2:
                                        viewPager.setBackgroundColor(ContextCompat.getColor(context, R.color.Fragment3));
                                        break;
                                    case 3:
                                        viewPager.setBackgroundColor(ContextCompat.getColor(context, R.color.Fragment4));
                                        break;
                                    case 4:
                                        viewPager.setBackgroundColor(ContextCompat.getColor(context, R.color.Fragment5));
                                        break;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
            tabLayoutMediator.attach();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void loadAdaptiveBanner() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        AdSize adSize = getAdSize();
        mAdView.setAdSize(adSize);
        mAdView.loadAd(adRequest);
    }


    private AdSize getAdSize() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;
        int adWidth = (int) (widthPixels / density);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }


}
