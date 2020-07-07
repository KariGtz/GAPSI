package com.example.prueba.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.prueba.Model.Record;
import com.example.prueba.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Record> mProductList;
    private Context mContext;

    public ProductAdapter(List<Record> productList, Context context) {
        this.mProductList = productList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nameProduct.setText(mProductList.get(position).getProductDisplayName());
        holder.priceProduct.setText("$" + mProductList.get(position).getListPrice());
        holder.locationProduct.setText(mProductList.get(position).getGroupType());

        Glide.with(mContext).load(mProductList.get(position).getSmImage()).into(holder.imgProduct);

    }

    @Override
    public int getItemCount() {
        int count = 0;
        if( mProductList != null ) {
            count = mProductList.size();
        }
        return count;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProduct;
        TextView nameProduct, priceProduct, locationProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = (ImageView)itemView.findViewById(R.id.imgProduct);
            nameProduct = (TextView) itemView.findViewById(R.id.nameProduct);
            priceProduct = (TextView) itemView.findViewById(R.id.priceProduct);
            locationProduct = (TextView) itemView.findViewById(R.id.locationProduct);

        }
    }
}
