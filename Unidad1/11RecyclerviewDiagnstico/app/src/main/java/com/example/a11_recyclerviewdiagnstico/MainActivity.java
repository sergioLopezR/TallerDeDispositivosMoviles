package com.example.a11_recyclerviewdiagnstico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] nombreAlumno = {"Sergio Lopez",
            "Arleth Karina",
            "Erick Everaldo",
            "Emmanuel Salvador",
            "Guillermo Emilio",
            "Diego Armando",
            "Bryan Ivan"};
    String [] numControl = {"15400789", "15400770", "15400234", "15400567", "15400456", "15400987", "13200890"};
    String [] carrera = {"ITICS", "ITICS", "ITICS", "ITICS", "ITICS", "Ing. Civil", "Ing. Civil"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        adapter = new RecyclerAdapter(nombreAlumno, numControl, carrera, this);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);
    }
}
