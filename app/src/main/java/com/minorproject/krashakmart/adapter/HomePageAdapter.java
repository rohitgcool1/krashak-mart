package com.minorproject.krashakmart.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.minorproject.krashakmart.Agri_Equipment;
import com.minorproject.krashakmart.Agri_Machine;
import com.minorproject.krashakmart.R;
import com.minorproject.krashakmart.model.HomePageModel;
import com.minorproject.krashakmart.model.ProductModel;

import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<HomePageModel> homePageModellist;

    public HomePageAdapter(List<HomePageModel> homePageModellist) {
        this.homePageModellist = homePageModellist;
    }

    @Override
    public int getItemViewType(int position) {
        switch (homePageModellist.get(position).getType())
        {
            case 0:
                return HomePageModel.HORIZONTAL_PRODUCT_VIEW;
            case 1:
                return HomePageModel.GRID_PRODUCT_VIEW;

            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType)
        {
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
              View horizontalProductView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_horizontal_product,viewGroup,false);
              return new HorizontalProductViewHolder(horizontalProductView);

            case HomePageModel.GRID_PRODUCT_VIEW:
                View gridlProductView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_grid_product,viewGroup,false);
                return new GridProductViewHolder(gridlProductView);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (homePageModellist.get(position).getType())
        {
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                String horizontalLayouttitle=homePageModellist.get(position).getTitle();
              List<ProductModel> productModelList=homePageModellist.get(position).getProductModelList();
                ((HorizontalProductViewHolder)viewHolder).setHorizontaLProductLayout(productModelList,horizontalLayouttitle);
              break;

            case HomePageModel.GRID_PRODUCT_VIEW:
                String gridlayouttitle=homePageModellist.get(position).getTitle();
                List<ProductModel> gridproductModelList=homePageModellist.get(position).getProductModelList();
                ((GridProductViewHolder)viewHolder).setGridProductLayout(gridproductModelList,gridlayouttitle);
                break;
            default:
            return;
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class HorizontalProductViewHolder extends RecyclerView.ViewHolder{
        private TextView horilayouttitle ;
        private Button viewall;
        private RecyclerView horizontalRv;

        public HorizontalProductViewHolder(@NonNull View itemView) {
            super(itemView);
            horilayouttitle=itemView.findViewById(R.id.horizontal_scroll_layout_title);
            viewall=itemView.findViewById(R.id.horizontal_scroll_view_all_btn);
            horizontalRv=itemView.findViewById(R.id.horizontal_scroll_layout_recyclerview);

        }

        public void setHorizontaLProductLayout(List<ProductModel> productModelList, String title) {
            horilayouttitle.setText(title);
            if(productModelList.size()>8)
            {
                viewall.setVisibility(View.VISIBLE);
                viewall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent  machineIntent= new Intent(itemView.getContext(), Agri_Machine.class);
                        itemView.getContext().startActivity(machineIntent);
                    }
                });
            }
            else {
                viewall.setVisibility(View.INVISIBLE);
            }
            HorizotalProductAdapter horizotalProductAdapter=new HorizotalProductAdapter(productModelList);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontalRv.setLayoutManager(linearLayoutManager);

            horizontalRv.setAdapter(horizotalProductAdapter);
            horizotalProductAdapter.notifyDataSetChanged();
        }
    }

    public class GridProductViewHolder extends RecyclerView.ViewHolder{
        private TextView gridlayoutTite;
        private Button gridlayoutViewAllButton;
        private GridView gridView;

        public GridProductViewHolder(@NonNull View itemView) {
            super(itemView);
             gridlayoutTite=itemView.findViewById(R.id.horizontal_scroll_layout_title);
            gridlayoutViewAllButton=itemView.findViewById(R.id.grid_product_button_viewall);
            gridView=itemView.findViewById(R.id.gridProductLayout_gridview);
        }

        private void setGridProductLayout(List<ProductModel>productModels,String title){
            gridlayoutTite.setText(title);
            gridView.setAdapter(new GridProductLayoutAdapter(productModels));

            gridlayoutViewAllButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent equipmentIntent= new Intent(itemView.getContext(),Agri_Equipment.class);
                    itemView.getContext().startActivity(equipmentIntent);
                }
            });
        }
    }

}
