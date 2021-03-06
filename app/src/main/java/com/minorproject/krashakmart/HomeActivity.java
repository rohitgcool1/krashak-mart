package com.minorproject.krashakmart;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.minorproject.krashakmart.ui.home.HomeFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;
    private static final int  ORDER_FRAGMENT =2;
    private static final int WISHLISTsaved_FRAGMENT =3;
    private static final int ACCOUNT_FRAGMENT =4;

     private FrameLayout framelayout;
    private static int currentFragment=-1;
    private ImageView actionbarlogo;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        actionbarlogo = findViewById(R.id.action_bar_logo);
        setSupportActionBar(toolbar);

        FirebaseAuth.getInstance().signOut();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);


        framelayout = findViewById(R.id.content_home);
        setFragment(new HomeFragment(), HOME_FRAGMENT);

    }


  @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout) ;
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
             if (currentFragment==HOME_FRAGMENT) {
                 super.onBackPressed();
             }
             else {
                 actionbarlogo.setVisibility(View.VISIBLE);
                 invalidateOptionsMenu();
                 setFragment(new HomeFragment(),HOME_FRAGMENT);
                 navigationView.getMenu().getItem(0).setChecked(true);
             }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (currentFragment == HOME_FRAGMENT) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getMenuInflater().inflate(R.menu.home, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.main_search_icon) {
            //todo:search
            return true;
        } else if (id == R.id.main_notification_icon) {
            //todo : notifictn
            return true;
        } else if (id == R.id.main_cart_icon) {
           gotoFragment("My Cart",new CartFragment(),CART_FRAGMENT);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void gotoFragment(String title, Fragment fragment,int fragmentNo) {
           invalidateOptionsMenu();
         actionbarlogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
         getSupportActionBar().setTitle(title);
          setFragment(fragment,fragmentNo);
        if(fragmentNo == CART_FRAGMENT) {
            navigationView.getMenu().getItem(3).setChecked(true);
        }

    }

    @SuppressWarnings("Statement with empty body")


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();
        if(id==R.id.nav_my_home){
            actionbarlogo.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
            setFragment(new HomeFragment(),HOME_FRAGMENT);
        }
        else if(id==R.id.nav_my_account){
            gotoFragment("My Account",new MyAccountFragment(),ACCOUNT_FRAGMENT);
        }
        else if(id==R.id.nav_my_history){
            gotoFragment("My History",new MyOrderFragment(),ORDER_FRAGMENT);
        }
        else if(id==R.id.nav_my_cart){
            gotoFragment("My Cart",new CartFragment(),CART_FRAGMENT);
        }
        else if(id==R.id.nav_my_wishlist){
            gotoFragment("Saved Items",new WishlistFragment(),WISHLISTsaved_FRAGMENT);
        }
        else if(id==R.id.nav_sign_out){

        }
           DrawerLayout drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
           drawer.closeDrawer(GravityCompat.START);
        return true;
    }

   private void setFragment(Fragment fragment,int fragmentNo){

        if (fragmentNo != currentFragment) {
            currentFragment=fragmentNo;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(framelayout.getId(), fragment);
            fragmentTransaction.commit();
        }
       }


}
