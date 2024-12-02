package com.devsoftw.aprendoconoli.View.Examen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.devsoftw.aprendoconoli.R;

public class Examen_Activity extends AppCompatActivity {


    private RadioGroup[] questionGroups; // Arreglo para manejar los RadioGroups
    private int[] correctAnswers; // Índices de las respuestas correctas
    private TextView[] questionTextViews; // Opcional: Para manejar preguntas dinámicas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_examen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vincular los RadioGroups
        questionGroups = new RadioGroup[] {
                findViewById(R.id.group1),
                findViewById(R.id.group2)
                // Agrega los IDs de los RadioGroups restantes
        };

        // Respuestas correctas (índices de RadioButtons)
        correctAnswers = new int[] {
                R.id.q1_option2, // París
                R.id.q2_option2  // 8
                // Agrega los IDs correctos para las preguntas restantes
        };

        // Configurar el botón de calificación
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(v -> evaluateExam());
    }

    private void evaluateExam() {
        int totalScore = 0;

        for (int i = 0; i < questionGroups.length; i++) {
            RadioGroup group = questionGroups[i];
            int selectedOption = group.getCheckedRadioButtonId();

            if (selectedOption == correctAnswers[i]) {
                totalScore++;
            }
        }

        // Mostrar la calificación
        Toast.makeText(this, "Puntaje: " + totalScore + "/" + questionGroups.length, Toast.LENGTH_LONG).show();
    }
}