package com.chisomokasenda.dtree646d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleAdapterVH> {
    private List<Person> allPeopleList;
    private Context context;

    public PeopleAdapter() {
    }

    public void setData(List<Person> allPeopleList) {
        this.allPeopleList = allPeopleList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PeopleAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       context = parent.getContext();
        return new PeopleAdapter.PeopleAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_people, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleAdapterVH holder, int position) {
        Person person = allPeopleList.get(position);
        String name = person.getName();
        String surname = person.getSurname();
        String age = person.getAge().toString();
        String Id = person.getId().toString();
        String city = person.getCity();
        String parentId = person.getParentid();


        holder.name.setText(name);
        holder.id.setText(Id);
        holder.age.setText(age);
        holder.surname.setText(surname);
        holder.city.setText(city);
        holder.parentId.setText(parentId);

    }

    @Override
    public int getItemCount() {
        return allPeopleList.size();
    }

    public class  PeopleAdapterVH extends RecyclerView.ViewHolder {

        TextView name , surname, age, city,id, parentId;


        public PeopleAdapterVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.firstName);
            surname = itemView.findViewById(R.id.lastName);
            age = itemView.findViewById(R.id.age);
            city = itemView.findViewById(R.id.city);
            id = itemView.findViewById(R.id.id);
            parentId = itemView.findViewById(R.id.parentId);
        }
    }
}
