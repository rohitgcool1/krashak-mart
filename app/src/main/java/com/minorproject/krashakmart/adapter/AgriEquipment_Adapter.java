package com.minorproject.krashakmart.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.minorproject.krashakmart.R;
import com.minorproject.krashakmart.ViewAll_EquipmentActivity;
import com.minorproject.krashakmart.model.AgriEquipment_Model;

import java.util.List;

public class AgriEquipment_Adapter extends BaseAdapter {

    private List<AgriEquipment_Model> agriEquipment_modelList;

    public AgriEquipment_Adapter(List<AgriEquipment_Model> agriEquipment_modelList) {
        this.agriEquipment_modelList = agriEquipment_modelList;
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

            ImageView equipmentImg=view.findViewById(R.id.machine_image);
            TextView equipmentName=view.findViewById(R.id.machine_name);
            try
            {

            }
            catch(NullPointerException e) {
                equipmentImg.setImageResource(agriEquipment_modelList.get(position).getIcon());
                equipmentName.setText(agriEquipment_modelList.get(position).getName());
            }

        }
        else{
            view=convertView;
        }
        return view;

    }
}
