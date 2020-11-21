package com.minorproject.krashakmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class AddAddressActivity extends AppCompatActivity {

    private Button savetbn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        savetbn=findViewById(R.id.save_btn);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Add New Address");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        savetbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deli_ConfIntent=new Intent(AddAddressActivity.this,DeliveryActivity.class);
                startActivity(deli_ConfIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if (id== android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}