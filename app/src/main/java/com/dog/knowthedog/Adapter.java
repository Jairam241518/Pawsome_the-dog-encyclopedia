package com.dog.knowthedog;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> breedList;
    private Activity activity;

    public Adapter(Activity activity, List<ModelClass> breedList){ this.breedList = breedList; this.activity = activity; }




    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        ModelClass modelClass = breedList.get(position);
        holder.name.setText(modelClass.getTextview());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity.getApplicationContext(), detailsOfBreed.class);
                intent.putExtra("breed_group", modelClass.getBreed_group());
                intent.putExtra("life_span", modelClass.getLife_span());
                intent.putExtra("name", modelClass.getTextview());
                intent.putExtra("origin", modelClass.getOrigin());
                intent.putExtra("temperament", modelClass.getTemperament());
                activity.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return breedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        private ImageView imageView;
        private TextView name;
        private RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            name = itemView.findViewById(R.id.textview);
            relativeLayout = itemView.findViewById(R.id.relativeLayout1);


        }

        public void setData(int resource, String name1) {
            imageView.setImageResource(resource);
            name.setText(name1);
        }



    }



}
