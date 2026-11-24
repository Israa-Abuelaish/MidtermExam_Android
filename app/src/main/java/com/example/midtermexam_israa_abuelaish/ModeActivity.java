
package com.example.midtermexam_israa_abuelaish;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ModeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    private ImageView ivLight;
    private ImageView ivDark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mode);

        // Initialize Views
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        ivLight = findViewById(R.id.ivLight);
        ivDark = findViewById(R.id.ivDark);

// Set initial selected mode
        updateModeIcons();

// Light icon click
        ivLight.setOnClickListener(v -> {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO
            );
        });

// Dark icon click
        ivDark.setOnClickListener(v -> {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES
            );
        });

        //  Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar()
                    .setDisplayHomeAsUpEnabled(true);
        }

        //  Create Adapter
        ViewPager adapter = new ViewPager(this);

        viewPager.setAdapter(adapter);

        //  Connect TabLayout with ViewPager2
        new TabLayoutMediator(
                tabLayout,
                viewPager,
                (tab, position) -> {

                    switch (position) {

                        case 0:
                            tab.setText("First");
                            break;

                        case 1:
                            tab.setText("Second");
                            break;

                        case 2:
                            tab.setText("Third");
                            break;
                    }

                }
        ).attach();



        //  Back Button Logic
        handleBackButton();
    }


    // Handle Back Button
    private void handleBackButton() {

        getOnBackPressedDispatcher().addCallback(
                this,

                new OnBackPressedCallback(true) {

                    @Override
                    public void handleOnBackPressed() {

                        int currentPosition =
                                viewPager.getCurrentItem();

                        if (currentPosition == 0) {

                            // Return to MainActivity
                            finish();

                        } else {

                            // Return to First Tab
                            viewPager.setCurrentItem(0, true);

                        }
                    }
                }
        );
    }
    private void updateModeIcons() {

        int currentMode = AppCompatDelegate.getDefaultNightMode();

        if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {

            // Dark selected
            ivDark.setColorFilter(
                    android.graphics.Color.parseColor("#3F51B5")
            );

            ivLight.setColorFilter(
                    android.graphics.Color.GRAY
            );

        } else {

            // Light selected
            ivLight.setColorFilter(
                    android.graphics.Color.parseColor("#FFB300")
            );

            ivDark.setColorFilter(
                    android.graphics.Color.GRAY
            );
        }
    }
    // Up Navigation
    @Override
    public boolean onSupportNavigateUp() {

        finish();

        return true;
    }
}
