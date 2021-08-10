package com.dog.knowthedog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class detailsOfBreed extends AppCompatActivity {

    private TextView breedGroup;
    private TextView lifeSpan;
    private String breedGroup1;
    private String lifeSpan1;
    private TextView nameOfDog;
    private String nameOfDog1;
    private String originName;
    private TextView originName1;
    private String temperamentName;
    private TextView temperamentName1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_breed);

        breedGroup = findViewById(R.id.breedGroup);
        lifeSpan = findViewById(R.id.lifeSpan);
        nameOfDog = findViewById(R.id.nameOfDog);
        originName1 = findViewById(R.id.origin);
        temperamentName1 = findViewById(R.id.temperament);
        getBreedGroupData();
        displayBreedGroupData();
        getLifeSpanData();
        displayLifeSpanData();
        getNameData();
        displayNameData();
        getOrigin();
        displayOrigin();
    }

    private void getBreedGroupData(){
        if (getIntent().hasExtra("breed_group")){
            breedGroup1 = getIntent().getStringExtra("breed_group");
        }
    }
    private void displayBreedGroupData(){
        breedGroup.setText(breedGroup1);
    }
    private void getLifeSpanData(){
        if (getIntent().hasExtra("life_span")){
            lifeSpan1 = getIntent().getStringExtra("life_span");
        }
    }
    private void displayLifeSpanData(){
        lifeSpan.setText(lifeSpan1);
    }
    private void getNameData(){
        if (getIntent().hasExtra("name")){
            nameOfDog1 = getIntent().getStringExtra("name");
        }
    }
    private void displayNameData(){
        nameOfDog.setText(nameOfDog1);
    }

    private void getOrigin(){
        if (getIntent().hasExtra("origin")){
            originName = getIntent().getStringExtra("origin");
        }

    }

    private void displayOrigin(){
        originName1.setText(originName);
    }

    private void getTemperament(){
        if (getIntent().hasExtra("temperament")){
            temperamentName = getIntent().getStringExtra("temperament");
        }
    }
    private void displayTemperament(){
        temperamentName1.setText(temperamentName);
    }

}