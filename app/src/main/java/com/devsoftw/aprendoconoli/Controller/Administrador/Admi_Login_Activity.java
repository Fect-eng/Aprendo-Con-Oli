package com.devsoftw.aprendoconoli.Controller.Administrador;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.devsoftw.aprendoconoli.Model.Select_Activity;
import com.devsoftw.aprendoconoli.R;
import com.devsoftw.aprendoconoli.View.Login_Colegio.Profe_DB.LoginProfe_DB_Activity;
import com.devsoftw.aprendoconoli.View.Login_Colegio.Student.Login_Basic_Activity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;

public class Admi_Login_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private TextInputEditText edt_AdminUsr;
    private TextInputEditText edt_admin_password;
    private Button BTN_IniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admi_login);

        edt_AdminUsr = findViewById(R.id.edt_AdminUsr);
        edt_admin_password = findViewById(R.id.edt_admin_password);

        /**
         * Barra Navegacion Inicial
         */
        // Configurar el Toolbar desde el layout XML
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(Color.parseColor("#1F5E6E")); //color general de app
        toolbar.setTitleTextColor(Color.WHITE); // Cambiar el color del texto del título a blanco
        getSupportActionBar().setTitle("Login Administrador");

        // Habilitar la flecha de navegación (opcional)
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define aquí la actividad a la que quieres navegar
                Intent intent = new Intent(Admi_Login_Activity.this, Select_Activity.class);
                startActivity(intent);
                // Si quieres que se cierre la actividad actual
                finish();
            }
        });

        BTN_IniciarSesion = findViewById(R.id.BTN_IniciarSesion);
        BTN_IniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Metodo_IniciarSesion();
            }
        });


    }

    private void Metodo_IniciarSesion() {

    }


    public void onBackPressed() {
        // Crear un Intent para redirigir a una actividad predeterminada
        super.onBackPressed();
        Intent intent = new Intent(this, Select_Activity.class); // Reemplaza con tu actividad destino
        startActivity(intent);
        // Opcional: Cierra la actividad actual
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.selection_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Item_Profesor) {
            Toast.makeText(this, "Opcion Profesor", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginProfe_DB_Activity.class); // Reemplaza con tu actividad destino
            startActivity(intent);

        } else if (id == R.id.Item_Alumno) {
            //para utilizar
            Toast.makeText(this, "Opcion Alumno", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Login_Basic_Activity.class); // Reemplaza con tu actividad destino
            startActivity(intent);
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}