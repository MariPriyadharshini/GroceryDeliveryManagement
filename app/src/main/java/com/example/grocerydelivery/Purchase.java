package com.example.grocerydelivery;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grocerydelivery.Models.Order;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Purchase extends AppCompatActivity {
    EditText address,quantity;
    TextView cost,product;
    Order order;
    Button place,back;
    String usrname;
    String cartkey;
    String productkey;
    String addressdb;
    SimpleDateFormat dateFormat;
    Calendar calendar;
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference myref = mydb.getReference("Orders");
    DatabaseReference rref = mydb.getReference("Products");
    DatabaseReference uref = mydb.getReference("Customers");
    int total_cost,quant,prod_count;;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase);
        usrname = getIntent().getStringExtra("userName");
        cartkey = getIntent().getStringExtra("cartKey");
        productkey = getIntent().getStringExtra("prodKey");
        address = (EditText) findViewById(R.id.paddr);
        quantity = (EditText) findViewById(R.id.pquant);
        cost = (TextView) findViewById(R.id.pcost);
        product = (TextView) findViewById(R.id.pproduct);
        place = (Button) findViewById(R.id.place);
        back = (Button) findViewById(R.id.pback);
        order = new Order();

        setAddress();

        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateAddress() && validateQuantity()) {
                    placeOrder();
                }
            }
        });
    }

    public void setAddress() {
       // Log.d("{{{{{{{{{{{{{{{{{{{{{{{",usrname);
        Query chk = uref.orderByChild("phno").equalTo(usrname);
        chk.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    addressdb = snapshot.child(usrname).child("address").getValue().toString();
                    address.setText(addressdb);
                    //Log.d("?????????????????????",addressdb);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

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

    public boolean validateQuantity() {
        String nam = quantity.getText().toString().trim();
        quant = Integer.parseInt(quantity.getText().toString().trim());
        if(nam.isEmpty()) {
            quantity.setError("Field Can't be Empty ");
            return false;
        }
        else {
            quantity.setError(null);
            return true;
        }
    }

    public void placeOrder() {
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MMM -dd-yyy");
        order.setDate(dateFormat.format(calendar.getTime()));
        order.setDelivery_address(address.getText().toString().trim());
        order.setQuantity(quantity.getText().toString().trim());
        order.setProduct_key(productkey);
        order.setUser_name(usrname);
        String key = order.user_name+order.product_key+order.quantity;
        order.setOrder_key(key);

        Query prod_chk = rref.orderByChild("key").equalTo(productkey);
        prod_chk.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    for(DataSnapshot schild: snapshot.getChildren()) {
                        if(schild.child("prod_avail_count").getValue(String.class) != null) {
                            Toast.makeText(Purchase.this,"Inside product",Toast.LENGTH_LONG).show();
                            prod_count = Integer.parseInt(schild.child("prod_avail_count").getValue(String.class));
                            total_cost = quant*Integer.parseInt(schild.child("prod_price").getValue().toString());
                            Log.d("<<<<<<<<<<<<<<<<",String.valueOf(total_cost));
                            order.setCost(String.valueOf(total_cost));
                            cost.setText("Rs."+order.cost);
                            product.setText(schild.child("prod_name").getValue().toString());
                            prod_count -= quant;
                            //Log.d("^^^^^^^^^^^^^^^^^^^",String.valueOf(prod_count));
                            if(prod_count == 0)
                                schild.getRef().child("prod_avail_count").setValue(null);
                            else
                                schild.getRef().child("prod_avail_count").setValue(String.valueOf(prod_count));
                        }
                        else {
                            DialogBox d = new DialogBox("Ou tof Stock");
                            d.show(getSupportFragmentManager(),"outOfStock");
                        }
                    }
                    order.setStatus(null);

                    myref.child(order.order_key).setValue(order).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            DialogBox d = new DialogBox("Order Placed Successfully");
                            d.show(getSupportFragmentManager(),"Placed");
                            Toast.makeText(Purchase.this,"Order Placed Sucessfully",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
