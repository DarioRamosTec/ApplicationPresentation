package com.example.applicationpresentation.request;

import com.example.applicationpresentation.models.Character;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RickAndMortyRequest {

    @GET("character/{id}")
    Call<Character> getChara(@Path("id") String id);


}
