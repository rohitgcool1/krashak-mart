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

            List<Agri_machineModel> agri_machineModelList = new ArrayList<>();
            agri_machineModelList.add(new Agri_machineModel(R.drawable.icon_tractor, "TRACTOR"));
            agri_machineModelList.add(new Agri_machineModel(R.drawable.icon_harvester, "HARVESTER"));
            agri_machineModelList.add(new Agri_machineModel(R.drawable.icon_trolley, "TROLLY"));
        agri_machineModelList.add(new Agri_machineModel(R.drawable.icon_seeddrill, "SEED DRILL"));
        agri_machineModelList.add(new Agri_machineModel(R.drawable.icon_cultivator, "CULTIVATOR"));
        agri_machineModelList.add(new Agri_machineModel(R.drawable.icon_rotavator, "ROTARVATOR"));
        agri_machineModelList.add(new Agri_machineModel(R.drawable.icon_more, "MORE"));

            Agri_machineAdapter agri_machineAdapter = new Agri_machineAdapter(agri_machineModelList);
            gvAgriMachines.setAdapter(agri_machineAdapter);

            gvAgriMachines.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent productDetailsIntent = new Intent(Agri_Machine.this,ViewAll_AgriMachinesActivity.class);
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