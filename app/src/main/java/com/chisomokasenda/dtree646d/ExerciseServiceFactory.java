package com.chisomokasenda.dtree646d;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExerciseServiceFactory {
    private static ExerciseServiceFactory instance = null;
    private final ExerciseService exerciseService;
    private  synchronized ExerciseServiceFactory getInstance(){
        if (instance == null) {
            instance = new ExerciseServiceFactory();
        }
        return instance;
    }
    public ExerciseServiceFactory() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://exercise-646d.restdb.io/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).addInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        Response response = chain.proceed(chain.request());
                        return response.newBuilder()
                                .header("x-apikey", "5c5c7076f210985199db5488")
                                .build();
                    }
                }).build())
                .build();
        exerciseService = retrofit.create(ExerciseService.class);
    }

    public ExerciseService getService(){
        return exerciseService;
    }

}
