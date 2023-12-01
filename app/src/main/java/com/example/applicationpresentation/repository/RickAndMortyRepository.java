package com.example.applicationpresentation.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.applicationpresentation.models.Character;
import com.example.applicationpresentation.request.RickAndMortyRequest;
import com.example.applicationpresentation.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RickAndMortyRepository {
    public Retrofit retrofit;
    void setRetrofit() {
        retrofit = RetrofitRequest.getRetrofit();
    }

    public MutableLiveData<Character> getCharacter(String id) {
        setRetrofit();
        RickAndMortyRequest rickAndMortyRequest = retrofit.create(RickAndMortyRequest.class);
        Call<Character> characterCall = rickAndMortyRequest.getChara(id);
        MutableLiveData<Character> mutableLiveData = new MutableLiveData<>();

        characterCall.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                if (response.isSuccessful()) {
                    Character chara = response.body();
                    mutableLiveData.setValue(chara);
                }
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }

}
