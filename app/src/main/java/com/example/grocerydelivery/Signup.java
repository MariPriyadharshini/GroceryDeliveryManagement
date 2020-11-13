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
    DatabaseReference myref = mydb.getReference().child("Customers");
    EditText name, password, rpassword, phone, email, address;
    Button signin, back;
    Customers c;
    int flag = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        c = new Customers();
        signin = findViewById(R.id.signin);
        back = findViewById(R.id.back);
        name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password1);
        rpassword = (EditText) findViewById(R.id.password2);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateName()&validatePassword()&validatePhone()&validateEmail()&validateAddress()) {
                    createUser(name, password, rpassword, phone, email, address);
                }
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

    public boolean validateName() {
        String nam = name.getText().toString().trim();
        if(nam.isEmpty()) {
            name.setError("Field Can't be Empty ");
            return false;
        }
        else {
            name.setError(null);
            return true;
        }
    }

    public boolean validateAddress() {
        String nam = address.getText().toString().trim();
        if(nam.isEmpty()) {
            address.setError("Field Can't be Empty ");
            return false;
        }
        else {
            address.setError(null);
            return true;
        }
    }

    public boolean validatePassword() {
        String nam = password.getText().toString().trim();
        String validation = "[a-zA-Z0-9]+[@#$%^&0-9]+[a-zA-Z0-9]+";
        if(nam.isEmpty()) {
            password.setError("Field Can't be Empty ");
            return false;
        }
        else if(!nam.matches(validation)) {
            password.setError("Invalid-Format");
            return false;
        }
        else {
            password.setError(null);
            return true;
        }
    }

    public boolean validatePhone() {
        String nam = phone.getText().toString().trim();
        String validation = "^[0-9]{10}";
        if(nam.isEmpty()) {
            phone.setError("Field Can't be Empty ");
            return false;
        }
        else if(!nam.matches(validation)) {
            phone.setError("Invalid-Format");
            return false;
        }
        else {
            phone.setError(null);
            return true;
        }
    }

    public boolean validateEmail() {
        String nam = email.getText().toString().trim();
        String validation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(nam.isEmpty()) {
            email.setError("Field Can't be Empty ");
            return false;
        }
        else if(!nam.matches(validation)) {
            email.setError("Invalid-Format");
            return false;
        }
        else {
            email.setError(null);
            return true;
        }
    }

    public void createUser(EditText name, EditText password, EditText rpassword, EditText phone, EditText email, EditText address) {
        c.setName(name.getText().toString().trim());
        c.setEmailid(email.getText().toString().trim());
        c.setAddress(address.getText().toString().trim());
        //int phn = Integer.parseInt(phone.getText().toString().trim());
        c.setPhno(phone.getText().toString().trim());
        c.setPassword(password.getText().toString().trim());
        Log.d("The User Name is", c.name);
        if (c.password.equals(rpassword.getText().toString().trim())) {
            myref.child(c.phno).setValue(c).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(Signup.this, "Inserted Successfully..:)", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Signup.this, Signin.class);
                    startActivity(intent);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Signup.this, "Not Inserted.. :(", Toast.LENGTH_LONG).show();
                }
            });
        }
        else {
            rpassword.setError("Field can't empty or Correct your password");
        }
    }
}