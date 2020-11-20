package com.example.grocerydelivery;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerydelivery.Models.Product;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    Context context;
    ArrayList<Product> productList;

    public RecycleViewAdapter(Context ct,  ArrayList<Product> productArrayList){
        this.context = ct;
        this.productList = productArrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,description,price;
        ImageView imageView;
        Button cart,wishlist;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.cost);
            imageView = itemView.findViewById(R.id.imgid);
            cart = itemView.findViewById(R.id.cart);
            wishlist = itemView.findViewById(R.id.wishlist);
        }
    }

    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview,parent,false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder holder, int position) {
        if(context == null) {
            Log.d("$$$$$$$$$$$$$$$$*","error");
        }
        else {
            context = holder.itemView.getContext();
            Log.d("****cardView****", productList.get(position).getProd_image());
            holder.name.setText(productList.get(position).getProd_name());
            String desc = productList.get(position).getProd_desc()+" "+productList.get(position).getProd_size();
            holder.description.setText(desc);
            holder.price.setText(productList.get(position).getProd_price());
            holder.imageView.setImageResource(R.drawable.beverages);
            //Glide.with(context).load(productList.get(position).getProd_image()).into(holder.imageView);
            holder.cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Signin.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
            holder.wishlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Signup.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
