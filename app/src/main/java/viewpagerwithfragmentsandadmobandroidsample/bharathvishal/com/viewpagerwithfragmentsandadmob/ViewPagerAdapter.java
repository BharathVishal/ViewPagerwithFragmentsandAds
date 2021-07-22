package viewpagerwithfragmentsandadmobandroidsample.bharathvishal.com.viewpagerwithfragmentsandadmob;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

/**
 * Created by bharathvishal on 20/01/18.
 */

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NotNull
    @Override
    public Fragment createFragment(int position) {
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
    public int getItemCount() {
        return Constants.VIEWPAGER_COUNT;
    }
}

