package com.minorproject.krashakmart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyAccountFragment extends Fragment {

    public static final int MANAGE_ADDRESS=1;
    private Button viewAllAddress;

    public MyAccountFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_my_account_fragment,container,false);

        viewAllAddress=view.findViewById(R.id.viewall_addrs_btn);
        viewAllAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myaddressesintent=new Intent(getContext(),MyAddressesActivity.class);
                 myaddressesintent.putExtra("MODE",MANAGE_ADDRESS);
                startActivity(myaddressesintent);
            }
        });

        return view;
    }
}