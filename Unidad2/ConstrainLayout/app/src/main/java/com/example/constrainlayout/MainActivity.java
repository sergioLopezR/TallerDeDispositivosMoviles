package com.example.constrainlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button uno1, dos2, tres3, cuatro4, cinco5, seis6, siete7, ocho8, nueve9, cero0, sumar, restar, multiplicar, dividir, punto, igualito, limpiar;
    EditText proceso, concatenar;
    double numero1, numero2, resultado;
    String operador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uno1 = findViewById(R.id.uno);
        dos2 = findViewById(R.id.dos);
        tres3 = findViewById(R.id.tres);
        cuatro4 = findViewById(R.id.cuatro);
        cinco5 = findViewById(R.id.cinco);
        seis6 = findViewById(R.id.seis);
        siete7 = findViewById(R.id.siete);
        ocho8 = findViewById(R.id.ocho);
        nueve9 = findViewById(R.id.nueve);
        cero0 = findViewById(R.id.cero);
        punto = findViewById(R.id.punto);
        sumar = findViewById(R.id.suma);
        restar = findViewById(R.id.resta);
        dividir = findViewById(R.id.dividir);
        multiplicar = findViewById(R.id.multiplicar);
        proceso = (EditText) findViewById(R.id.edit);
        igualito = findViewById(R.id.igual);
        limpiar = findViewById(R.id.limpiar);

        cero0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatenar = (EditText) findViewById(R.id.edit);
                proceso.setText(concatenar.getText().toString() + "0");
            }
        });

        uno1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatenar = (EditText) findViewById(R.id.edit);
                proceso.setText(concatenar.getText().toString() + "1");
            }
        });

        dos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatenar = (EditText) findViewById(R.id.edit);
                proceso.setText(concatenar.getText().toString() + "2");
            }
        });

        tres3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatenar = (EditText) findViewById(R.id.edit);
                proceso.setText(concatenar.getText().toString() + "3");
            }
        });

        cuatro4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatenar = (EditText) findViewById(R.id.edit);
                proceso.setText(concatenar.getText().toString() + "4");
            }
        });

        cinco5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatenar = (EditText) findViewById(R.id.edit);
                proceso.setText(concatenar.getText().toString() + "5");
            }
        });

        seis6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatenar = (EditText) findViewById(R.id.edit);
                proceso.setText(concatenar.getText().toString() + "6");
            }
        });

        siete7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatenar = (EditText) findViewById(R.id.edit);
                proceso.setText(concatenar.getText().toString() + "7");
            }
        });

        ocho8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatenar = (EditText) findViewById(R.id.edit);
                proceso.setText(concatenar.getText().toString() + "8");
            }
        });


        nueve9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatenar = (EditText) findViewById(R.id.edit);
                proceso.setText(concatenar.getText().toString() + "9");
            }
        });

    igualito.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            concatenar = (EditText) findViewById(R.id.edit);
            numero2 = Double.parseDouble(concatenar.getText().toString());
            if(operador.equals("+"))
            {
                proceso.setText("");
                resultado = numero1 + numero2;
            }
            if(operador.equals("-"))
            {
                proceso.setText("");
                resultado = numero1 - numero2;
            }
            if(operador.equals("*"))
            {
                proceso.setText("");
                resultado = numero1 * numero2;
            }
            if(operador.equals("/"))
            {
                proceso.setText("");
                if(numero2 != 0)
                {
                resultado = numero1 / numero2;
                }
                else
                {
                    proceso.setText("Infinito");
                }
            }
            proceso.setText(String.valueOf(resultado));
        }
    });
    sumar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            operador = "+";
            concatenar = (EditText) findViewById(R.id.edit);
            numero1 = Double.parseDouble(concatenar.getText().toString());
            proceso.setText("");
        }
    });

    restar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            operador = "-";
            concatenar = (EditText) findViewById(R.id.edit);
            numero1 = Double.parseDouble(concatenar.getText().toString());
            proceso.setText("");
        }
    });

    multiplicar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            operador = "*";
            concatenar = (EditText) findViewById(R.id.edit);
            numero1 = Double.parseDouble(concatenar.getText().toString());
            proceso.setText("");
        }
    });

    dividir.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            operador = "*";
            concatenar = (EditText) findViewById(R.id.edit);
            numero1 = Double.parseDouble(concatenar.getText().toString());
            proceso.setText("");
        }
    });

    limpiar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            numero1 = 0;
            numero1 = 0;
            proceso.setText("");
        }
    });







    }
}
