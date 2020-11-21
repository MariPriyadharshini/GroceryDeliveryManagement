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

public class CartRecycleView extends AppCompatActivity {
    RecyclerView recyclerView;
    CartRecycleViewAdapter recycleViewAdapter;
    ArrayList<Product> productList;
    ArrayList<Cart> cartlist;
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference myref = mydb.getReference("Cart");
   // DatabaseReference rref = mydb.getReference("Products");
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
                int i=0;
                if(snapshot.exists()) {
                    //productList =  new ArrayList<Product>();
                    for (DataSnapshot schild : snapshot.getChildren()) {
                        Product p = new Product();
                        Cart c = new Cart();
                        c.setUser_name(phn);
                        p.setProd_name(schild.child("p").child("prod_name").getValue(String.class));
                        p.setProd_desc(schild.child("p").child("prod_desc").getValue(String.class));
                        p.setProd_avail_count(schild.child("p").child("prod_avail_count").getValue(String.class));
                        p.setProd_size(schild.child("p").child("prod_size").getValue(String.class));
                        String cost = "Rs." + schild.child("p").child("prod_price").getValue().toString();
                        p.setProd_price(cost);
                        p.setKey(schild.child("p").child("key").getValue().toString());
                        p.setCategory_name(schild.child("p").child("category_name").getValue(String.class));
                        p.setProd_image(schild.child("p").child("prod_image").getValue(String.class));
                        c.setP(p);
                        c.setCart_key(schild.child("cart_key").getValue(String.class));
                        productList.add(p);
                        cartlist.add(c);
                    }
                    recycleViewAdapter = new CartRecycleViewAdapter(context,productList,cartlist,phn);
                    recyclerView.setAdapter(recycleViewAdapter);
                    recycleViewAdapter.notifyDataSetChanged();
                    recyclerView.setLayoutManager(new LinearLayoutManager(CartRecycleView.this));
                }
                else {
                    Log.d("No DATA found", "*************as*************");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(CartRecycleView.this, "Error 404",Toast.LENGTH_LONG).show();
            }
        });
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void clearAll(){
        if(productList!=null){
            cartlist.clear();
            productList.clear();
            if(recycleViewAdapter!=null){
                recycleViewAdapter.notifyDataSetChanged();
            }
        }
        productList = new ArrayList<>();
        cartlist = new ArrayList<>();
    }
}

