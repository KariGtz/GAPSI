package com.example.prueba.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba.Model.Product;
import com.example.prueba.R;

import java.util.List;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.ViewHolder> {

    private List<Product> mProductList;
    private Context mContext;

    public RecentsAdapter(List<Product> productList, Context context) {
        this.mProductList = productList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recents, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nameProduct.setText(mProductList.get(position).getImagen());

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

        TextView nameProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameProduct = (TextView) itemView.findViewById(R.id.nameProduct);

        }
    }
}
