package com.minorproject.krashakmart;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minorproject.krashakmart.adapter.MyOrderAdapter;
import com.minorproject.krashakmart.model.MyOrderitemModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrderFragment extends Fragment {

    private RecyclerView MyOrderRv;
    public MyOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_order, container, false);
         MyOrderRv = view.findViewById(R.id.my_orders_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        MyOrderRv.setLayoutManager(linearLayoutManager);

        List<MyOrderitemModel>myOrderitemModelList=new ArrayList<>();
        myOrderitemModelList.add(new MyOrderitemModel(R.drawable.tractor1,"Mahindra Arjun","Booked on Mon, 2nd Dec 2020",2));
        myOrderitemModelList.add(new MyOrderitemModel(R.drawable.harvester1,"Escort Hravester","Booked on Sun, 19 Nov 2020",4));
        myOrderitemModelList.add(new MyOrderitemModel(R.drawable.tractor1,"Mahindra Arjun","Cancelled",3));

        MyOrderAdapter myOrderAdapter=new MyOrderAdapter(myOrderitemModelList);
        MyOrderRv.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();
        return view;
    }

}
