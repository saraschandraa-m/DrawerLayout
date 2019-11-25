package com.appstone.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private TextView username;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        LinearLayout mainLayout = findViewById(R.id.main_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        View HeaderlayoutView = navigationView.getHeaderView(0);
        username = HeaderlayoutView.findViewById(R.id.tv_username);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Navigation View");

        ActionBarDrawerToggle toggleDrawer = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggleDrawer.syncState();

        username.setText("Saraschandraa");


        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_home:
                drawerLayout.closeDrawer(Gravity.START);

                Bundle arguments = new Bundle();
                arguments.putString("Username", "Appstone");
                arguments.putString("Password", "Appstone428");

                Fragment homeFragment = new HomeFragment();
                homeFragment.setArguments(arguments);

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
                break;

            case R.id.action_logout:
                break;

            case R.id.action_settings:
                break;
        }
        return false;
    }
}
