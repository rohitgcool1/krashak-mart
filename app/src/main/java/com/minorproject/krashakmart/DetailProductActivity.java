package com.minorproject.krashakmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.minorproject.krashakmart.adapter.ProductDetailAdapter;
import com.minorproject.krashakmart.adapter.ProductimageAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetailProductActivity extends AppCompatActivity {

    private ViewPager productimageviewpager;
    private FloatingActionButton addToWishlist;
    private TabLayout viewpagerIndicator;
    private static boolean alreadyAdded_ToWISHLIST=false;

    private ViewPager productDetailViewpager;
    private TabLayout productDetailTablayout;

    //rating layout
    private LinearLayout rateNowContainer;
    //rating layout

    private Button Book_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        Toolbar toolbar = this.findViewById(R.id.toolbar_detail_product);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        productimageviewpager= this.findViewById(R.id.product_images_viewpager);
        viewpagerIndicator= this.findViewById(R.id.viewpager_indicator);
        addToWishlist = this.findViewById(R.id.add_to_whishlist_btn);
        productDetailViewpager = this.findViewById(R.id.product_detail_viewpager);
       productDetailTablayout = this.findViewById(R.id.product_details_tablayout);
       Book_btn= findViewById(R.id.buy_booknow_btn);

      /*  String[] listCategoryName = getResources().getStringArray(R.array.list_name_icon_category);
        String[] listCategoryLink = getResources().getStringArray(R.array.list_link_icon_category);
        String[] listColorBannerSlide = getResources().getStringArray(R.array.list_color_banner_slide);
        String[] listImgProduct = getResources().getStringArray(R.array.list_img_product);

       */

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.tractor1);
        productImages.add(R.drawable.tractor1);
        productImages.add(R.drawable.tractor1);
        productImages.add(R.drawable.tractor1);


        productimageviewpager.setAdapter(new ProductimageAdapter(productImages));
        viewpagerIndicator.setupWithViewPager(productimageviewpager,true);

        addToWishlist.setOnClickListener(view -> {
            if(alreadyAdded_ToWISHLIST) {
                alreadyAdded_ToWISHLIST=false;
               addToWishlist.setSupportBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
            } else {
                alreadyAdded_ToWISHLIST=true;
               addToWishlist.setSupportBackgroundTintList(getResources().getColorStateList(R.color.Red));
            }
        });

        ProductDetailAdapter adapter = new ProductDetailAdapter(getSupportFragmentManager(),0,productDetailTablayout.getTabCount());
        productDetailViewpager.setAdapter(adapter);
        productDetailViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailTablayout));
        productDetailTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        //rating layout

        rateNowContainer=findViewById(R.id.rate_now_container);

       for (int x=0;x <rateNowContainer.getChildCount();x++){
           final int starposition=x;
           rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   setRating(starposition);
               }
           });
       }
        //rating layout
        Book_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deli_ConfIntent=new Intent(DetailProductActivity.this,DeliveryActivity.class);
                startActivity(deli_ConfIntent);
            }
        });
    }

    private void setRating(int starposition) {
        for (int x=0;x <rateNowContainer.getChildCount();x++)
        {
            ImageView starbtn=(ImageView)rateNowContainer.getChildAt(x);
            starbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#969696")));
            if (x <=starposition){
                starbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFC73B")));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_and_cart_icon,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            finish();
            return true;
        }
        else if(id == R.id.main_search_icon)
        {
            //todo:seacrh
            return true;
        }
        else if(id == R.id.main_cart_icon)
        {
            //todo:cart
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
