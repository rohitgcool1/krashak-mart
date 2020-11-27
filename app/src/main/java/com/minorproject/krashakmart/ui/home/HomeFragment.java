package com.minorproject.krashakmart.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.minorproject.krashakmart.AddCategoryActivity;
import com.minorproject.krashakmart.Agri_Equipment;
import com.minorproject.krashakmart.Agri_Machine;
import com.minorproject.krashakmart.News_FeedFragment;
import com.minorproject.krashakmart.R;
import com.minorproject.krashakmart.ViewAll_AgriMachinesActivity;
import com.minorproject.krashakmart.ViewAll_EquipmentActivity;
import com.minorproject.krashakmart.WeatherFragment;
import com.minorproject.krashakmart.adapter.GridProductLayoutAdapter;
import com.minorproject.krashakmart.adapter.HorizotalProductAdapter;
import com.minorproject.krashakmart.model.ProductModel;
import com.minorproject.krashakmart.model.Products_forAddProduct;
import com.minorproject.krashakmart.viewholder.ProductViewHolder;
import com.squareup.picasso.Picasso;

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
                Intent AgriMachine_intent= new Intent(getContext(), ViewAll_AgriMachinesActivity.class);
                startActivity(AgriMachine_intent);
            }
        });


        /// Horizontal Product layout



        ///grid product layout

        TextView gridlayoutTitle=view.findViewById(R.id.horizontal_scroll_layout_title);
        Button gridlayoutViewAllButton=view.findViewById(R.id.grid_product_button_viewall);

        GridView gridView=view.findViewById(R.id.gridProductLayout_gridview);
        gridView.setAdapter(new GridProductLayoutAdapter(productModels));

        gridlayoutViewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AgriEquipment_Intent= new Intent(getContext(), ViewAll_EquipmentActivity.class);
                startActivity(AgriEquipment_Intent);
            }
        });

       ///grid product layout



       ImageView addProductImage =(ImageView) view.findViewById(R.id.addpage);
        addProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(getContext(), AddCategoryActivity.class);
                getContext().startActivity(intent2);
            }
        });


        ImageView weatherImage =(ImageView) view.findViewById(R.id.weatherpage);
        weatherImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3= new Intent(getContext(), WeatherFragment.class);
                getContext().startActivity(intent3);
            }
        });

        ImageView newsfeedImage =(ImageView)view.findViewById(R.id.newfeedpage);
        newsfeedImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4= new Intent(getContext(), News_FeedFragment.class);
                getContext().startActivity(intent4);
            }
        });



        return view;
    }



}