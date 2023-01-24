package com.example.activiad7_2_aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import com.example.activiad7_2_aleatorio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(MainActivity.this,Popup.class));
            }
        });

        binding.btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String num = extras.getString("name");
                if(binding.txtRespuesta.getText().toString().equals(num)){
                    Toast.makeText(MainActivity.this, "Que buena memoria!!", Toast.LENGTH_SHORT).show();

                }else Toast.makeText(MainActivity.this, "Más atento para la otra", Toast.LENGTH_SHORT).show();

            }
        });
    }
}