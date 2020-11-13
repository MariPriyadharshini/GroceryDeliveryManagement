package com.example.grocerydelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {
    Button product, category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        product = (Button) findViewById(R.id.product);
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this,AddProduct.class);
                startActivity(intent);
            }
        });
        category = (Button) findViewById(R.id.category);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this,AddCategory.class);
                startActivity(intent);
            }
        });
    }
}
