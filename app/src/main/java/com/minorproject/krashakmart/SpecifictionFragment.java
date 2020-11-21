package com.minorproject.krashakmart;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minorproject.krashakmart.adapter.ProductSpecificationAdapter;
import com.minorproject.krashakmart.model.ProductSpecificationModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpecifictionFragment extends Fragment {

    private RecyclerView rcSpecification;
    public SpecifictionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_specifiction, container,false);
        rcSpecification = view.findViewById(R.id.product_specification_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcSpecification.setLayoutManager(layoutManager);

        List<ProductSpecificationModel> productSpecificationModelList = new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel(0,"General"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Company","Mahindra"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Name","Mahindra Arjun Ultra-1"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Model","545 D.I."));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Avg","2 liter/km"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"Engine"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Type","ANE 460"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Stroke meter","59/110"));



        ProductSpecificationAdapter productSpecificationAdapter=new ProductSpecificationAdapter(productSpecificationModelList);
        rcSpecification.setAdapter(productSpecificationAdapter);
        productSpecificationAdapter.notifyDataSetChanged();

        // Inflate the layout for this fragment
        return view;
    }

}
