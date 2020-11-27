package com.minorproject.krashakmart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddCategoryActivity extends AppCompatActivity {

    private TextView ptractor, ptrolly, pharvester, pseed_drill,
            pcultivator, protarvator, pmore_machines;
    private TextView pwater_pump, psubmersebil_pump, pspray_machine,
            psprinkler, pspray_pipe, paltetnator, pmore_equipments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        ptractor = (TextView) findViewById(R.id.tractor);
        ptrolly = (TextView) findViewById(R.id.trolly);
        pharvester = (TextView) findViewById(R.id.harvester);
        pseed_drill = (TextView) findViewById(R.id.seed_drill);
        pcultivator = (TextView) findViewById(R.id.cultivator);
        protarvator = (TextView) findViewById(R.id.rotarvater);
        pmore_machines = (TextView) findViewById(R.id.more_machines);

        pwater_pump = (TextView) findViewById(R.id.water_pump);
        psubmersebil_pump = (TextView) findViewById(R.id.submersebil_pump);
        pspray_machine = (TextView) findViewById(R.id.spray_machine);
        psprinkler = (TextView) findViewById(R.id.sprinkler);
        pspray_pipe = (TextView) findViewById(R.id.spray_pipe);
        paltetnator = (TextView) findViewById(R.id.altetnator);
        pmore_equipments = (TextView) findViewById(R.id.more_equipments);

        ptractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","tractor");
                startActivity(intent);
            }
        });

        ptrolly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","trolly");
                startActivity(intent);
            }
        });

        pharvester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","harvester");
                startActivity(intent);
            }
        });

        pseed_drill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","seed drill");
                startActivity(intent);
            }
        });

        pcultivator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","cultivator");
                startActivity(intent);
            }
        });

        protarvator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","rotarvator");
                startActivity(intent);
            }
        });

        pmore_machines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","more machines");
                startActivity(intent);
            }
        });

        pwater_pump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","water pump");
                startActivity(intent);
            }
        });

        psubmersebil_pump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","submersebil pump");
                startActivity(intent);
            }
        });

        pspray_machine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","spray machine");
                startActivity(intent);
            }
        });

        psprinkler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","sprinkler");
                startActivity(intent);
            }
        });

        pspray_pipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","spray pipe");
                startActivity(intent);
            }
        });

        paltetnator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","altetnator");
                startActivity(intent);
            }
        });

        pmore_equipments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.minorproject.krashakmart.AddCategoryActivity.this,AddNewProductActivity.class);
                intent.putExtra("category","more equipments");
                startActivity(intent);
            }
        });
    }
}