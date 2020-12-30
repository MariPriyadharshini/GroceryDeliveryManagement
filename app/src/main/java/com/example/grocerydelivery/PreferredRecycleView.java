package com.example.grocerydelivery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerydelivery.Models.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PreferredRecycleView extends AppCompatActivity {
    RecyclerView recyclerView;
    RecycleViewAdapter recycleViewAdapter;
    ArrayList<Product> productList;
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference myref = mydb.getReference("Products");
    DatabaseReference pref = mydb.getReference("PreferredCategory");
    Context context;
    Global g;
    String usrname;
    ImageView cart,wishlist,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.recyclerview);
        recyclerView = findViewById(R.id.my_recycler_view);
        clearAll();
        g = (Global)getApplication();
        usrname = getIntent().getStringExtra("userName");
        String name = getIntent().getStringExtra("categoryName");
        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreferredRecycleView.this, Category.class);
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });
        cart = findViewById(R.id.cartview1);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreferredRecycleView.this, CartRecycleView.class);
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        wishlist = findViewById(R.id.wishlist1);
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreferredRecycleView.this, WishlistRecycleView.class);
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });
        Query pchk = pref.orderByChild("user_name").equalTo(usrname);
        pchk.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    for(DataSnapshot pchild : snapshot.getChildren()) {
                        for(int i=1;i<6;i++) {
                            String item = "item"+i;
                            String name = pchild.child(item).getValue().toString();
                            Query chk = myref.orderByChild("category_name").equalTo(name);
                            chk.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    int i = 0;
                                    if (snapshot.exists()) {
                                        //productList =  new ArrayList<Product>();
                                        for (DataSnapshot schild : snapshot.getChildren()) {
                                            Product p = new Product();
                                            p.setProd_name(schild.child("prod_name").getValue(String.class));
                                            p.setProd_desc(schild.child("prod_desc").getValue(String.class));
                                            p.setProd_avail_count(schild.child("prod_avail_count").getValue(String.class));
                                            p.setProd_size(schild.child("prod_size").getValue(String.class));
                                            String cost = "Rs." + schild.child("prod_price").getValue().toString();
                                            p.setProd_price(cost);
                                            p.setKey(schild.child("key").getValue().toString());
                                            p.setCategory_name(schild.child("category_name").getValue(String.class));
                                            p.setProd_image(schild.child("prod_image").getValue(String.class));
                                            Log.d("Name:", p.prod_image);
                                            productList.add(p);
                                            Log.d("Name After adding:", productList.get(i).prod_image);
                                            Log.d("*-*-*-*-*--*-**-*-*-*-*", String.valueOf(productList.size()));
                                            //Toast.makeText(Recyclerview.this,"Inside For loop of ondata",Toast.LENGTH_LONG).show();
                                            Log.d("^^^^^^^^^^^^^^^", g.getUser_name());
                                        }
                                        recycleViewAdapter = new RecycleViewAdapter(context, productList, usrname, name);
                                        recyclerView.setAdapter(recycleViewAdapter);
                                        recycleViewAdapter.notifyDataSetChanged();
                                        recyclerView.setLayoutManager(new LinearLayoutManager(PreferredRecycleView.this));
                                    } else {
                                        Log.d("No DATA found", "*************as*************");
                                    }
                                    //Toast.makeText(Recyclerview.this,"Out of For loop",Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Toast.makeText(PreferredRecycleView.this, "Error 404", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void clearAll(){
        if(productList!=null){
            productList.clear();
            if(recycleViewAdapter!=null){
                recycleViewAdapter.notifyDataSetChanged();
            }
        }
        productList = new ArrayList<>();
    }
}


