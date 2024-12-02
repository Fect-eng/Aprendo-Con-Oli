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
import com.devsoftw.aprendoconoli.Pruebas.PDF_Crud.ExportPDF_Activity;
import com.devsoftw.aprendoconoli.View.Examen.Examen_Activity;
import com.devsoftw.aprendoconoli.View.Login_Colegio.Profe_DB.LoginProfe_DB_Activity;
import com.devsoftw.aprendoconoli.View.Login_Colegio.Profesor.Profesor_Colegio;
import com.devsoftw.aprendoconoli.View.Login_Colegio.Student.Login_Basic_Activity;
import com.devsoftw.aprendoconoli.View.Opt_Nav_Profesor.Contenedor_Profe1_Activity;
import com.devsoftw.aprendoconoli.View.Opt_Nav_Profesor.Contenedor_imgProfe_Activity;
import com.devsoftw.aprendoconoli.View.Registro.Registrar_Activity;

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

                imageView.setVisibility(View.INVISIBLE); // Ocultar la imagen    Select_Activity    === Vertical_Activity
                txtAprendo.setVisibility(View.INVISIBLE);    // PDF_Interaction_Activity      // Select_Activity
                Intent intent = new Intent(MainActivity.this, Login_Basic_Activity.class);
                //Select_Activity    --- Principal
                //Contenedor_imgProfe_Activity
                //Login_Basic_Activity
                startActivity(intent);
                finish();
                // Finalizar el MainActivity para que no se pueda volver atrás, es para las opciones de flecha de 3 opciones
            }
        }.start();

    }

}