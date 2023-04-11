package com.example.sqlite_product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    product MyDB;
    ArrayList<String> code,description,price;

    CustomerAdapter customerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        MyDB = new product(MainActivity.this);
        code= new ArrayList<>();
        description= new ArrayList<>();
        price= new ArrayList<>();
        storeDataInArrays();
        customerAdapter = new CustomerAdapter(MainActivity.this,code,description,price);
        recyclerView.setAdapter(customerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }

    void storeDataInArrays(){
        Cursor cursor = MyDB.readAllData();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No Data",Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                code.add(cursor.getString(0));
                description.add(cursor.getString(1));
                price.add(cursor.getString(2));

            }
        }
    }
}