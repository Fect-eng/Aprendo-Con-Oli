package com.devsoftw.aprendoconoli.Model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.devsoftw.aprendoconoli.MainActivity;
import com.devsoftw.aprendoconoli.View.Login_Colegio.Profe_DB.LoginProfe_DB_Activity;
import com.devsoftw.aprendoconoli.View.Login_Colegio.Student.Login_Basic_Activity;
import com.devsoftw.aprendoconoli.R;
import com.devsoftw.aprendoconoli.View.Login_Colegio.Profesor.Profesor_Colegio;

public class Select_Activity extends AppCompatActivity {

    private ImageView ImageviewLog_Profesor;
    private Button Btn_Profesor;
    private ImageView ImageviewLog_Alumno;
    private Button Btn_Alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageviewLog_Profesor= findViewById(R.id.ImageviewLog_Profesor);
        Btn_Profesor = findViewById(R.id.Btn_Profesor);
        ImageviewLog_Alumno = findViewById(R.id.ImageviewLog_Alumno);
        Btn_Alumno = findViewById(R.id.Btn_Alumno);
        
        ImageviewLog_Profesor. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageviewLog_Profesor_Metodo();
            }
        });

        Btn_Profesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Btn_Profesor_Metodo();
            }
        });

        ImageviewLog_Alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageviewLog_Alumno_Metodo();
            }
        });

        Btn_Alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Btn_Alumno_Metodo();
            }
        });
    }
    
    /**
     * Metodos De ImageView y Button
     * // TODO: 9/10/2024 Realizar cambios respectivos
     */

    private void ImageviewLog_Profesor_Metodo() {
        Intent intent = new Intent(Select_Activity.this, LoginProfe_DB_Activity.class);
        Toast.makeText(this, "Bienvenido Profesor", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }

    private void Btn_Profesor_Metodo() {
        Intent intent = new Intent(Select_Activity.this, LoginProfe_DB_Activity.class);
        Toast.makeText(this, "Bienvenido Profesor", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }

    private void ImageviewLog_Alumno_Metodo() {
        Intent intent = new Intent(Select_Activity.this, Login_Basic_Activity.class);   // Login_Student
        Toast.makeText(this, "Bienvenido Estudiante", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }

    private void Btn_Alumno_Metodo() {
        Intent intent = new Intent(Select_Activity.this, Login_Basic_Activity.class);
        Toast.makeText(this, "Bienvenido Estudiante", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }


          public void onBackPressed() {
              // Crear un Intent para redirigir a una actividad predeterminada
              super.onBackPressed();
              Intent intent = new Intent(this, MainActivity.class); // Reemplaza con tu actividad destino
              startActivity(intent);
              // Opcional: Cierra la actividad actual
              finish();
          }

}