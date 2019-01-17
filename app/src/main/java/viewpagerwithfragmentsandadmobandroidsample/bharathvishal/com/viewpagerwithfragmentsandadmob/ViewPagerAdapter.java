package viewpagerwithfragmentsandadmobandroidsample.bharathvishal.com.viewpagerwithfragmentsandadmob;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created by bharathvishal on 20/01/18.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override

    public Fragment getItem(int position) {
        if (position == 0) {
            return new Fragment1();
        } else if (position == 1) {
            return new Fragment2();
        } else if (position == 2) {
            return new Fragment3();
        } else if (position == 3) {
            return new Fragment4();
        } else
            return new Fragment5();
    }


    @Override
    public int getCount() {
        return Constants.VIEWPAGER_COUNT;
    }
}

