package com.minorproject.krashakmart;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minorproject.krashakmart.adapter.ProductWishlistAdapter;
import com.minorproject.krashakmart.model.WishlistModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WishlistFragment extends Fragment {

    private RecyclerView rcProductWishlist;
    public WishlistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);
        rcProductWishlist = view.findViewById(R.id.my_wishlist_rc);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcProductWishlist.setLayoutManager(linearLayoutManager);

        List<WishlistModel>wishlistModelList=new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.img_phone_2,"Spray Pump","3",45,"300","Avaliable"));
        wishlistModelList.add(new WishlistModel(R.drawable.harvester1,"Escort Harvester","5",69,"1200","Avaliable"));
        wishlistModelList.add(new WishlistModel(R.drawable.img_phone_4,"Driller","2",25,"450","Not Avaliable"));
        wishlistModelList.add(new WishlistModel(R.drawable.tractor1,"Mahindra Arjun","5",110,"600","Avaliable"));

        ProductWishlistAdapter wishlistAdapter=new ProductWishlistAdapter(wishlistModelList);
        rcProductWishlist.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();
        return view;
    }

}
