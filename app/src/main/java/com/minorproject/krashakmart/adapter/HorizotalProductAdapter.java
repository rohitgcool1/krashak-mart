package com.minorproject.krashakmart.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.minorproject.krashakmart.DetailProductActivity;
import com.minorproject.krashakmart.R;
import com.minorproject.krashakmart.model.ProductModel;

import java.util.List;

public class HorizotalProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ProductModel> data;
    private Context context;

    public HorizotalProductAdapter(List<ProductModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal_product,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       /* String resource =data.get(position).getUrlImage();
        String name=data.get(position).getName();
        String descprtn=data.get(position).getDescription();
        float price=data.get(position).getPrice(); */


        ProductModel model = data.get(position);
/*
        if(holder instanceof ViewHolder) {
            int idImage = context.getResources().getIdentifier(model.getUrlImage(),"drawable",context.getPackageName());
            ((ViewHolder) holder).imgProduct.setImageResource(idImage);
            ((ViewHolder) holder).tvNameProduct.setText(model.getName());
            ((ViewHolder) holder).tvDescriptionProduct.setText(model.getDescription());
            ((ViewHolder) holder).tvPriceProduct.setText(String.valueOf(model.getPrice()) + "$");
        }

 */
    }

    @Override
    public int getItemCount() {
        if(data.size()>8)
        {
            return 8;
        }
        else {
            return data.size();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgProduct;
        private TextView tvNameProduct;
        private TextView tvDescriptionProduct;
        private TextView tvPriceProduct;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.h_s_product_image);
            tvNameProduct = itemView.findViewById(R.id.h_s_product_title);
            tvDescriptionProduct = itemView.findViewById(R.id.h_s_product_price);
            tvPriceProduct = itemView.findViewById(R.id.h_s_product_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productdetailintent = new Intent(itemView.getContext(), DetailProductActivity.class);
                    itemView.getContext().startActivity(productdetailintent);
                }
            });

        }
        private void setImgProduct(int recourse)
        {
            imgProduct.setImageResource(recourse);
        }
        private void setTvNameProduct(String name)
        {
            tvNameProduct.setText(name);
        }
        private void setTvDescriptionProduct(String descrptn)
        {
            tvDescriptionProduct.setText(descrptn);
        }
        private void setTvPriceProduct(String price)
        {
            tvPriceProduct.setText( price);
        }


    }
}
