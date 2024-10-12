package com.devsoftw.aprendoconoli.Controller.Fragment_Alum1;

import static androidx.core.app.ActivityCompat.finishAffinity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.devsoftw.aprendoconoli.Model.Select_Activity;
import com.devsoftw.aprendoconoli.R;

public class CerrarSesion_Fragment extends Fragment {

    public CerrarSesion_Fragment() {
        // Requiere un constructor vacío
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el diseño para este fragmento
        View view = inflater.inflate(R.layout.fragment_cerrar_sesion_, container, false);

        Button button = view.findViewById(R.id.button_tab1);

        button.setOnClickListener(v -> {
            // Crear y mostrar un AlertDialog
            new AlertDialog.Builder(requireContext())  // Utiliza requireContext() o getActivity()
                    .setTitle("Cerrar Sesion")
                    .setMessage("¿Estás seguro de Cerrar Sesion?")
                    .setPositiveButton("Sí", (dialog, which) -> {
                        // Si el usuario selecciona "Sí", redirigir a una nueva actividad
                        Intent intent = new Intent(getActivity(), Select_Activity.class); // Reemplaza YourTargetActivity con la actividad destino
                        startActivity(intent);
                    })
                    .setNegativeButton("No", null) // Si selecciona "No", no hace nada
                    .show();
        });

        return view;
    }
}