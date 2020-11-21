package com.minorproject.krashakmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.minorproject.krashakmart.adapter.AgriEquipment_Adapter;
import com.minorproject.krashakmart.model.AgriEquipment_Model;

import java.util.ArrayList;
import java.util.List;

public class Agri_Equipment extends AppCompatActivity {

    private GridView gvAgriEquipment;
    List<AgriEquipment_Model> agriEquipment_modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agri__equipment);

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Agri Equipments");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gvAgriEquipment=findViewById(R.id.agri_equipment_gridview);
        int layout_code=getIntent().getIntExtra("layout_code",-1);

        if(layout_code==1) {
            List<AgriEquipment_Model> agriEquipment_modelList = new ArrayList<>();
            agriEquipment_modelList.add(new AgriEquipment_Model(R.drawable.waterpump_icon, "WATER PUMP"));
            agriEquipment_modelList.add(new AgriEquipment_Model(R.drawable.submersebil_icon, "SUBMERSEBIL"));
            agriEquipment_modelList.add(new AgriEquipment_Model(R.drawable.spraymachine_icon, "SPRAY PUMP/MACHINE"));

            AgriEquipment_Adapter agriEquipment_adapter = new AgriEquipment_Adapter(agriEquipment_modelList);
            gvAgriEquipment.setAdapter(agriEquipment_adapter);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_icon, menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.main_search_icon)
        {
            //todo:search
            return true;
        }
        else if(id== android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}