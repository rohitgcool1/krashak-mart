package com.minorproject.krashakmart;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.minorproject.krashakmart.ui.home.HomeFragment;

import static com.minorproject.krashakmart.News_FeedFragment.newInstance;

public class HomePage extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_home);

        BottomNavigationView bottomNavigationView= (BottomNavigationView)findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.home_page:
                        Intent intent1 = new Intent(HomePage.this, HomeFragment.class);
                        startActivity(intent1);
                        break;
                    case R.id.add_product_page:

                        break;
                    case R.id.weather_page:

                        break;
                    case R.id.news_feed_page:
                        Intent intent4= new Intent(HomePage.this,News_FeedFragment.class);
                        startActivity(intent4);
                        break;
                }
                return true;


            }

            //bottom Nav

        });
    }
}
