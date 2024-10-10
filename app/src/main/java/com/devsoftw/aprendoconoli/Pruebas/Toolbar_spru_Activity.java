package com.devsoftw.aprendoconoli.Pruebas;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.devsoftw.aprendoconoli.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;

public class Toolbar_spru_Activity extends AppCompatActivity {

    Toolbar toolbar;

    // TODO: 7/10/2024
    // TODO: 7/10/2024 Se Valida Diseño Imagen a la derecha del toolbar 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toolbar_spru);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Establece el layout principal
        setContentView(R.layout.activity_toolbar_spru); // Usa el layout correcto donde está definido el Toolbar en XML

        // Configurar el Toolbar desde el layout XML
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Habilitar la flecha de navegación (opcional)
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

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
    }

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