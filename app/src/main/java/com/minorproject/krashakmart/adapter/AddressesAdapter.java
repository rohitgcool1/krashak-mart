package com.minorproject.krashakmart.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.minorproject.krashakmart.R;
import com.minorproject.krashakmart.model.AddressesModel;

import java.util.List;

import static com.minorproject.krashakmart.DeliveryActivity.SELECT_ADDRESS;
import static com.minorproject.krashakmart.MyAccountFragment.MANAGE_ADDRESS;
import static com.minorproject.krashakmart.MyAddressesActivity.refreshItem;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder> {

    private List<AddressesModel>addressesModelList;
    private int MODE;
    private int preSelectedposition=-1;
    public AddressesAdapter(List<AddressesModel> addressesModelList,int mode) {
        this.addressesModelList = addressesModelList;
        this.MODE=mode;
    }

    @NonNull
    @Override
    public AddressesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.addresses_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressesAdapter.ViewHolder holder, int position) {
       String nm=addressesModelList.get(position).getFull_name();
        String addrs=addressesModelList.get(position).getAddress();
        String pincd=addressesModelList.get(position).getPincode();
        Boolean selected=addressesModelList.get(position).getSelected();
         holder.setData(nm,addrs,pincd,selected,position);


    }

    @Override
    public int getItemCount() {
        return addressesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fullname;
        private TextView address;
        private TextView pincode;
        private ImageView icon;
        private LinearLayout optinContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fullname=itemView.findViewById(R.id.name);
            address=itemView.findViewById(R.id.address);
           pincode=itemView.findViewById(R.id.pincode);
           icon=itemView.findViewById(R.id.icon_view);
           optinContainer=itemView.findViewById(R.id.option_container);
        }

        private void setData(String username,String useraddress,String userpincode,Boolean slctd,int position){
            fullname.setText(username);
            address.setText(useraddress);
            pincode.setText(userpincode);

            if (MODE==SELECT_ADDRESS){
                icon.setImageResource(R.drawable.ic_check_16dp);
                if (slctd){
                    icon.setVisibility(View.VISIBLE);
                    preSelectedposition=position;
                }
                else {
                    icon.setVisibility(View.GONE);
                }
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(preSelectedposition!=position) {
                            addressesModelList.get(position).setSelected(true);
                            addressesModelList.get(preSelectedposition).setSelected(false);
                            refreshItem(preSelectedposition, position);
                            preSelectedposition = position;
                        }
                    }
                });

            }
            else if(MODE== MANAGE_ADDRESS){
                optinContainer.setVisibility(View.GONE);
                icon.setImageResource(R.mipmap.vertical3_dots);
                icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        optinContainer.setVisibility(View.VISIBLE);
                        refreshItem(preSelectedposition,preSelectedposition);
                        preSelectedposition=position;
                    }
                });
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refreshItem(preSelectedposition,preSelectedposition);
                        preSelectedposition=-1;
                    }
                });
            }
        }
    }
}
