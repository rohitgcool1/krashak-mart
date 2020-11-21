package com.minorproject.krashakmart.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.minorproject.krashakmart.R;
import com.minorproject.krashakmart.model.ProductSpecificationModel;

import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class ProductSpecificationAdapter extends RecyclerView.Adapter<ProductSpecificationAdapter.ViewHolder> {

private List<ProductSpecificationModel> productSpecificationModelList;

    public ProductSpecificationAdapter(List<ProductSpecificationModel> productSpecificationModelList) {
        this.productSpecificationModelList = productSpecificationModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (productSpecificationModelList.get(position).getType()){
            case 0:
                return ProductSpecificationModel.specificationtitle;
            case 1:
                return ProductSpecificationModel.specificationbody;
            default:return -1;
        }
    }

    @NonNull
    @Override
    public ProductSpecificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType)
        {
            case ProductSpecificationModel.specificationtitle :
                TextView title=new TextView(viewGroup.getContext());
                title.setTypeface(null, Typeface.BOLD);
                title.setTextColor(Color.parseColor("#000000"));
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, MATCH_PARENT);
                layoutParams.setMargins(setdp(16,viewGroup.getContext()),
                setdp(16,viewGroup.getContext()),
                setdp(8,viewGroup.getContext()),
                setdp(8,viewGroup.getContext()));
                title.setLayoutParams(layoutParams);
                return new ViewHolder(title);


                case ProductSpecificationModel.specificationbody:
                    View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_specification_item_layout,viewGroup,false);
                    return new ViewHolder(view);

            default:return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecificationAdapter.ViewHolder viewHolder, int position) {
        switch (productSpecificationModelList.get(position).getType()){
            case ProductSpecificationModel.specificationtitle:
                viewHolder.setTitle(productSpecificationModelList.get(position).getTitle());
                break;
            case ProductSpecificationModel.specificationbody:
                String featureTitle=productSpecificationModelList.get(position).getFeaturename();
                String featuredetail=productSpecificationModelList.get(position).getFeaturevalue();
                viewHolder.setFeatures(featureTitle,featuredetail);
                break;
            default:return;
        }

    }

    @Override
    public int getItemCount() {
        return productSpecificationModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView featurename;
        private TextView featurevalue;
        private TextView title ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
        private void setTitle(String titleText){
            title=(TextView) itemView;
            title.setText(titleText);
        }
        private void setFeatures(String featureTitle,String featuredetail)
        {
            featurename=itemView.findViewById(R.id.feature_name);
            featurevalue=itemView.findViewById(R.id.feature_value);
            featurename.setText(featureTitle);
            featurevalue.setText(featuredetail);
        }

    }

    private int setdp(int dp, Context context)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());
    }
}
