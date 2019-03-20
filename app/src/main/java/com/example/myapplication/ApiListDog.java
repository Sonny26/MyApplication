package com.example.myapplication;


import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiListDog {
    //On définit notre interface
    //Avec une méthod getListDog() qui retourne un objet
    //Call<RestDogResponse>
    @GET("dog")
    Call<RestDogResponse> getListDog();

//    @GET("/abilities")
//    Call<RestDogResponse> getListAbilities();
}
