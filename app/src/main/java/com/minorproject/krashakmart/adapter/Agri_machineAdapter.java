package com.minorproject.krashakmart.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.minorproject.krashakmart.R;
import com.minorproject.krashakmart.ViewAll_AgriMachinesActivity;
import com.minorproject.krashakmart.model.Agri_machineModel;

import java.util.List;

public class Agri_machineAdapter extends BaseAdapter {

    List<Agri_machineModel>agri_machineModelList;


    public Agri_machineAdapter(List<Agri_machineModel> agri_machineModelList) {
        this.agri_machineModelList = agri_machineModelList;
    }

    public Agri_machineAdapter() {
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.machine_category, null);

            ImageView machineImg=view.findViewById(R.id.machine_image);
            TextView machineName=view.findViewById(R.id.machine_name);
            try{

            }catch(NullPointerException e) {
                machineImg.setImageResource(agri_machineModelList.get(position).getIcon());
                machineName.setText(agri_machineModelList.get(position).getName());
            }

        }
        else{
            view=convertView;
        }
        return view;
    }
}
