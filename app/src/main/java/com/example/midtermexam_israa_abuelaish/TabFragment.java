
package com.example.midtermexam_israa_abuelaish;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TabFragment extends Fragment {

    // Create a new Fragment
    public static TabFragment newInstance(int position) {

        TabFragment fragment = new TabFragment();

        Bundle bundle = new Bundle();

        bundle.putInt("position", position);

        fragment.setArguments(bundle);

        return fragment;
    }

    // Create Fragment View
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_tab,
                container,
                false
        );
    }

    // Display Fragment Content
    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        TextView tvContent =
                view.findViewById(R.id.tvTabContent);

        int position = 0;

        Bundle args = getArguments();

        if (args != null) {
            position = args.getInt("position", 0);
        }

        String[] tabNames =
                getResources().getStringArray(R.array.tab_names);

        tvContent.setText(tabNames[position]);
    }
}
