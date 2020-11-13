package com.example.grocerydelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.Nullable;

public class Signin extends AppCompatActivity {
    EditText password, phone;
    Button signin,back;
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference myref = mydb.getReference("LoginDetails");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        signin = findViewById(R.id.signin);
        back = findViewById(R.id.back);
        password = (EditText) findViewById(R.id.password);
        phone = (EditText) findViewById(R.id.phonenumber);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validatePassword()&validatePhone()) {
                    checkUSer();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean validatePassword() {
        String nam = password.getText().toString().trim();
        if(nam.isEmpty()) {
            password.setError("Field Can't be Empty ");
            return false;
        }
        else {
            password.setError(null);
            return true;
        }
    }

    public boolean validatePhone() {
        String nam = phone.getText().toString().trim();
        if(nam.isEmpty()) {
            phone.setError("Field Can't be Empty ");
            return false;
        }
        else {
            phone.setError(null);
            return true;
        }
    }

    public void checkUSer() {
        String phn = phone.getText().toString().trim();
        String pass = password.getText().toString().trim();
        Query chk = myref.orderByChild("phno").equalTo(phn);
        chk.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    phone.setError(null);
                    phone.setEnabled(false);
                    String pwd = snapshot.child(phn).child("password").getValue(String.class);
                    if (phn.equals("9003421214")) {
                        if (pwd.equals(pass)) {
                            Toast.makeText(Signin.this, "Logged Successfully", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Signin.this, Admin.class);
                            startActivity(intent);
                        } else {
                            password.setError("Wrong Password Admin");
                        }
                    }
                    else{
                        if (pwd.equals(pass)) {
                            Toast.makeText(Signin.this, "Logged Successfully", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Signin.this, Category.class);
                            startActivity(intent);
                        } else {
                            password.setError("Wrong Password");
                        }
                    }
                }
                else {
                    phone.setError("User Doesn't Exists");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
