package com.minorproject.krashakmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

            List<AgriEquipment_Model> agriEquipment_modelList = new ArrayList<>();
            agriEquipment_modelList.add(new AgriEquipment_Model(R.drawable.iocn_waterpump, "WATER PUMP"));
            agriEquipment_modelList.add(new AgriEquipment_Model(R.drawable.icon_submersebilpump, "SUBMERSEBIL PUMP"));
            agriEquipment_modelList.add(new AgriEquipment_Model(R.drawable.icon_spraypump, "SPRAY PUMP/MACHINE"));
            agriEquipment_modelList.add(new AgriEquipment_Model(R.drawable.icon_sprinkler, "SPRINKLER"));
            agriEquipment_modelList.add(new AgriEquipment_Model(R.drawable.icon_spraypipe, "SPRAY PIPE"));
            agriEquipment_modelList.add(new AgriEquipment_Model(R.drawable.icon_alternator, "ALTERNATOR"));
            agriEquipment_modelList.add(new AgriEquipment_Model(R.drawable.icon_more, "MORE"));

            AgriEquipment_Adapter agriEquipment_adapter = new AgriEquipment_Adapter(agriEquipment_modelList);
            gvAgriEquipment.setAdapter(agriEquipment_adapter);

        gvAgriEquipment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent productDetailsIntent = new Intent(Agri_Equipment.this,ViewAll_EquipmentActivity.class);
                startActivity(productDetailsIntent);
            }
        });



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