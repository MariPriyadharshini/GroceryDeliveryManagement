package com.example.grocerydelivery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grocerydelivery.Models.Items;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Preferred extends AppCompatActivity {

    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference myref = mydb.getReference().child("PreferredCategory");
    ImageView wishlist,cart,dairy,baby,fruits,haircare,packeditem,biscuits,household,grains,staples,accesories,beverages,chocolates,hair,items ,maggie,oil,oralcare,snacks,spices,staple,tissue,vegetables,skincare;
    TextView dairyt,babyt,fruitst,haircaret,packeditemt,biscuitst,householdt,grainst,staplest,accesoriest,beveragest,chocolatest,hairt,itemst ,maggiet,oilt,oralcaret,snackst,spicest,staplet,tissuet,vegetablest,skincaret;
    ArrayList<String> name;
    Items item;
    String phno;
    Button bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferred);
        //name.size() = 0;
        name = new ArrayList<>();

        vegetables = findViewById(R.id.imageveg);
        vegetablest = findViewById(R.id.Veggies1);
        vegetables.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vegetables.setVisibility(View.INVISIBLE);
                vegetablest.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("Vegetables");
                }
            }
        });

        fruits = findViewById(R.id.imagefruit);
        fruitst = findViewById(R.id.fruits1);
        fruits.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fruits.setVisibility(View.INVISIBLE);
                fruitst.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("Fruits");
                }
            }
        });

        spices = findViewById(R.id.imagespices);
        spicest = findViewById(R.id.spices1);
        spices.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                spices.setVisibility(View.INVISIBLE);
                spicest.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("Spices");
                }
            }
        });

        oralcare = findViewById(R.id.imageoral);
        oralcaret = findViewById(R.id.oralcare1);
        oralcare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                oralcare.setVisibility(View.INVISIBLE);
                oralcaret.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("OralCare");
                }
            }
        });

        dairy = findViewById(R.id.imagedairy);
        dairyt = findViewById(R.id.dairy1);
        dairy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dairy.setVisibility(View.INVISIBLE);
                dairyt.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("DairyProduct");
                }
            }
        });

        chocolates = findViewById(R.id.imagechoco);
        chocolatest = findViewById(R.id.chocolates1);
        chocolates.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chocolates.setVisibility(View.INVISIBLE);
                chocolatest.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("Chocolates");
                }
            }
        });

        skincare = findViewById(R.id.imageskin);
        skincaret = findViewById(R.id.skincare1);
        skincare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                skincare.setVisibility(View.INVISIBLE);
                skincaret.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("SkinCare");
                }
            }
        });

        accesories = findViewById(R.id.imageaccess);
        accesoriest = findViewById(R.id.accessories1);
        accesories.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                accesories.setVisibility(View.INVISIBLE);
                accesoriest.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("Accessories");
                }
            }
        });

        oil = findViewById(R.id.imageoil);
        oilt = findViewById(R.id.oil1);
        oil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                oil.setVisibility(View.INVISIBLE);
                oilt.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("Oils");
                }
            }
        });

        snacks = findViewById(R.id.imagesnack);
        snackst = findViewById(R.id.snacks1);
        snacks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                snacks.setVisibility(View.INVISIBLE);
                snackst.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("Snacks");
                }
            }
        });

        grains = findViewById(R.id.imagegrains);
        grainst = findViewById(R.id.grains1);
        grains.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                grains.setVisibility(View.INVISIBLE);
                grainst.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("Grains");
                }
            }
        });

        staples = findViewById(R.id.imagestaple);
        staplest = findViewById(R.id.staples1);
        staples.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                staples.setVisibility(View.INVISIBLE);
                staplest.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("Staples");
                }
            }
        });

        biscuits = findViewById(R.id.imagebis);
        biscuitst = findViewById(R.id.biscuits1);
        biscuits.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                biscuits.setVisibility(View.INVISIBLE);
                biscuitst.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("Biscuits");
                }
            }
        });

        beverages = findViewById(R.id.imagebev);
        beveragest = findViewById(R.id.beverages1);
        beverages.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beverages.setVisibility(View.INVISIBLE);
                beveragest.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("Beverages");
                }
            }
        });

        household = findViewById(R.id.imagehouse);
        householdt = findViewById(R.id.household1);
        household.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                household.setVisibility(View.INVISIBLE);
                householdt.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("HouseHolds");
                }
            }
        });

        haircare = findViewById(R.id.imagehair);
        haircaret = findViewById(R.id.hair1);
        haircare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                haircare.setVisibility(View.INVISIBLE);
                haircaret.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("HairCare");
                }
            }
        });

        baby = findViewById(R.id.imagebaby);
        babyt = findViewById(R.id.baby1);
        baby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                baby.setVisibility(View.INVISIBLE);
                babyt.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("BabyCare");
                }
            }
        });

        packeditem = findViewById(R.id.imagepack);
        packeditemt = findViewById(R.id.maggie1);
        packeditem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                packeditem.setVisibility(View.INVISIBLE);
                packeditemt.setVisibility(View.INVISIBLE);
                if(name.size()<=5) {
                    name.add("PackedItems");
                }
            }
        });

        bt = (Button) findViewById(R.id.prefer);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = new Items();
                if(name.size()==5) {
                    item.setItem1(name.get(0));
                    item.setItem2(name.get(1));
                    item.setItem3(name.get(2));
                    item.setItem4(name.get(3));
                    item.setItem5(name.get(4));
                    phno = getIntent().getStringExtra("userName");
                    Log.d("}}}}}}}}}}}}}}",phno);
                    item.setUser_name(phno);
                    myref.child(phno).setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Preferred.this, "Inserted Successfully... :)", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Preferred.this, Signin.class);
                            //intent.putExtra("usrName",phno);
                            startActivity(intent);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Preferred.this, "Not Inserted... :(", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else {
                    DialogBox d = new DialogBox("Select only 5 category");
                    d.show(getSupportFragmentManager(),"Excess items choosed");
                    Intent intent = new Intent(Preferred.this, Preferred.class);
                    //intent.putExtra("usrName",phno);
                    startActivity(intent);
                }
            }
        });
    }
}
