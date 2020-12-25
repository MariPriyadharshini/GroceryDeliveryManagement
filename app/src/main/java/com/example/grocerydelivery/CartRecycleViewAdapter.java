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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CartRecycleViewAdapter extends RecyclerView.Adapter<CartRecycleViewAdapter.ViewHolder> {
    Context context;
    ArrayList<Product> productList;
    ArrayList<Cart> cartlist;
    String usrname;
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference myref = mydb.getReference("Cart");
    DatabaseReference rref = mydb.getReference("Products");

    public CartRecycleViewAdapter(Context ct,  ArrayList<Product> productArrayList,ArrayList<Cart> cartArrayList,String phn){
        this.context = ct;
        this.productList = productArrayList;
        this.cartlist = cartArrayList;
        this.usrname = phn;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,description,price;
        ImageView imageView;
        Button buy,remove;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.cartname);
            description = itemView.findViewById(R.id.cartdescription);
            price = itemView.findViewById(R.id.cartcost);
            imageView = itemView.findViewById(R.id.cartimage);
            buy = itemView.findViewById(R.id.buynow);
            remove = itemView.findViewById(R.id.remove);
        }
    }

    @NonNull
    @Override
    public CartRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cart,parent,false);
        return new CartRecycleViewAdapter.ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull CartRecycleViewAdapter.ViewHolder holder, int position) {
        if(context == null) {
            Log.d("$$$$$$$$$$$$$$$$*","error");
        }
        else {
            context = holder.itemView.getContext();
            Log.d("****cardView****", productList.get(position).getProd_image());
            holder.name.setText(productList.get(position).getProd_name());
            String catname = productList.get(position).getCategory_name();
            String desc = productList.get(position).getProd_desc()+" "+productList.get(position).getProd_size();
            holder.description.setText(desc);
            holder.price.setText(productList.get(position).getProd_price());
            //holder.imageView.setImageResource(R.drawable.beverages);
            if(catname.equals("Vegetables")) {
                holder.imageView.setImageResource(R.drawable.vegetables);
            }
            else if(catname.equals("Accessories")) {
                holder.imageView.setImageResource(R.drawable.accesories);
            }
            else if(catname.equals("BabyCare")) {
                holder.imageView.setImageResource(R.drawable.baby);
            }
            else if(catname.equals("Beverages")) {
                holder.imageView.setImageResource(R.drawable.beverages);
            }
            else if(catname.equals("Biscuits")) {
                holder.imageView.setImageResource(R.drawable.biscuits);
            }
            else if(catname.equals("Chocolates")) {
                holder.imageView.setImageResource(R.drawable.chocolates);
            }
            else if(catname.equals("DairyProduct")) {
                holder.imageView.setImageResource(R.drawable.items);
            }
            else if(catname.equals("Fruits")) {
                holder.imageView.setImageResource(R.drawable.fruits);
            }
            else if(catname.equals("Grains")) {
                holder.imageView.setImageResource(R.drawable.grainsandcereals);
            }
            else if(catname.equals("HairCare")) {
                holder.imageView.setImageResource(R.drawable.hair);
            }
            else if(catname.equals("HouseHold")) {
                holder.imageView.setImageResource(R.drawable.household);
            }
            else if(catname.equals("Oils")) {
                holder.imageView.setImageResource(R.drawable.oil);
            }
            else if(catname.equals("OralCare")) {
                holder.imageView.setImageResource(R.drawable.oralcare);
            }
            else if(catname.equals("PackedItems")) {
                holder.imageView.setImageResource(R.drawable.maggie);
            }
            else if(catname.equals("SkinCare")) {
                holder.imageView.setImageResource(R.drawable.skincare);
            }
            else if(catname.equals("Snacks")) {
                holder.imageView.setImageResource(R.drawable.snacks);
            }
            else if(catname.equals("Spices")) {
                holder.imageView.setImageResource(R.drawable.spices);
            }
            else if(catname.equals("Staples")) {
                holder.imageView.setImageResource(R.drawable.staple);
            }
            String cartKey= cartlist.get(position).getCart_key();
            String prodKey = cartlist.get(position).getP();
            //Glide.with(context).load(productList.get(position).getProd_image()).into(holder.imageView);
            holder.buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Purchase.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("cartKey",cartKey);
                    intent.putExtra("prodKey",prodKey);
                    intent.putExtra("userName",usrname);
                    context.startActivity(intent);
                }
            });
            holder.remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("#############333",cartlist.get(position).cart_key);
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
