package com.devsoftw.aprendoconoli.View.Login_Colegio.Student;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.devsoftw.aprendoconoli.Controller.Administrador.Admi_Login_Activity;
import com.devsoftw.aprendoconoli.MainActivity;
import com.devsoftw.aprendoconoli.Model.Select_Activity;
import com.devsoftw.aprendoconoli.R;
import com.devsoftw.aprendoconoli.View.Opt_Nav_Alumno.Cont_Alumno1_Activity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Login_Basic_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Button buttonLogin;
    private TextInputEditText edtUsuario;
    private TextInputEditText edtPassword;
    String nombre, cn_pass;
    ImageView IMG_Clear;

    Toolbar toolbar;

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

        toolbar.setBackgroundColor(Color.parseColor("#f52c29")); // Color general de la app
        toolbar.setTitleTextColor(Color.WHITE); // Cambiar el color del texto del título a blanco
        getSupportActionBar().setTitle("Login Alumno Oliveros");



        // Habilitar la flecha de navegación (opcional)
                  ActionBar actionBar = getSupportActionBar();
                  if (actionBar != null) {
                      actionBar.setDisplayHomeAsUpEnabled(true);
                  }

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

        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = edtUsuario.getText().toString();
                cn_pass = edtPassword.getText().toString();

                if (!nombre.isEmpty() && !cn_pass.isEmpty()) {
                    validarUsuario("http://192.168.199.119/API_OliverosApp/login.php");
                    //validarUsuario("https://devcraftinglab.com/aprendocon_oli/validar_user.php");

                } else {
                    Toast.makeText(Login_Basic_Activity.this, "No se permiten espacios vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        IMG_Clear = findViewById(R.id.IMG_Clear);
        IMG_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                metodo_limpieza();
            }
        });
    }

    private void metodo_limpieza() {
        edtUsuario.setText("");
        edtPassword.setText("");
        Toast.makeText(this, "Limpieza Realizada", Toast.LENGTH_SHORT).show();
    }

    private void validarUsuario(String URL) {
        // Construir la URL con los parámetros
        URL += "?nombre=" + nombre + "&cn_pass=" + cn_pass;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            String message = jsonResponse.getString("message");

                            if (success) {
                                Intent intent = new Intent(getApplicationContext(), Cont_Alumno1_Activity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Login_Basic_Activity.this, message, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            Toast.makeText(Login_Basic_Activity.this, "Error al interpretar la respuesta del servidor", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VolleyError", "Error de conexiónn: " + error.toString());
                      //  Toast.makeText(Login_Basic_Activity.this, "Error de conexión: " + error.toString(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(Login_Basic_Activity.this, "Error de conexión: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void onBackPressed() {
        // Crear un Intent para redirigir a una actividad predeterminada
        super.onBackPressed();
        Intent intent = new Intent(this, Select_Activity.class); // Reemplaza con tu actividad destino
        startActivity(intent);
        // Opcional: Cierra la actividad actual
        finish();
    }

    // TODO: 29/11/2024  /**

    /**
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.itemConsulta) {
            Toast.makeText(this, "Opcion Administrador", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Admi_Login_Activity.class); // Reemplaza con tu actividad destino
            startActivity(intent);

        } else if (id == R.id.item_About) {
            //para utilizar
            Toast.makeText(this, "Acerca de.", Toast.LENGTH_SHORT).show();
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