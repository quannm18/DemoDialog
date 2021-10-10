package com.example.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edDialog;
    private Button button;
    private FloatingActionButton fab;
    private Spinner spnMain;
    private AlertDialog alertDialog;
    private ArrayAdapter<String> adapter;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        spnMain = (Spinner) findViewById(R.id.spnMain);
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("Number "+i);
        }

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,list);
        spnMain.setAdapter(adapter);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getSpn = spnMain.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), ""+getSpn, Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog,null);

                edDialog = (EditText) view.findViewById(R.id.edDialog);
                button = (Button) view.findViewById(R.id.button);

                builder.setView(view);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = edDialog.getText().toString();
                        Toast.makeText(getApplicationContext(), "Hello "+edDialog.getText().toString()+" !", Toast.LENGTH_SHORT).show();

                    }
                });
                alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}