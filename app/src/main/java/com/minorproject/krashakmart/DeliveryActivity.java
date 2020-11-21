package com.minorproject.krashakmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.minorproject.krashakmart.adapter.CartAdapter;
import com.minorproject.krashakmart.model.CartItemModel;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    private RecyclerView DeliCon_Rc;
    private Button ChangeOrAdd_newadd;
    public static final int SELECT_ADDRESS =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_delivery);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Booking");


        DeliCon_Rc= findViewById(R.id.deliConfr_recyclerview);
        ChangeOrAdd_newadd=findViewById(R.id.changeOrAdd_address_btn);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DeliCon_Rc.setLayoutManager(linearLayoutManager);

        List<CartItemModel> cartItemModelList=new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.tractor1,"Mahindra Arjun","1000"));
        cartItemModelList.add(new CartItemModel(0,R.drawable.harvester1,"Escort Harvester","3000"));
        cartItemModelList.add(new CartItemModel(0,R.drawable.tractor1,"Mahindra Arjun","1200"));
        cartItemModelList.add(new CartItemModel(1,"Rs.1000/-","1000"));

        CartAdapter cartAdapter=new CartAdapter(cartItemModelList);
       DeliCon_Rc.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        ChangeOrAdd_newadd.setVisibility(View.VISIBLE);
        ChangeOrAdd_newadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myaddressesintent=new Intent(DeliveryActivity.this,MyAddressesActivity.class);
                myaddressesintent.putExtra("MODE",SELECT_ADDRESS);
                startActivity(myaddressesintent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id== android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}