package com.example.activiad7_2_aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;

import com.example.activiad7_2_aleatorio.databinding.ActivityPopupBinding;

public class Popup extends AppCompatActivity {
private ActivityPopupBinding binding1;
private int numero;
private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new CountDownTimer(1500, 1500) {

            @Override
            public void onTick(long millisUntilFinished) {
                binding1 = ActivityPopupBinding.inflate(getLayoutInflater());
                setContentView(binding1.getRoot());

                DisplayMetrics medidas = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(medidas);

                int ancho = medidas.widthPixels;
                int alto = medidas.heightPixels;

                getWindow().setLayout((int) (ancho * 0.85), (int) (alto * 0.5));

                numero = (int) (Math.random() * 100001);
                name = String.valueOf(numero);
                binding1.txtNumero.setText(name);


            }

            @Override
            public void onFinish() {
                Intent enviar = new Intent(getApplicationContext(), MainActivity.class);
                enviar.putExtra("name", name);
                startActivity(enviar);

            }
        }.start();
    }
}