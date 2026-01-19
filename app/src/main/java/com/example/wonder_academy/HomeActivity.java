package com.example.wonder_academy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_navigation);

        // default fragment
        loadFragment(new HomeFragment());

        bottomNav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Fragment fragment = null;

                int id = item.getItemId();

                if (id == R.id.nav_featured) {
                    fragment = new HomeFragment();
                } else if (id == R.id.nav_search) {
                    fragment = new SearchFragment();
                } else if (id == R.id.nav_learning) {
                    fragment = new MyLearningFragment();
                } else if (id == R.id.nav_wishlist) {
                    fragment = new VideoLessonsFragment();
                } else if (id == R.id.nav_account) {
                    fragment = new AccountFragment();
                }

                return loadFragment(fragment);
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment == null) return false;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
        return true;
    }
}
