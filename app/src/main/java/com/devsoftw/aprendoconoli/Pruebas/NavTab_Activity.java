package com.devsoftw.aprendoconoli.Pruebas;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.devsoftw.aprendoconoli.R;
import com.google.android.material.tabs.TabLayout;

public class NavTab_Activity extends AppCompatActivity {

    // TODO: 10/10/2024 Funciona  
    private TabLayout tabLayout;
    private TextView textViewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nav_tab);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referencias a los elementos del layout
        tabLayout = findViewById(R.id.tabLayout);
        textViewContent = findViewById(R.id.textViewContent);
        // Configurar las pestañas
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"));

        // Manejar eventos de selección de pestañas
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                // Cambiar el contenido basado en la pestaña seleccionada
                switch (position) {
                    case 0:
                        textViewContent.setText("Contenido de la Pestaña 1");

                        break;
                    case 1:
                        textViewContent.setText("Contenido de la Pestaña 2");
                        break;
                    case 2:
                        textViewContent.setText("Contenido de la Pestaña 3");
                        break;
                    case 3:
                        textViewContent.setText("Contenido de la Pestaña 4");
                        break;
                    default:
                        textViewContent.setText("Contenido por defecto");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // No se necesita hacer nada aquí.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // No se necesita hacer nada aquí.
            }
        });
    }
}