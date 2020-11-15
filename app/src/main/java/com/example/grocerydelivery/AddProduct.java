package com.example.grocerydelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grocerydelivery.Models.Product;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;




public class AddProduct extends AppCompatActivity {
    Button product;
    EditText name,size,desc,count,price,catname,url;
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference myref = mydb.getReference().child("Categories");
    DatabaseReference myrefp = mydb.getReference("Products");
    Product prod;
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addproduct);
        name = (EditText) findViewById(R.id.productname);
        catname = (EditText) findViewById(R.id.categorynamefk);
        desc = (EditText) findViewById(R.id.productdesc);
        price = (EditText) findViewById(R.id.productcost);
        count = (EditText) findViewById(R.id.availablecount);
        size = (EditText) findViewById(R.id.size);
        url = (EditText) findViewById(R.id.producturl);
        prod = new Product();
        product = (Button) findViewById(R.id.submitproduct);
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateCategory()) {
                    addProduct();
                    Intent intent = new Intent(AddProduct.this,Admin.class);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean validateCategory() {
        String cat = catname.getText().toString().trim();
        if(!cat.isEmpty()) {
            Query chk = myref.orderByChild("category_name").equalTo(cat);
            chk.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String catdb = snapshot.child(cat).child("category_name").getValue(String.class);
                    if (!cat.equals(catdb)) {
                        catname.setError("Invalid Category Name");
                        flag = 1;
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    catname.setError("Invalid Category Name");
                    flag = 1;
                }
            });
        }
        else {
            catname.setError("Field can't be empty");
            return false;
        }
        if(flag == 1) {
            return false;
        }
        return true;
    }

    public void addProduct() {
        prod.setCategory_name(catname.getText().toString().trim());
        prod.setProd_name(name.getText().toString().trim());
        prod.setProd_desc(desc.getText().toString().trim());
        prod.setProd_price(price.getText().toString().trim());
        prod.setProd_size(size.getText().toString().trim());
        prod.setProd_avail_count(count.getText().toString().trim());
        prod.setProd_image(url.getText().toString().trim());
        String id = prod.getProd_name()+prod.getProd_desc()+prod.getProd_size();
        myrefp.child(id).setValue(prod).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(AddProduct.this, "Product Inserted Successfully..:)", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddProduct.this, "Product Not Inserted..:(",Toast.LENGTH_LONG).show();
            }
        });
    }
}

