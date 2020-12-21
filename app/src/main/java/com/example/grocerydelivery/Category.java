package com.example.grocerydelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.Nullable;

public class Category extends AppCompatActivity {
    ImageView wishlist,cart,dairy,baby,fruits,haircare,packeditem,biscuits,household,grains,staples,accesories,beverages,chocolates,hair,items ,maggie,oil,oralcare,snacks,spices,staple,tissue,vegetables,skincare;
    String usrname;
    TextView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        usrname = getIntent().getStringExtra("userName");

        cart = findViewById(R.id.cartview);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, CartRecycleView.class);
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        wishlist = findViewById(R.id.wishlist);
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, WishlistRecycleView.class);
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Signin.class);
                startActivity(intent);
            }
        });

        vegetables = findViewById(R.id.image4);
        vegetables.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Vegetables");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        fruits = findViewById(R.id.image5);
        fruits.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Fruits");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        spices = findViewById(R.id.image6);
        spices.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Spices");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        oralcare = findViewById(R.id.image7);
        oralcare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","OralCare");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        dairy = findViewById(R.id.image8);
        dairy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","DairyProduct");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        chocolates = findViewById(R.id.image9);
        chocolates.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Chocolates");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        skincare = findViewById(R.id.image18);
        skincare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","SkinCare");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        accesories = findViewById(R.id.image11);
        accesories.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Accessories");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        oil = findViewById(R.id.image10);
        oil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Oil");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        snacks = findViewById(R.id.image2);
        snacks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Snacks");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        grains = findViewById(R.id.image1);
        grains.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Grains");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        staples = findViewById(R.id.image3);
        staples.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Staples");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        biscuits = findViewById(R.id.image12);
        biscuits.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Biscuits");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        beverages = findViewById(R.id.image13);
        beverages.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Beverages");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        household = findViewById(R.id.image14);
        household.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","HouseHoldsItems");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        haircare = findViewById(R.id.image16);
        haircare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","HairCare");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        baby = findViewById(R.id.image17);
        baby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","BabyCare");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });

        packeditem = findViewById(R.id.image15);
        packeditem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","PackedItems");
                intent.putExtra("userName",usrname);
                startActivity(intent);
            }
        });
    }
}