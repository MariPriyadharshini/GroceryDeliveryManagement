package com.example.grocerydelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grocerydelivery.Models.Category;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AddCategory extends AppCompatActivity {
    Button category;
    EditText name,url;
    int chk_flag;
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference myref = mydb.getReference().child("Categories");
    //DatabaseReference myrefp = mydb.getReference("Products");
    Category categ;
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcategory);
        name = (EditText) findViewById(R.id.category_name);
        url = (EditText) findViewById(R.id.category_url);
        categ = new Category();
        category = (Button) findViewById(R.id.submit_category);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateCategory()&validateUrl()) {
                    addCategory();
                    Intent intent = new Intent(AddCategory.this,Admin.class);
                    startActivity(intent);
                }
            }
        });
    }

    // To check URL is empty or not.

    public boolean validateUrl() {
        String surl = url.getText().toString().trim();
        if(surl.isEmpty()) {
            url.setError("Field Can't be Empty ");
            return false;
        }
        else {
            url.setError(null);
            return true;
        }
    }

    // To check Categoryname is empty or not.

    public boolean validateCategory() {
        String cat = name.getText().toString().trim();
        if(cat.isEmpty()) {
            name.setError("Field Can't be Empty ");
            return false;
        }
        else {
            name.setError(null);
            return true;
        }
    }

    // TO check whether category is already available in list.

    public boolean checkAvailable() {
        Query chk = myref.orderByChild("category_name");
        chk.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    chk_flag = 1;
                }
                else {
                    chk_flag = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        if(chk_flag == 1) {
            return true;
        }
        else {
            return false;
        }
    }
    public void addCategory() {
        categ.setCategory_name(name.getText().toString().trim());
        categ.setCategory_url(url.getText().toString().trim());
        if(!checkAvailable()) {
            myref.child(categ.getCategory_name()).setValue(categ).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(AddCategory.this, "Category Inserted Successfully..:)", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    DialogBox dialog = new DialogBox("Error");
                    dialog.show(getSupportFragmentManager(),"DialogError");
                    Toast.makeText(AddCategory.this, "Category Not Inserted..:(", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}


