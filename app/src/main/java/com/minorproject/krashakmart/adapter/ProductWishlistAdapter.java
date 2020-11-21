package com.minorproject.krashakmart.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.minorproject.krashakmart.R;
import com.minorproject.krashakmart.model.WishlistModel;

import java.util.List;

public class ProductWishlistAdapter extends RecyclerView.Adapter<ProductWishlistAdapter.ViewHolder> {

private List<WishlistModel> wishlistModelList;

    public ProductWishlistAdapter(List<WishlistModel> wishlistModelList) {
        this.wishlistModelList = wishlistModelList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_wishlisht,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
     int resourc =wishlistModelList.get(position).getProductimage();
     String prductTitle=wishlistModelList.get(position).getProducttitle();
        String prductPrice=wishlistModelList.get(position).getProductprice();
        String pymntAvl=wishlistModelList.get(position).getPaymntAvailable();
        int ttlRating=wishlistModelList.get(position).getTotalRating();
        String rating=wishlistModelList.get(position).getRating();
        viewHolder.setData(resourc,prductTitle,prductPrice,pymntAvl,ttlRating,rating);

    }

    @Override
    public int getItemCount() {
        return wishlistModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productimage;
        private TextView productTitle;
        private TextView productPrice;
        private TextView paymntAvaliable;
        private TextView totalRatings;
        private TextView rating;
        private ImageButton deletebtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productimage=itemView.findViewById(R.id.product_image);
           productTitle=itemView.findViewById(R.id.product_title);
            productPrice=itemView.findViewById(R.id.product_price);
            paymntAvaliable=itemView.findViewById(R.id.paymnt_avaliable);
           totalRatings=itemView.findViewById(R.id.total_ratings);
            deletebtn=itemView.findViewById(R.id.delete_btn);
            rating=itemView.findViewById(R.id.tv_rating_product_miniview);
        }

        private void setData(int res,String producttitle,String productprice,String pymntAvlb,int totalratingNo,String avgRate){
            productimage.setImageResource(res);
            productTitle.setText(producttitle);
            productPrice.setText(productprice);
            paymntAvaliable.setText(pymntAvlb);
            totalRatings.setText(totalratingNo +"ratings");
            rating.setText(avgRate);
            deletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"delete",Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}

