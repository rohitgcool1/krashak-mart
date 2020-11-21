package com.minorproject.krashakmart.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.minorproject.krashakmart.DetailProductActivity;
import com.minorproject.krashakmart.R;
import com.minorproject.krashakmart.model.ProductModel;

import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {
    List<ProductModel> horizontalProductScrollModelList ;

    public GridProductLayoutAdapter(List<ProductModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @Override
    public int getCount() {
        return 4;
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
       if (convertView==null) {
           view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal_product, null);
           view.setElevation(0);
           view.setBackgroundColor(Color.parseColor("#ffffff"));

           view.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent productDetailsIntent= new Intent(parent.getContext(), DetailProductActivity.class);
                   parent.getContext().startActivity(productDetailsIntent);
               }
           });

           ImageView productImage = view.findViewById(R.id.h_s_product_image);
           TextView productTitle = view.findViewById(R.id.h_s_product_title);
           TextView productdesc = view.findViewById(R.id.h_s_product_desc);
           TextView productPrice = view.findViewById(R.id.h_s_product_price);

           try{}
           catch (IndexOutOfBoundsException e) {
               productImage.setImageResource(horizontalProductScrollModelList.get(position).getUrlImage());
               productTitle.setText(horizontalProductScrollModelList.get(position).getName());
               productdesc.setText(horizontalProductScrollModelList.get(position).getDescription());
               productPrice.setText(String.valueOf(horizontalProductScrollModelList.get(position).getPrice()));
           }
       }
       else
       {
         view=convertView;
       }
        return view;
    }
}
