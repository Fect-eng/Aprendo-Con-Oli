package com.devsoftw.aprendoconoli.Controller.Administrador.Registro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.devsoftw.aprendoconoli.Controller.Administrador.Admi_Login_Activity;
import com.devsoftw.aprendoconoli.Model.Select_Activity;
import com.devsoftw.aprendoconoli.R;
import com.devsoftw.aprendoconoli.View.Login_Colegio.Student.Login_Basic_Activity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registrar_Activity extends AppCompatActivity{

    Toolbar toolbar;
    TextInputEditText TXT_NombreAlumno;
    TextInputEditText TXT_ApellidoPaterno;
    TextInputEditText TXT_ApellidoMaterno;
    TextInputEditText TXT_EdadAlumno;
    TextInputEditText TXT_DNIAlumno;
    TextInputEditText TXT_DireccionCasa;
    TextInputEditText TXT_Password;
    Spinner Estado_Spinner_Oliveros;                // alumno 0 y 1
    Spinner Estado_Spinner;                         // grado alumnos
    Button Btn_RegistrarUsuario;
    ImageView IMG_Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);

        /**
         * Barra Navegacion Inicial
         */
        // Configurar el Toolbar desde el layout XML
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(Color.parseColor("#f52c29")); // Color general de la app
        toolbar.setTitleTextColor(Color.WHITE); // Cambiar el color del texto del título a blanco
        getSupportActionBar().setTitle("Registro Usuario Oliveros");

        /**
         * Variables declaradas
         */

        TXT_NombreAlumno = findViewById(R.id.TXT_NombreAlumno);
        TXT_ApellidoPaterno = findViewById(R.id.TXT_ApellidoPaterno);
        TXT_ApellidoMaterno = findViewById(R.id.TXT_ApellidoMaterno);
        TXT_EdadAlumno = findViewById(R.id.TXT_EdadAlumno);
        TXT_DNIAlumno = findViewById(R.id.TXT_DNIAlumno);
        TXT_DireccionCasa = findViewById(R.id.TXT_DireccionCasa);
        Estado_Spinner_Oliveros = findViewById(R.id.Estado_Spinner_Oliveros);
        Estado_Spinner = findViewById(R.id.Estado_Spinner);
        TXT_Password = findViewById(R.id.TXT_Password);
        IMG_Clear = findViewById(R.id.IMG_Clear);
        IMG_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                metodo_limpieza();
            }
        });

        Btn_RegistrarUsuario = findViewById(R.id.Btn_RegistrarUsuario);
        Btn_RegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejecutarServicio("http://192.168.199.119/API_OliverosApp/registro_usuarios.php");
            }
        });

        Spinner Estado_Spinner = findViewById(R.id.Estado_Spinner);
        Estado_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el número seleccionado
                String selectedNumber = parent.getItemAtPosition(position).toString();
                Toast.makeText(Registrar_Activity.this, "Grado Académico: " + selectedNumber, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No hacer nada
            }
        });

        Spinner Estado_Spinner_Oliveros = findViewById(R.id.Estado_Spinner_Oliveros);
        Estado_Spinner_Oliveros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el número seleccionado
                String selectedNumber1 = parent.getItemAtPosition(position).toString();
                Toast.makeText(Registrar_Activity.this, "Seleccionado: " + selectedNumber1, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No hacer nada
            }
        });
    }

    private void metodo_limpieza() {
        // Limpiar los campos de texto
        TXT_NombreAlumno.setText("");
        TXT_ApellidoPaterno.setText("");
        TXT_ApellidoMaterno.setText("");
        TXT_EdadAlumno.setText("");
        TXT_DNIAlumno.setText("");
        TXT_DireccionCasa.setText("");
        TXT_Password.setText("");

        Toast.makeText(this, "Limpieza Realizada", Toast.LENGTH_SHORT).show();
    }
    private void ejecutarServicio(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("nombre", TXT_NombreAlumno.getText().toString());
                parametros.put("apepat", TXT_ApellidoPaterno.getText().toString());
                parametros.put("apemat", TXT_ApellidoMaterno.getText().toString());
                parametros.put("edad", TXT_EdadAlumno.getText().toString());
                parametros.put("dni", TXT_DNIAlumno.getText().toString());
                parametros.put("direccion", TXT_DireccionCasa.getText().toString());
                parametros.put("estado", Estado_Spinner.getSelectedItem().toString());
                parametros.put("grado_alm", Estado_Spinner.getSelectedItem().toString());
                parametros.put("cn_pass", TXT_Password.getText().toString());

                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}