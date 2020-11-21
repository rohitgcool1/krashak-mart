package com.minorproject.krashakmart;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.minorproject.krashakmart.adapter.CartAdapter;
import com.minorproject.krashakmart.model.CartItemModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    private RecyclerView cartItemrc;
    private Button Continuebtn;
    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        cartItemrc = view.findViewById(R.id.cart_items_recyclerview);
        Continuebtn=view.findViewById(R.id.cart_continue_btn);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
         cartItemrc.setLayoutManager(linearLayoutManager);

        List<CartItemModel> cartItemModelList=new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.tractor1,"Mahindra Arjun","Rs.1000/-"));
        cartItemModelList.add(new CartItemModel(0,R.drawable.harvester1,"Escort Harvester","Rs.3000/-"));
        cartItemModelList.add(new CartItemModel(0,R.drawable.tractor1,"Mahindra Arjun","Rs.1200/-"));
        cartItemModelList.add(new CartItemModel(1,"Rs.1000/-","Rs.1000/-"));

        CartAdapter cartAdapter=new CartAdapter(cartItemModelList);
        cartItemrc.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        Continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deli_ConfIntent=new Intent(getContext(),AddAddressActivity.class);
                getContext().startActivity(deli_ConfIntent);

            }
        });

        return view;
    }

}
