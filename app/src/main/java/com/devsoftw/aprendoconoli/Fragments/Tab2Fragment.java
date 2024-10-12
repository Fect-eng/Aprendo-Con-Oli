package com.devsoftw.aprendoconoli.Fragments;

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

public class Tab2Fragment extends Fragment {

    public Tab2Fragment() {
        // Requiere un constructor vacío
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el diseño para este fragmento
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);

        Button button = view.findViewById(R.id.button_tab2);
        button.setOnClickListener(v -> Toast.makeText(getActivity(), "Tab 2 ejecutado", Toast.LENGTH_SHORT).show());

        return view;
    }
}