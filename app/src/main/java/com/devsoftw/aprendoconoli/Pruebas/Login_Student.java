package com.devsoftw.aprendoconoli.Pruebas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.devsoftw.aprendoconoli.MainActivity;
import com.devsoftw.aprendoconoli.Model.TabNabBar.AlumnoNav_Activity;
import com.devsoftw.aprendoconoli.R;
import com.google.android.material.textfield.TextInputEditText;

public class Login_Student extends AppCompatActivity {

    Toolbar toolbar;
    Button btn_loginAuth;

     TextInputEditText usuario_input_layout;
     TextInputEditText password_input_layout;
    private TextView textViewMessage;

    // Credenciales de ejemplo
    private static final String VALID_USER = "user1";
    private static final String VALID_PASSWORD = "password1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configura el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(Color.parseColor("#de8577"));
        getSupportActionBar().setTitle("APRENDO CON OLI");

        // Habilita la flecha de navegación hacia atrás
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); // Muestra la flecha de navegación
            actionBar.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24); // Icono personalizado si lo deseas
        }

        // Referencias a los elementos del layout
        // TODO: 11/10/2024  
        usuario_input_layout = findViewById(R.id.usuario_input_layout);
        password_input_layout = findViewById(R.id.password_input_layout);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        textViewMessage = findViewById(R.id.textViewMessage);

        // Configurar el botón de inicio de sesión
        buttonLogin.setOnClickListener(v -> validateLogin());

        /**
         *
         *
         */
        // Crear el ImageView de manera programática
        ImageView imageView = new ImageView(this);

        // Obtener el bitmap de la imagen (usa una imagen de tu recurso drawable)
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.niloalm)).getBitmap();

        // Convertir la imagen en circular con borde
        Bitmap circularBitmapWithBorder = getCircularBitmapWithBorder(bitmap, 10, Color.WHITE); // Grosor del borde 10, color blanco
        imageView.setImageBitmap(circularBitmapWithBorder);

        // Ajustar el tamaño de la imagen (ancho y alto en píxeles)
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(80, 80); // Ajusta el tamaño a tu preferencia
        layoutParams.gravity = Gravity.END;  // Para posicionar la imagen a la derecha
        layoutParams.setMargins(0, 0, 16, 0); // Añadir margen derecho para separar la imagen del borde

        // Asignar el layoutParams al ImageView
        imageView.setLayoutParams(layoutParams);

        // Añadir la imagen al Toolbar
        toolbar.addView(imageView);
        /**
         *
         */

        // Maneja el botón físico de "atrás" con OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Acciones a realizar cuando se presiona el botón físico de "atrás"
                AccionPresionButton();
                finish(); // O cualquier otra acción personalizada, como navegar hacia otra actividad
            }
        });

        btn_loginAuth = findViewById(R.id.btn_loginAuth);
        btn_loginAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Student.this, AlumnoNav_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    } // TODO: 9/10/2024  Fin de Codigo onCreate


    private void validateLogin() {
        String userId = usuario_input_layout.getText().toString().trim();
        String password = password_input_layout.getText().toString().trim();

        // Validar las credenciales
        if (userId.equals(VALID_USER) && password.equals(VALID_PASSWORD)) {
            // Si las credenciales son correctas, iniciar MainActivity
            Intent intent = new Intent(Login_Student.this, MainActivity.class);
            startActivity(intent);
            finish(); // Cerrar LoginActivity
        } else {
            // Si las credenciales no son válidas, mostrar mensaje de error
            textViewMessage.setText("Usuario no validado");
            textViewMessage.setVisibility(View.VISIBLE);
        }
    }


    private void AccionPresionButton() {
        // TODO: 6/10/2024 --------- Accion De Boton cuando se presiona 
        Intent intent = new Intent(Login_Student.this, MainActivity.class);
        startActivity(intent);
    }

    // Maneja el clic en la flecha de navegación en el Toolbar
    @Override
    public boolean onSupportNavigateUp() {
        // Utiliza onBackPressedDispatcher en lugar de onBackPressed()
        getOnBackPressedDispatcher().onBackPressed(); // Desencadena la acción de retroceso utilizando el dispatcher
        return true;
    }
    // Recuerda OnBackPressed es mas facil pero esta deprecado

    // Método para hacer la imagen circular con borde
    private Bitmap getCircularBitmapWithBorder(Bitmap bitmap, int borderWidth, int borderColor) {
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());  // Tomamos el tamaño mínimo para hacerlo circular
        int borderSize = size + borderWidth * 2;  // El tamaño final incluye el borde

        Bitmap output = Bitmap.createBitmap(borderSize, borderSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        // Crear el borde
        Paint borderPaint = new Paint();
        borderPaint.setAntiAlias(true);
        borderPaint.setColor(borderColor);  // Color del borde
        canvas.drawCircle(borderSize / 2f, borderSize / 2f, borderSize / 2f, borderPaint);  // Dibujar el círculo del borde

        // Crear el círculo interior con la imagen
        Paint imagePaint = new Paint();
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        imagePaint.setShader(shader);
        imagePaint.setAntiAlias(true);

        // Dibujar la imagen circular en el centro del borde
        float radius = size / 2f;
        canvas.drawCircle(borderSize / 2f, borderSize / 2f, radius, imagePaint);

        return output;
    }
}