package com.example.sqlite_product;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> {
    private Context context;
    private ArrayList code,description,price;


    CustomerAdapter(Context context,ArrayList code, ArrayList description, ArrayList price){
        this.context=context;
        this.code=code;
        this.description=description;
        this.price=price;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.product_code.setText(String.valueOf(code.get(position)));
        holder.product_description.setText(String.valueOf(description.get(position)));
        holder.product_price.setText(String.valueOf(price.get(position)));


    }

    @Override
    public int getItemCount() {
        return code.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView product_code,product_description,product_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            product_code= itemView.findViewById(R.id.product_code);
            product_description= itemView.findViewById(R.id.product_description);
            product_price= itemView.findViewById(R.id.product_price);
        }
    }
}
