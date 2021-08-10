package com.dog.knowthedog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;




import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {


    RecyclerView recyclerView;
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    List<ModelClass>breedList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thedogapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface apiInterface = retrofit.create(com.dog.knowthedog.apiInterface.class);
        Call<List<ModelClass>> dogInput = apiInterface.inputDogs();
        dogInput.enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this,response.code(),Toast.LENGTH_SHORT).show();
                }
                List<ModelClass> breedList = response.body();
                Adapter adapter = new Adapter(MainActivity.this,breedList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                return;

            }
        });





    }


}