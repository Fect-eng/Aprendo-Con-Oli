package com.devsoftw.aprendoconoli.View.Login_Colegio.Student;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.devsoftw.aprendoconoli.MainActivity;
import com.devsoftw.aprendoconoli.Model.Select_Activity;
import com.devsoftw.aprendoconoli.R;
import com.devsoftw.aprendoconoli.View.Opt_Nav_Alumno.Cont_Alumno1_Activity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login_Basic_Activity extends AppCompatActivity {

    private TextInputEditText editTextUserId;
    private TextInputEditText editTextPassword;
    private TextView textViewMessage;

    Toolbar toolbar;

    // Credenciales de ejemplo
    private static final String VALID_USER = "Nsuarez";    // Nsuarez
    private static final String VALID_PASSWORD = "Olisuarez";  // Olisuarez

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_basic);

        /**
         * Barra Navegacion Inicial
         */
        // Configurar el Toolbar desde el layout XML
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(Color.parseColor("#FFFFFF")); //color general de app
        getSupportActionBar().setTitle("");

        /**
         *  // Habilitar la flecha de navegación (opcional)
         *         ActionBar actionBar = getSupportActionBar();
         *         if (actionBar != null) {
         *             actionBar.setDisplayHomeAsUpEnabled(true);
         *         }
         */


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define aquí la actividad a la que quieres navegar
                Intent intent = new Intent(Login_Basic_Activity.this, Select_Activity.class);
                startActivity(intent);
                // Si quieres que se cierre la actividad actual
                finish();
            }
        });
        // TODO: 11/10/2024  
        /**
         * Terminado codigo
         */
        // Referencias a los elementos del layout
        TextInputLayout usuarioInputLayout = findViewById(R.id.usuario_input_layout);
        TextInputLayout passwordInputLayout = findViewById(R.id.password_input_layout);

        // Obtener los TextInputEditText de los TextInputLayout
        editTextUserId = (TextInputEditText) usuarioInputLayout.getEditText();
        editTextPassword = (TextInputEditText) passwordInputLayout.getEditText();

        Button buttonLogin = findViewById(R.id.buttonLogin);
        textViewMessage = findViewById(R.id.textViewMessage);

        // Configurar el botón de inicio de sesión
        buttonLogin.setOnClickListener(v -> validateLogin());
    }

    private void validateLogin() {
        String userId = editTextUserId.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Validar las credenciales
        if (userId.equals(VALID_USER) && password.equals(VALID_PASSWORD)) {
            // Si las credenciales son correctas, iniciar MainActivity
            Intent intent = new Intent(Login_Basic_Activity.this, Cont_Alumno1_Activity.class);
            startActivity(intent);
            finish(); // Cerrar LoginActivity
        } else {
            // Si las credenciales no son válidas, mostrar mensaje de error
            textViewMessage.setText("Usuario no validado");
            textViewMessage.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        // Crear un Intent para redirigir a una actividad predeterminada
        super.onBackPressed();
        Intent intent = new Intent(this, Select_Activity.class); // Reemplaza con tu actividad destino
        startActivity(intent);

        // Opcional: Cierra la actividad actual
        finish();
    }
}