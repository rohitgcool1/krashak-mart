package com.minorproject.krashakmart.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.minorproject.krashakmart.Agri_Machine;
import com.minorproject.krashakmart.R;
import com.minorproject.krashakmart.adapter.GridProductLayoutAdapter;
import com.minorproject.krashakmart.adapter.HorizotalProductAdapter;
import com.minorproject.krashakmart.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private TextView horilayouttitle ;
    private Button viewall;
    private RecyclerView horizontalRv;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        /// Horizontal Product layout
         horilayouttitle=view.findViewById(R.id.horizontal_scroll_layout_title);
         viewall=view.findViewById(R.id.horizontal_scroll_view_all_btn);
         horizontalRv=view.findViewById(R.id.horizontal_scroll_layout_recyclerview);

         List<ProductModel> productModels=new ArrayList<>();
         productModels.add(new ProductModel(R.drawable.harvester1,"Swaraj Harvester","8100 Combine 105hp",5000));
        productModels.add(new ProductModel(R.drawable.tractor1,"Mahindra","Arjun 500D",800));


         HorizotalProductAdapter horizotalProductAdapter=new HorizotalProductAdapter(productModels);
        LinearLayoutManager linearlayoutManager=new LinearLayoutManager(getContext());
        linearlayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRv.setLayoutManager(linearlayoutManager);

        horizontalRv.setAdapter(horizotalProductAdapter);
        horizotalProductAdapter.notifyDataSetChanged();

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AgriMachine_intent= new Intent(getContext(), Agri_Machine.class);
                startActivity(AgriMachine_intent);
            }
        });

        /// Horizontal Product layout


        ///grid product layout

        TextView gridlayoutTitle=view.findViewById(R.id.horizontal_scroll_layout_title);
        Button gridlayoutViewAllButton=view.findViewById(R.id.grid_product_button_viewall);

        GridView gridView=view.findViewById(R.id.gridProductLayout_gridview);
        gridView.setAdapter(new GridProductLayoutAdapter(productModels));

       ///grid product layout

        return view;
    }



}