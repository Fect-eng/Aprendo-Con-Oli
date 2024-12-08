package com.devsoftw.aprendoconoli.Controller.Fragment_Profe1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.devsoftw.aprendoconoli.R;


public class Horario_Prof_Fragment extends Fragment {

    private FrameLayout zoomBackground;
    private ImageView ImageMap_View1;
    private boolean isZoomed = false;

    public Horario_Prof_Fragment() {
        // Requiere un constructor vacío
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el diseño para este fragmento
        View view = inflater.inflate(R.layout.fragment_horario__prof_, container, false);

        // Referencias a las vistas
        zoomBackground = view.findViewById(R.id.zoomBackground);  // Se usa 'view' en lugar de 'rootView'
        ImageMap_View1 = view.findViewById(R.id.ImageMap_View1); // Asegúrate de usar el ID correcto

        // Establecer el listener para el ImageView
        ImageMap_View1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isZoomed) {
                    // Si ya está con zoom, devolver al tamaño original y esconder el fondo gris
                    resetZoom();
                } else {
                    // Si no está con zoom, hacer el zoom
                    zoomImage();
                }
            }
        });

        // Cuando el usuario toque el fondo gris, se resetea el zoom
        zoomBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetZoom();
            }
        });

        return view;
    }

    private void zoomImage() {
        // Mostrar el fondo gris
        zoomBackground.setVisibility(View.VISIBLE);

        // Hacer el zoom sobre la imagen utilizando una animación
        ScaleAnimation zoomIn = new ScaleAnimation(
                1f, 1.5f,  // Escala horizontal (ampliación de 1x a 1.5x)
                1f, 1f,    // Escala vertical (sin cambio)
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,  // Punto de pivote en el centro
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        zoomIn.setDuration(300);
        zoomIn.setFillAfter(true); // Mantener el zoom

        // Ejecutar la animación
        ImageMap_View1.startAnimation(zoomIn);

        // Cambiar el estado de zoom
        isZoomed = true;
    }

    private void resetZoom() {
        // Ocultar el fondo gris
        zoomBackground.setVisibility(View.GONE);

        // Restaurar el tamaño original de la imagen utilizando animación
        ScaleAnimation zoomOut = new ScaleAnimation(
                1.5f, 1f,  // Escala horizontal (devolver al tamaño original)
                1f, 1f,    // Escala vertical (sin cambio)
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,  // Punto de pivote en el centro
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        zoomOut.setDuration(300);
        zoomOut.setFillAfter(true); // Mantener el tamaño original después de la animación

        // Ejecutar la animación
        ImageMap_View1.startAnimation(zoomOut);

        // Cambiar el estado de zoom
        isZoomed = false;
    }
}