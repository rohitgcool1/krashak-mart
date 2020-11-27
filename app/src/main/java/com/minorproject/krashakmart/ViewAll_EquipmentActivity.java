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

public class ViewAll_EquipmentActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all__equipment);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("AGRI EQUIPMENTS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView=findViewById(R.id.gridview_agri_equipment_vl);

        List<ProductModel>productModelList=new ArrayList<>();
        productModelList.add(new ProductModel(R.drawable.waterpump," Sabar Water Pump","Three Phase Monoblock SMH series",200));
        productModelList.add(new ProductModel(R.drawable.submersebil_icon," Sabar Submersible","Three Phase Borewell VM series",800));

        GridProductLayoutAdapter gridProductLayoutAdapter=new GridProductLayoutAdapter(productModelList);
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