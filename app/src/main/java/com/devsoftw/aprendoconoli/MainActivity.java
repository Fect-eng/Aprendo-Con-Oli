package com.devsoftw.aprendoconoli;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.devsoftw.aprendoconoli.Model.Select_Activity;
import com.devsoftw.aprendoconoli.View.Opt_Nav_Alumno.Cont_Alumno1_Activity;
import com.devsoftw.aprendoconoli.View.Opt_Nav_Profesor.Contenedor_Profe1_Activity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView txtAprendo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // TODO: 5/10/2024
        imageView = findViewById(R.id.imageView);
        imageView.setVisibility(View.VISIBLE);
        txtAprendo = findViewById(R.id.txtAprendo);

        // Hacer visible la imagen

        new CountDownTimer(2000, 3000) {
            public void onTick(long millisUntilFinished) {
                // No hacer nada en cada tick
            }

            public void onFinish() {

                imageView.setVisibility(View.INVISIBLE); // Ocultar la imagen
                txtAprendo.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(MainActivity.this, Select_Activity.class);
                startActivity(intent);
                finish();
                // Finalizar el MainActivity para que no se pueda volver atrás, es para las opciones de flecha de 3 opciones
            }
        }.start();

    }

}