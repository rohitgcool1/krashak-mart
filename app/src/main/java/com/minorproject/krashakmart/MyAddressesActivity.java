package com.minorproject.krashakmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.minorproject.krashakmart.adapter.AddressesAdapter;
import com.minorproject.krashakmart.model.AddressesModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.minorproject.krashakmart.DeliveryActivity.SELECT_ADDRESS;


public class MyAddressesActivity extends AppCompatActivity {
      private RecyclerView myAddressesRc;
      private static AddressesAdapter addressesAdapter;
      private Button deliBook_hereBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("My Addresses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myAddressesRc=findViewById(R.id.addresses_recycler_view);
        deliBook_hereBtn=findViewById(R.id.deliverConf_here_btn);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myAddressesRc.setLayoutManager(linearLayoutManager);

        List<AddressesModel> addressesModelList=new ArrayList<>();
        addressesModelList.add(new AddressesModel("Willamson","fuwei7ngunciergi","904328",true));
        addressesModelList.add(new AddressesModel("Willamson","vcxjhndviyui","549724",false));
        addressesModelList.add(new AddressesModel("Newton","nnnsaiosxei", "4463214",false));
        addressesModelList.add(new AddressesModel("Willamson","zxcvbnmqwertyuiop","254786",false));

        int mode=getIntent().getIntExtra("MODE",-1);
        if (mode==SELECT_ADDRESS){
            deliBook_hereBtn.setVisibility(View.VISIBLE);
        }
        else{
            deliBook_hereBtn.setVisibility(View.GONE);
        }
        addressesAdapter=new AddressesAdapter(addressesModelList,mode);
        myAddressesRc.setAdapter(addressesAdapter);
        ((SimpleItemAnimator)myAddressesRc.getItemAnimator()).setSupportsChangeAnimations(false);
        addressesAdapter.notifyDataSetChanged();

    }

    public static void refreshItem(int deSelct ,int selct){
        addressesAdapter.notifyItemChanged(deSelct);
        addressesAdapter.notifyItemChanged(selct);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}