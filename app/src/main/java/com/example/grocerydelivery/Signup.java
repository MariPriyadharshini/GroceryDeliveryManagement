package com.example.grocerydelivery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grocerydelivery.Models.Customers;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.Nullable;

public class  Signup extends AppCompatActivity {
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference myref = mydb.getReference("Customers");
    Customers c;
    int flag = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button signin, back;
        c = new Customers();
        signin = findViewById(R.id.signin);
        back = findViewById(R.id.back);
        EditText name, password, rpassword, phone, email, address;
        name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password1);
        rpassword = (EditText) findViewById(R.id.password2);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser(name, password, rpassword, phone, email, address);
                Intent intent = new Intent(Signup.this, Signin.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void createUser(EditText name, EditText password, EditText rpassword, EditText phone, EditText email, EditText address) {
        c.setName(name.getText().toString().trim());
        c.setEmailid(email.getText().toString().trim());
        c.setAddress(address.getText().toString().trim());
        c.setPhno(Integer.parseInt(phone.getText().toString().trim()));
        c.setPassword(password.getText().toString().trim());
        Log.d("The User Name is", c.name);
        if (c.password.equals(rpassword.getText().toString().trim())) {
            myref.child(c.emailid).setValue(c).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(Signup.this, "Inserted Successfully..:)", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Signup.this, "Not Inserted.. :(", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}