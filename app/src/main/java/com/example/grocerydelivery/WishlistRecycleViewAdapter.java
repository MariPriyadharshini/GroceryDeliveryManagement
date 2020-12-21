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

import com.example.grocerydelivery.Models.Cart;
import com.example.grocerydelivery.Models.Product;
//import com.example.grocerydelivery.Models.Wishlist;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WishlistRecycleViewAdapter extends RecyclerView.Adapter<WishlistRecycleViewAdapter.ViewHolder> {
    Context context;
    String username;
    ArrayList<Product> productList;
    ArrayList<Cart> wishlist;
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference myref = mydb.getReference("Wishlist");
    DatabaseReference rref = mydb.getReference("Products");

    public WishlistRecycleViewAdapter(Context ct, ArrayList<Product> productArrayList, ArrayList<Cart> wishlistArray, String phn){
        this.context = ct;
        this.productList = productArrayList;
        this.wishlist = wishlistArray;
        this.username = phn;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,description,price;
        ImageView imageView;
        Button remove;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.wishlistname);
            description = itemView.findViewById(R.id.wishlistdescription);
            price = itemView.findViewById(R.id.wishlistcost);
            imageView = itemView.findViewById(R.id.wishlistimage);
            remove = itemView.findViewById(R.id.removewishlist);
        }
    }

    @NonNull
    @Override
    public WishlistRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.wishlist,parent,false);
        return new WishlistRecycleViewAdapter.ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull WishlistRecycleViewAdapter.ViewHolder holder, int position) {
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
            String cartKey= wishlist.get(position).getCart_key();
            //Glide.with(context).load(productList.get(position).getProd_image()).into(holder.imageView);
            holder.remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("#############333",wishlist.get(position).cart_key);
                    myref.child(cartKey).removeValue();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
