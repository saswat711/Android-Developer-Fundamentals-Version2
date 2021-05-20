package com.example.navdrawerexperiment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navdrawerexperiment.databinding.ActivityMainBinding;
import com.example.navdrawerexperiment.databinding.FragmentHomeBinding;
import com.example.navdrawerexperiment.ui.home.HomeViewModel;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(view -> Toast.makeText(MainActivity.this, "You selected Message Button Select a Nav Drawer Option", Toast.LENGTH_SHORT).show());
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_send, R.id.nav_share, R.id.nav_tools)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        DrawerLayout drawer = binding.drawerLayout;
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_home:
                // Handle the camera import action (for now display a toast).
                drawer.closeDrawers();
                Toast.makeText(MainActivity.this, "You Selected Home Navigation", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.nav_gallery:
                // Handle the gallery action (for now display a toast).
                drawer.closeDrawers();
                Toast.makeText(MainActivity.this, "You Selected Gallery Navigation", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.nav_slideshow:
                // Handle the slideshow action (for now display a toast).
                drawer.closeDrawers();
                Toast.makeText(MainActivity.this, "You Selected Slide Navigation", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.nav_tools:
                // Handle the tools action (for now display a toast).
                drawer.closeDrawers();
                Toast.makeText(MainActivity.this, "You Selected Tools Navigation", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.nav_share:
                // Handle the share action (for now display a toast).
                drawer.closeDrawers();
                Toast.makeText(MainActivity.this, "You Selected Share Navigation", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.nav_send:
                // Handle the send action (for now display a toast).
                drawer.closeDrawers();
                Toast.makeText(MainActivity.this, "You Selected Send Navigation", Toast.LENGTH_SHORT).show();

                return true;

            default:
                return false;
        }
    }
}