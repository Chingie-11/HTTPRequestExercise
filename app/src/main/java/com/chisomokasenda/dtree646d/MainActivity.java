package com.chisomokasenda.dtree646d;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public final class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PeopleAdapter peopleAdapter;
    Button button;
    TextInputLayout inputText;
    String filter;

        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.setContentView(R.layout.activity_main);
                recyclerView = findViewById(R.id.peopleRecyclerView);
                button = findViewById(R.id.searchButton);
                inputText = findViewById(R.id.filter);



                recyclerView.setLayoutManager(new LinearLayoutManager(this));

                peopleAdapter = new PeopleAdapter();


            getAllPeople();

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    filter = inputText.getEditText().getText().toString().trim();
                    if (filter.isEmpty()) {
                        getAllPeople();
                    }
                    else
                    { getFilterPeople(filter);}
                }
            });
        }





        public void getAllPeople() {
            Call<List<Person>> call = new ExerciseServiceFactory().getService().getAllPeople();
            call.enqueue(new Callback<List<Person>>() {
                @Override
                public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {

                    if(response.isSuccessful()){
                        Log.e("Success", response.body().toString());
                        List<Person> allPeopleList = response.body();
                        peopleAdapter.setData(allPeopleList);
                        recyclerView.setAdapter(peopleAdapter);
                    } else {
                        Log.e("failed", "" + response.code());
                    }
                }

                @Override
                public void onFailure(Call<List<Person>> call, Throwable t) {
                    Log.e("Failure", t.getLocalizedMessage());
                }
            });
        }

        public void getFilterPeople(String filter) {
            Call<List<Person>> call = new ExerciseServiceFactory().getService().getFilterPeople("{\"CITY\":\"" + filter + "\"}");
            call.enqueue(new Callback<List<Person>>() {
                @Override
                public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {

                    if(response.isSuccessful()){
                        Log.e("Success", response.body().toString());
                        List<Person> allPeopleList = response.body();
                        peopleAdapter.setData(allPeopleList);
                        recyclerView.setAdapter(peopleAdapter);
                    } else {
                        Log.e("failed", "" + response.code());
                    }
                }

                @Override
                public void onFailure(Call<List<Person>> call, Throwable t) {
                    Log.e("Failure", t.getLocalizedMessage());
                }
            });
        }
    }


