package com.example.grocerydelivery;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Recyclerview extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] s1;
    String[] s2;
    String d= "diaper";
    int[] images = {R.drawable.diaper, R.drawable.oil,R.drawable.biscuits,R.drawable.accesories};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        recyclerView = findViewById(R.id.my_recycler_view);
        s1 = getResources().getStringArray(R.array.itemname);
        s2 = getResources().getStringArray(R.array.itemdescription);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(this,s1,s2,images);
        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}

