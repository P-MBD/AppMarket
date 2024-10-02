package com.example.appmarket;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.appmarket.fragemt.HomeFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_view = findViewById(R.id.bottom_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        bottom_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    int itemId = item.getItemId();

                    if (itemId == R.id.item_home) {
                        fragment = new HomeFragment();
                    } else if (itemId == R.id.item_updated) {
                        fragment = new HomeFragment(); // یا Fragment دیگر
                    } else if (itemId == R.id.favorite) {
                        fragment = new HomeFragment(); // یا Fragment دیگر
                    }

                    if (fragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                        return true; // برگرداندن true برای نشان دادن اینکه آیتم انتخاب شده است
                    }

                    return false;
                }

        });
    }
}
