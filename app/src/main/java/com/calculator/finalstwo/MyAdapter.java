package com.calculator.finalstwo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String[] data1, data2;
    Context ct;
    int[] images;
    public MyAdapter(Context ct, String[] data1, String[] data2, int[] images) {
        this.ct = ct;
        this.data1 = data1;
        this.data2 = data2;
        this.images = images;
    }



    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.rows, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.MyViewHolder holder, int position) {
        holder.txtTitle.setText(data1[position]);


        holder.txtDescription.setText("description");

        holder.imgImage.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ct,  Content.class);
                intent.putExtra("title", data1[position]);
                intent.putExtra("desc", data2[position]);
                intent.putExtra("imgImage", images[position]);
                ct.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtDescription;
        ImageView imgImage;
        ConstraintLayout mainLayout;
        public MyViewHolder(View view) {
            super(view);

            txtTitle = view.findViewById(R.id.txtTitle);
            txtDescription = view.findViewById(R.id.txtDescription);
            imgImage = view.findViewById(R.id.imgImage);
            mainLayout = view.findViewById(R.id.mainLayout);


        }
    }
}
