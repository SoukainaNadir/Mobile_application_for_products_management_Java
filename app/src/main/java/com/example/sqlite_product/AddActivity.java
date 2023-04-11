package com.example.sqlite_product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText code, descrp,price;
    Button add_button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        code = findViewById(R.id.code);
        descrp = findViewById(R.id.descrp);
        price = findViewById(R.id.price);
        add_button1 = findViewById(R.id.add_button1);
        add_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product myDB = new product(AddActivity.this);
                myDB.addProduct(Integer.valueOf(code.getText().toString().trim()),
                        descrp.getText().toString().trim(),
                        price.getText().toString().trim())
                        ;

            }
        });

    }
}