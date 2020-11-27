package com.minorproject.krashakmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import com.minorproject.krashakmart.adapter.GridProductLayoutAdapter;
import com.minorproject.krashakmart.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ViewAll_AgriMachinesActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("AGRI MACHINES");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView=findViewById(R.id.gridview_agri_machines_vl);

        List<ProductModel> productModels=new ArrayList<>();
        productModels.add(new ProductModel(R.drawable.harvester1,"Swaraj Harvester","8100 Combine 105hp",5000));
        productModels.add(new ProductModel(R.drawable.tractor1,"Mahindra","Arjun 500D",800));

        GridProductLayoutAdapter gridProductLayoutAdapter=new GridProductLayoutAdapter(productModels);
        gridView.setAdapter(gridProductLayoutAdapter);
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