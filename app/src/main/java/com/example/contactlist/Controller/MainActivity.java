package com.example.contactlist.Controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.contactlist.Model.contact;
import com.example.contactlist.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView ;
    private ArrayList<contact> contacts = new ArrayList<>();
    private ListAdapter listAdapter;
    private Button Add;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);

        contacts.add(new contact("06-24156387","salma"));
        contacts.add(new contact("06-24156787","sara"));
        contacts.add(new contact("06-27156387","amina"));

        listAdapter = new ListAdapter(getApplicationContext(), contacts);
        listView.setAdapter(listAdapter);

        Add = findViewById(R.id.add);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContact();
            }
        });
        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    public void addContact(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final EditText phone = new EditText(this);
        phone.setHint("Phone ...");
        final EditText name = new EditText(this);
        name.setHint("Name ...");
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(phone);
        layout.addView(name);


        builder.setTitle("ADD CONTACT").setMessage("number").setView(phone).setMessage("add new contact")
                .setView(layout).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phoneContact = phone.getText().toString();
                String nameContact  = name.getText().toString();
                contacts.add(new contact(phoneContact,nameContact));
                listAdapter.notifyDataSetChanged();
            }
        }).create().show();
    }
}
