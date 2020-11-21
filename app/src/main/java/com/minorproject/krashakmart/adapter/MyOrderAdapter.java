package com.minorproject.krashakmart.adapter;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.minorproject.krashakmart.OrderDetailActivity;
import com.minorproject.krashakmart.R;
import com.minorproject.krashakmart.model.MyOrderitemModel;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    private List<MyOrderitemModel> myOrderitemModelList;

    public MyOrderAdapter(List<MyOrderitemModel> myOrderitemModelList) {
        this.myOrderitemModelList = myOrderitemModelList;
    }


    @NonNull
    @Override
    public MyOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my_order,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.ViewHolder holder, int position) {
         int resource=myOrderitemModelList.get(position).getProductimage();
         int rating=myOrderitemModelList.get(position).getRating();
         String title=myOrderitemModelList.get(position).getProducttitle();
         String deliveredDate=myOrderitemModelList.get(position).getDeliverystatus();
         holder.setData(resource,title,deliveredDate,rating);

    }

    @Override
    public int getItemCount() {
        return myOrderitemModelList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        private ImageView productimage;
        private ImageView orderIndicator;
        private TextView productTitle;
        private TextView deliverystatus;
        private LinearLayout rateNowContainer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productimage=itemView.findViewById(R.id.product_order_image);
           orderIndicator=itemView.findViewById(R.id.order_indicator);
            productTitle=itemView.findViewById(R.id.product_title);
            deliverystatus=itemView.findViewById(R.id.order_delivered_date);
            rateNowContainer=itemView.findViewById(R.id.rate_now_container);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent orderdetailsIntent=new Intent(itemView.getContext(), OrderDetailActivity.class);
                    itemView.getContext().startActivity(orderdetailsIntent);
                }
            });
        }
        private void setData(int res, String title, String deliveryDate,int rating){
          productimage.setImageResource(res);
          productTitle.setText(title);
          if (deliveryDate.equals("Cancelled")){
              orderIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.Red)));
          }
          else {
              orderIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.green)));
          }
            deliverystatus.setText(deliveryDate);
           //rating layout
            setRating(rating);
            for (int x=0;x <rateNowContainer.getChildCount();x++){
                final int starposition=x;
                rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setRating(starposition);
                    }
                });
            }
            //rating layout
        }
        private void setRating(int starposition) {
            for (int x = 0; x < rateNowContainer.getChildCount(); x++) {
                ImageView starbtn = (ImageView) rateNowContainer.getChildAt(x);
                starbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#969696")));
                if (x <= starposition) {
                    starbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFC73B")));
                }
            }
        }
    }
}
