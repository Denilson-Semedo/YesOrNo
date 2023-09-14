package com.example.yesorno;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import java.util.Timer;
import java.util.TimerTask;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Timer timer;
    private BottomNavigationView bottomNavigationView;
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        fragmentContainer = findViewById(R.id.fragment_container);

        // Load the default fragment
        loadFragment(new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.navigation_dashboard:
                        fragment = new DashboardFragment();
                        break;
                    case R.id.navigation_notifications:
                        fragment = new NotificationsFragment();
                        break;
                }

                return loadFragment(fragment);
            }
        });

//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(MainActivity.this, Home.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 2000);

       // BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set a listener to handle item selection
//        //bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.navigation_home:
//                        Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
//                        startActivity(homeIntent);
//                        Toast.makeText(MainActivity.this, "Home - Page 1", Toast.LENGTH_SHORT).show();
//                        return true;
//                    case R.id.navigation_dashboard:
//                        Intent dashboardIntent = new Intent(MainActivity.this, DashboardActivity.class);
//                        startActivity(dashboardIntent);
//                        Toast.makeText(MainActivity.this, "Dashboard - Page 2", Toast.LENGTH_SHORT).show();
//                        return true;
//                    case R.id.navigation_notifications:
//                        Intent notificationsIntent = new Intent(MainActivity.this, NotificationsActivity.class);
//                        startActivity(notificationsIntent);
//                        Toast.makeText(MainActivity.this, "Notifications - Page 3", Toast.LENGTH_SHORT).show();
//                        return true;
//                }
//                return false;
//            }
//        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}