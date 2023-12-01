package com.example.applicationpresentation.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.applicationpresentation.R;
import com.example.applicationpresentation.models.Character;
import com.example.applicationpresentation.view_models.CharacterViewModel;

public class RIckAndMortyActivity extends AppCompatActivity {

      TextView textName;
      TextView textSpecies;
      TextView textGender;
      TextView textStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rick_and_morty);

        textName = findViewById(R.id.textName);
        textSpecies = findViewById(R.id.textSpecies);
        textGender = findViewById(R.id.textGender);
        textStatus = findViewById(R.id.textStatus);

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        CharacterViewModel characterViewModel = viewModelProvider.get(CharacterViewModel.class);
        characterViewModel.getCharacter("3").observe(this, new Observer<Character>() {
            @Override
            public void onChanged(Character character) {
                textName.setText(character.name);
                textSpecies.setText(character.species);
                textGender.setText(character.gender);
                textStatus.setText(character.status);
            }
        });

    }

}