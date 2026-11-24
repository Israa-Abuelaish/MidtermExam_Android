
package com.example.midtermexam_israa_abuelaish;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.midtermexam_israa_abuelaish.TabFragment;

public class ViewPager extends FragmentStateAdapter {

    // Constructor
    public ViewPager(
            @NonNull FragmentActivity activity) {

        super(activity);
    }

    // Create Fragment based on position
    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return TabFragment.newInstance(position);
    }

    // Return number of tabs
    @Override
    public int getItemCount() {

        return 3;
    }
}
