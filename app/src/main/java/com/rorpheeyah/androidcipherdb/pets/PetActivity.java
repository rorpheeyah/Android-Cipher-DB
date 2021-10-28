package com.rorpheeyah.androidcipherdb.pets;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

import com.rorpheeyah.androidcipherdb.databinding.ActivityPetBinding;

import java.util.ArrayList;

public class PetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPetBinding binding = ActivityPetBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet(1, "Chakriya", false, 100, 1000, "Crazy", "https://images.indianexpress.com/2021/04/puppy-1903313_1280.jpg"));
        pets.add(new Pet(1, "Analog", true, 100, 1000, "Crazy", "https://api.cchatty.com/api/img/5200-Biya-1610287419"));
        pets.add(new Pet(1, "Asian Boii", false, 100, 1000, "Crazy", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8kO16MCkatZN6Sn3fSiYyAV0Re9qVER9xEFpzWvVjsWWg3s1FAF2wDomKSfCkFSeZXQA&usqp=CAU"));
        pets.add(new Pet(1, "ZING ZING !!!", true, 100, 1000, "Crazy", "https://ichef.bbci.co.uk/news/976/cpsprodpb/15C95/production/_120373298_gettyimages-1300362661.jpg"));

        PetAdapter adapter = new PetAdapter();
        adapter.setPets(pets);

        binding.rcvPet.setAdapter(adapter);
    }
}