package com.example.grocerydelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;

public class Category extends AppCompatActivity {
    ImageView dairy,baby,fruits,haircare,packeditem,biscuits,household,grains,staples,accesories,beverages,chocolates,hair,items ,maggie,oil,oralcare,snacks,spices,staple,tissue,vegetables,skincare;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        vegetables = findViewById(R.id.image4);
        vegetables.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Vegetables");
                startActivity(intent);
            }
        });

        fruits = findViewById(R.id.image5);
        fruits.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Fruits");
                startActivity(intent);
            }
        });

        spices = findViewById(R.id.image6);
        spices.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Spices");
                startActivity(intent);
            }
        });

        oralcare = findViewById(R.id.image7);
        oralcare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","OralCare");
                startActivity(intent);
            }
        });

        dairy = findViewById(R.id.image8);
        dairy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","DairyProduct");
                startActivity(intent);
            }
        });

        chocolates = findViewById(R.id.image9);
        chocolates.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Chocolates");
                startActivity(intent);
            }
        });

        skincare = findViewById(R.id.image18);
        skincare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","SkinCare");
                startActivity(intent);
            }
        });

        accesories = findViewById(R.id.image11);
        accesories.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Accessories");
                startActivity(intent);
            }
        });

        oil = findViewById(R.id.image10);
        oil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Oil");
                startActivity(intent);
            }
        });

        snacks = findViewById(R.id.image2);
        snacks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Snacks");
                startActivity(intent);
            }
        });

        grains = findViewById(R.id.image1);
        grains.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Grains");
                startActivity(intent);
            }
        });

        staples = findViewById(R.id.image3);
        staples.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Staples");
                startActivity(intent);
            }
        });

        biscuits = findViewById(R.id.image12);
        biscuits.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Biscuits");
                startActivity(intent);
            }
        });

        beverages = findViewById(R.id.image13);
        beverages.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","Beverages");
                startActivity(intent);
            }
        });

        household = findViewById(R.id.image14);
        household.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","HouseHoldsItems");
                startActivity(intent);
            }
        });

        haircare = findViewById(R.id.image16);
        haircare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","HairCare");
                startActivity(intent);
            }
        });

        baby = findViewById(R.id.image17);
        baby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","BabyCare");
                startActivity(intent);
            }
        });

        packeditem = findViewById(R.id.image15);
        packeditem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                intent.putExtra("categoryName","PackedItems");
                startActivity(intent);
            }
        });
    }
}