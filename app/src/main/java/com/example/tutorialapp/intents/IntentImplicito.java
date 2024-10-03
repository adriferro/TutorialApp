package com.example.tutorialapp.intents;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tutorialapp.R;

public class IntentImplicito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_implicito);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textViewComida = findViewById(R.id.mostrarComida);
        TextView textViewBebida = findViewById(R.id.mostrarBebida);

        // Recover data
        Bundle extras = getIntent().getExtras();

        String textoPrueba = extras.getString("prueba");
        Log.d("PRUEBA", textoPrueba);

        String txtComida = extras.getString("comida");
        String txtBebida = extras.getString("bebida");

        textViewComida.setText(txtComida);
        textViewBebida.setText(txtBebida);

    }
}