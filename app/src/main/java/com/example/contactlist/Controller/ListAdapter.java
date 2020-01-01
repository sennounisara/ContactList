package com.example.contactlist.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.contactlist.Model.contact;
import com.example.contactlist.R;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<contact> {

    private TextView name;
    private TextView phone;
    private ImageView delete;
    private ArrayList<contact> contacts;

    public ListAdapter(@NonNull Context context, @NonNull ArrayList<contact> objects) {
        super(context, 0, objects);
        contacts = (ArrayList) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        contact contacte = (contact) getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_contact,parent,false);
        }

        phone  = convertView.findViewById(R.id.phone);
        name   = convertView.findViewById(R.id.name);
        delete = convertView.findViewById(R.id.delete);

        phone.setText(contacte.getPhone());
        name.setText(contacte.getName());

        deleteItem(delete,contacte);

        return  convertView;
    }

    public void deleteItem(ImageView imageView,final contact contacte){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(contacte);
                notifyDataSetChanged();
            }
        });
    }
}
