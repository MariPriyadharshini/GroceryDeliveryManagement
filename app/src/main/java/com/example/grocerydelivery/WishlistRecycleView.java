package com.example.grocerydelivery;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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

public class WishlistRecycleView extends AppCompatActivity {
    RecyclerView recyclerView;
    WishlistRecycleViewAdapter recycleViewAdapter;
    ArrayList<Product> productList;
    ArrayList<Cart> wishlist;
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference myref = mydb.getReference("Wishlist");
    DatabaseReference pref = mydb.getReference("Products");
    Context context;
    Global g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.recyclerview);
        recyclerView = findViewById(R.id.my_recycler_view);
        clearAll();
        String phn = getIntent().getStringExtra("userName");
        Log.d("$$$$$$$$$$$$$$44",phn);
        Query chk = myref.orderByChild("user_name").equalTo(phn);
        chk.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    //productList =  new ArrayList<Product>();
                    for (DataSnapshot schild : snapshot.getChildren()) {
                        Product p = new Product();
                        Cart c = new Cart();
                        c.setUser_name(phn);
                        c.setCart_key(schild.child("cart_key").getValue(String.class));
                        c.setP(schild.child("product_key").getValue(String.class));
                        wishlist.add(c);
                        Query pchk = pref.orderByChild("key").equalTo(c.product_key);
                        pchk.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()) {
                                    for (DataSnapshot pchild : snapshot.getChildren()) {
                                        Log.d("Product found", "*************as*************");
                                        p.setProd_name(pchild.child("prod_name").getValue(String.class));
                                        p.setProd_desc(pchild.child("prod_desc").getValue(String.class));
                                        p.setProd_avail_count(pchild.child("prod_avail_count").getValue(String.class));
                                        p.setProd_size(pchild.child("prod_size").getValue(String.class));
                                        String cost = "Rs." + pchild.child("prod_price").getValue().toString();
                                        p.setProd_price(cost);
                                        Log.d("No DATA found", cost);
                                        p.setKey(pchild.child("key").getValue().toString());
                                        p.setCategory_name(pchild.child("category_name").getValue(String.class));
                                        p.setProd_image(pchild.child("prod_image").getValue(String.class));
                                        productList.add(p);
                                    }
                                    recycleViewAdapter = new WishlistRecycleViewAdapter(context, productList, wishlist, phn);
                                    recyclerView.setAdapter(recycleViewAdapter);
                                    recycleViewAdapter.notifyDataSetChanged();
                                    recyclerView.setLayoutManager(new LinearLayoutManager(WishlistRecycleView.this));
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(WishlistRecycleView.this, "Error 404:No Product under cart",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(WishlistRecycleView.this, "Error 404",Toast.LENGTH_LONG).show();
            }
        });
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void clearAll(){
        if(productList!=null){
            wishlist.clear();
            productList.clear();
            if(recycleViewAdapter!=null){
                recycleViewAdapter.notifyDataSetChanged();
            }
        }
        productList = new ArrayList<>();
        wishlist = new ArrayList<>();
    }
}

