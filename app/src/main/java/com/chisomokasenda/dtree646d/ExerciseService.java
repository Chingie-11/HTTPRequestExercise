package com.chisomokasenda.dtree646d;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ExerciseService {
    @Headers({"x-apikey: 5c5c7076f210985199db5488"})
    @GET("group-1")
    Call<List<Person>>getAllPeople();

    @Headers({"x-apikey: 5c5c7076f210985199db5488"})
    @GET("group-1")
    Call<List<Person>>getFilterPeople(@Query("q") String filter);

}
