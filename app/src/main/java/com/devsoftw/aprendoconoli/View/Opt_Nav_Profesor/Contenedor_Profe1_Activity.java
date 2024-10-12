package com.devsoftw.aprendoconoli.View.Opt_Nav_Profesor;

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
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.devsoftw.aprendoconoli.Controller.Fragment_Alum1.CerrarSesion_Fragment;
import com.devsoftw.aprendoconoli.Controller.Fragment_Alum1.Colegio_Fragment;
import com.devsoftw.aprendoconoli.Controller.Fragment_Alum1.Cursos_Fragment;
import com.devsoftw.aprendoconoli.Controller.Fragment_Alum1.Horario_Fragment;
import com.devsoftw.aprendoconoli.Controller.Fragment_Alum1.Notioli_Fragment;
import com.devsoftw.aprendoconoli.Controller.Fragment_Profe1.CerrarSesion_Prof_Fragment;
import com.devsoftw.aprendoconoli.Controller.Fragment_Profe1.Colegio_Prof_Fragment;
import com.devsoftw.aprendoconoli.Controller.Fragment_Profe1.Grados_Profe_Fragment;
import com.devsoftw.aprendoconoli.Controller.Fragment_Profe1.Horario_Prof_Fragment;
import com.devsoftw.aprendoconoli.Controller.Fragment_Profe1.Notioli_Prof_Fragment;
import com.devsoftw.aprendoconoli.R;
import com.devsoftw.aprendoconoli.View.Opt_Nav_Alumno.Cont_Alumno1_Activity;
import com.google.android.material.tabs.TabLayout;

public class Contenedor_Profe1_Activity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contenedor_profe1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /**
         * Barra Navegacion Inicial
         */
        // Configurar el Toolbar desde el layout XML
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(Color.parseColor("#FFFFFF")); //color general de app
        getSupportActionBar().setTitle("Profesor Pablo Bellido");
        toolbar.setTitleTextColor(Color.BLACK); // cambia el color del texto del título a negro

        /**
         *
         */
        // Habilitar la flecha de navegación (opcional)
        //        ActionBar actionBar = getSupportActionBar();
        //       if (actionBar != null) {
        //           actionBar.setDisplayHomeAsUpEnabled(true);
        //      }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 11/10/2024  en el nav tab cuando estes ejemplo colegio la flecha del toolbar que retroceda a colegio y de cole a cursos y sucesivo
                // Define aquí la actividad a la que quieres navegar
                Intent intent = new Intent(Contenedor_Profe1_Activity.this, Cont_Alumno1_Activity.class);
                startActivity(intent);
                // Si quieres que se cierre la actividad actual
                finish();
            }
        });

        // Crear el ImageView de manera programática
        ImageView imageView = new ImageView(this);

        // Obtener el bitmap de la imagen (usa una imagen de tu recurso drawable)
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.proffff)).getBitmap();    // Imagen

        // Convertir la imagen en circular con borde
        Bitmap circularBitmapWithBorder = getCircularBitmapWithBorder(bitmap, 10, Color.WHITE); // Grosor del borde 10, color blanco
        imageView.setImageBitmap(circularBitmapWithBorder);

        // Ajustar el tamaño de la imagen (ancho y alto en píxeles)
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(100, 100); // Ajusta el tamaño a tu preferencia
        layoutParams.gravity = Gravity.END;  // Para posicionar la imagen a la derecha
        layoutParams.setMargins(0, 0, 16, 0); // Añadir margen derecho para separar la imagen del borde

        // Asignar el layoutParams al ImageView
        imageView.setLayoutParams(layoutParams);

        // Añadir la imagen al Toolbar
        toolbar.addView(imageView);
        /**
         * Codigo Terminado
         */

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        // Configurar el ViewPager con el adapter
        Contenedor_Profe1_Activity.ViewPagerAdapter adapter = new Contenedor_Profe1_Activity.ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * Codigo Toolbar con imagen
     */
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
    /**
     * Codigo Terminado de Toolbar
     */



    // Adapter para manejar los Fragments en el ViewPager
    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        /**
         * Modificar segun la nesecidad
         * @param position
         * @return
         */
        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Notioli_Prof_Fragment();          // cambiar
                case 1:
                    return new Grados_Profe_Fragment();
                case 2:
                    return new Colegio_Prof_Fragment();
                case 3:
                    return new Horario_Prof_Fragment();
                case 4:
                    return new CerrarSesion_Prof_Fragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 5; // Número de tabs
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "NOTIOLI";
                case 1:
                    return "GRADOS";
                case 2:
                    return "COLEGIO";
                case 3:
                    return "HORARIO";
                case 4:
                    return "CERRAR SESION";
                default:
                    return null;
            }
        }
    }
}