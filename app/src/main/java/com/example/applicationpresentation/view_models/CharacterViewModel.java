package com.example.applicationpresentation.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationpresentation.models.Character;
import com.example.applicationpresentation.repository.RickAndMortyRepository;

public class CharacterViewModel extends ViewModel {
    private MutableLiveData<Character> character;
    private RickAndMortyRepository rickAndMortyRepository;

    public LiveData<Character> getCharacter (String id) {
        if (character == null) {
            character = new MutableLiveData<>();
            loadCharacter(id);
        }
        return character;
    }

    private void loadCharacter (String id) {
        if (rickAndMortyRepository == null) {
            rickAndMortyRepository = new RickAndMortyRepository();
        }
        character = rickAndMortyRepository.getCharacter(id);
    }
}
