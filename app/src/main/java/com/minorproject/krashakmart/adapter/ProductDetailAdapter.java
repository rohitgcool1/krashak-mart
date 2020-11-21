package com.minorproject.krashakmart.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.minorproject.krashakmart.OwnerDetailFragment;
import com.minorproject.krashakmart.SpecifictionFragment;

public class ProductDetailAdapter extends FragmentPagerAdapter {

    private int totaltabs;


    public ProductDetailAdapter(@NonNull FragmentManager fm, int behavior, int totaltabs) {
        super(fm, behavior);
        this.totaltabs=totaltabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:{
                OwnerDetailFragment ownerDetailFragment= new OwnerDetailFragment();
                return ownerDetailFragment;
            }
            case 1:{
                SpecifictionFragment specifictionFragment = new SpecifictionFragment();
                return specifictionFragment;
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totaltabs;
    }
}
