package com.devsoftw.aprendoconoli.Controller.Fragment_Alum1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.devsoftw.aprendoconoli.R;


public class Colegio_Fragment extends Fragment {

    public Colegio_Fragment() {
        // Requiere un constructor vacío
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el diseño para este fragmento
        View view = inflater.inflate(R.layout.fragment_colegio_, container, false);

        //Button button = view.findViewById(R.id.button_tab1);
        //button.setOnClickListener(v -> Toast.makeText(getActivity(), "Tab 1 ejecutado", Toast.LENGTH_SHORT).show());

        return view;
    }
}