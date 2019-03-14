package com.example.a26proyectobdu2_30;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ConexionSQLiteHelper con;

    ArrayList<Cliente> listaClientes;

    RecyclerView listaObjetos;
    private RecyclerView.LayoutManager mLayaotManager;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        con = new ConexionSQLiteHelper(MainActivity.this);
        init();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pantalla = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(pantalla);
            }
        });
    }

    private void init() {
        listaObjetos= findViewById(R.id.carview);
        listaObjetos.setLayoutManager(new LinearLayoutManager(this));
        listaClientes=new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        con.openDB();
        listardatos();
    }

    @Override
    protected void onStop() {
        super.onStop();
        con.closeDB();
    }

    private void listardatos() {
        try {

            listaClientes = new ArrayList<>();
            Cursor cursor = con.getAll();

            for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                listaClientes.add(new Cliente(cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
            }
            if (!listaClientes.isEmpty()){
                Toast.makeText(getApplicationContext(), "Lista de Clientes cargada correctamente", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), "No hay ningun registro de clientes", Toast.LENGTH_LONG).show();
            }
            adaptador = new Adaptador(listaClientes, getApplicationContext());
            listaObjetos.setAdapter(adaptador);


        }catch (SQLException e) {

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
