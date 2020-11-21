package com.minorproject.krashakmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.minorproject.krashakmart.adapter.Agri_machineAdapter;
import com.minorproject.krashakmart.model.Agri_machineModel;

import java.util.ArrayList;
import java.util.List;

public class Agri_Machine extends AppCompatActivity {

    private GridView gvAgriMachines;
    List<Agri_machineModel> agri_machineModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agri__machine);

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Agri Machines");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gvAgriMachines=findViewById(R.id.agri_machine_gridview);

        int layout_code=getIntent().getIntExtra("layout_code",-1);

        if(layout_code==0) {
            List<Agri_machineModel> agri_machineModelList = new ArrayList<>();
            agri_machineModelList.add(new Agri_machineModel(R.drawable.tractor1, "TRACTOR"));
            agri_machineModelList.add(new Agri_machineModel(R.drawable.harvester1, "HARVESTER"));
            agri_machineModelList.add(new Agri_machineModel(R.drawable.trolly1, "TROLLY"));

            Agri_machineAdapter agri_machineAdapter = new Agri_machineAdapter(agri_machineModelList);
            gvAgriMachines.setAdapter(agri_machineAdapter);
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