package com.minorproject.krashakmart.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.minorproject.krashakmart.R;
import com.minorproject.krashakmart.model.CartItemModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {

private List<CartItemModel> cartItemModelList;

    public CartAdapter(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
         switch (cartItemModelList.get(position).getType()){
             case 0:
                 return CartItemModel.CART_ITEM;
             case 1:
                 return  CartItemModel.TOTAL_AMOUNT;
             default:return -1;
         }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        switch ((viewType))
        {
            case CartItemModel.CART_ITEM:
                View itemview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout,viewGroup,false);
                return new cartItemViewHolder(itemview);

                case CartItemModel.TOTAL_AMOUNT:
                    View totalview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout,viewGroup,false);
                    return new cartTotalAmountViewHolder(totalview);

            default:return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
 switch (cartItemModelList.get(position).getType()){
         case CartItemModel.CART_ITEM:
             int resource=cartItemModelList.get(position).getProductImage();
             String title=cartItemModelList.get(position).getProductTitle();
             String price =cartItemModelList.get(position).getProductPrice();
             ((cartItemViewHolder)viewHolder).setItemdetails(resource,title,price);
             break;

         case CartItemModel.TOTAL_AMOUNT:
             String totalItemprice =cartItemModelList.get(position).getTotalitem_pice();
             String totalamount=cartItemModelList.get(position).getTotalAmount();
             ((cartTotalAmountViewHolder)viewHolder).setTotalAmount(totalItemprice,totalamount);
             break;

         default: return;
 }
    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }

    class cartItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private TextView productTitle;
        private TextView productprice;
        public cartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.product_order_image);
            productTitle=itemView.findViewById(R.id.product_title);
            productprice=itemView.findViewById(R.id.product_price);
        }

        private void setItemdetails(int resource, String title,String productPrice){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            productprice.setText(productPrice);
        }
    }

    class cartTotalAmountViewHolder extends RecyclerView.ViewHolder{

         private TextView totalitem_price;
         private TextView totalamount;
        public cartTotalAmountViewHolder(@NonNull View itemView) {
            super(itemView);
            totalitem_price=itemView.findViewById(R.id.total_items_price);
            totalamount=itemView.findViewById(R.id.total_amount);

        }

        private void setTotalAmount(String totalitempriceText,String totalamountText)
        {
            totalitem_price.setText(totalitempriceText);
            totalamount.setText(totalamountText);
        }
    }
}
