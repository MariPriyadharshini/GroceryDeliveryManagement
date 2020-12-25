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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerydelivery.Models.Cart;
import com.example.grocerydelivery.Models.Product;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    Context context;
    ArrayList<Product> productList;
    String usrname,catname;
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference myref = mydb.getReference("Cart");
    DatabaseReference rref = mydb.getReference("Wishlist");
    Cart c;
    Global g;

    public RecycleViewAdapter(Context ct,  ArrayList<Product> productArrayList,String usrname,String name){
        this.context = ct;
        this.productList = productArrayList;
        this.usrname = usrname;
        this.catname = name;
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
            //Glide.with(context).load(productList.get(position).getProd_image()).into(holder.imageView);
            holder.cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c = new Cart();
                    c.setUser_name(usrname);
                    c.setP(productList.get(position).getKey());
                    String key = c.getUser_name()+productList.get(position).getKey();
                    c.setCart_key(key);
                    myref.child(c.cart_key).setValue(c).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("**********","Inserted");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("*********","Fails");
                        }
                    });
                    Toast.makeText(context,"Added to Cart",Toast.LENGTH_LONG).show();
                }
            });
            holder.wishlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c = new Cart();
                    c.setUser_name(usrname);
                    c.setP(productList.get(position).getKey());
                    String key = c.getUser_name()+productList.get(position).getKey();
                    c.setCart_key(key);
                    rref.child(key).setValue(c).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("**********","Inserted");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("*********","Fails");
                        }
                    });
                    Toast.makeText(context,"Added to Wishlist",Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
