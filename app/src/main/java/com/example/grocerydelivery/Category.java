package com.example.grocerydelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;

public class Category extends AppCompatActivity {
    TextView dairy,baby,fruits,haircare,packeditem,biscuits,household,grains,staples,accesories,beverages,chocolates,hair,items ,maggie,oil,oralcare,snacks,spices,staple,tissue,vegetables,skincare;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        vegetables = findViewById(R.id.Veggies);
        vegetables.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        fruits = findViewById(R.id.fruits);
        fruits.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        spices = findViewById(R.id.spices);
        spices.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        oralcare = findViewById(R.id.skincare);
        oralcare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        dairy = findViewById(R.id.dairy);
        dairy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        chocolates = findViewById(R.id.chocolates);
        chocolates.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        skincare = findViewById(R.id.skincare);
        skincare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        accesories = findViewById(R.id.accessories);
        accesories.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        oil = findViewById(R.id.oil);
        oil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        snacks = findViewById(R.id.snacks);
        snacks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        hair = findViewById(R.id.hair);
        hair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        snacks = findViewById(R.id.snacks);
        snacks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        grains = findViewById(R.id.grains);
        grains.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        staples = findViewById(R.id.staples);
        staples.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        snacks = findViewById(R.id.snacks);
        snacks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        biscuits = findViewById(R.id.biscuits);
        biscuits.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        beverages = findViewById(R.id.beverages);
        beverages.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        household = findViewById(R.id.household);
        household.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        haircare = findViewById(R.id.hair);
        haircare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        baby = findViewById(R.id.baby);
        baby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
        packeditem = findViewById(R.id.maggie);
        packeditem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, Recyclerview.class);
                startActivity(intent);
            }
        });
    }
}