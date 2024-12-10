package com.devsoftw.aprendoconoli.Model.Examen_Virtual;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.devsoftw.aprendoconoli.R;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.FileOutputStream;

public class Examen_Alumno_Activity extends AppCompatActivity {

    private RadioGroup[] radioGroups;
    private String[] correctAnswers = {"A", "C", "C", "A", "B", "A"}; // Respuestas correctas
    private TextView txtCalificacionFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_examen_alumno);


        // Inicializar RadioGroups
        radioGroups = new RadioGroup[]{
                findViewById(R.id.radioGroup_1),
                findViewById(R.id.radioGroup_2),
                findViewById(R.id.radioGroup_3),
                findViewById(R.id.radioGroup_4),
                findViewById(R.id.radioGroup_5),
                findViewById(R.id.radioGroup_6)
        };

        // TextView para mostrar la calificación final
        txtCalificacionFinal = findViewById(R.id.txtCalificacionFinal);

        // Botón para enviar examen
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularNota();
            }
        });
    }

    private void calcularNota() {
        double totalScore = 0.0;
        double scorePerQuestion = 20.0 / radioGroups.length;

        // Iterar sobre las preguntas
        for (int i = 0; i < radioGroups.length; i++) {
            RadioGroup group = radioGroups[i];
            int selectedId = group.getCheckedRadioButtonId();

            if (selectedId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedAnswer = obtenerRespuestaSeleccionada(selectedRadioButton);

                if (selectedAnswer.equals(correctAnswers[i])) {
                    totalScore += scorePerQuestion;
                }
            }
        }

        // Mostrar la calificación en el TextView
        String calificacionFinal = "Tu nota final es: " + Math.round(totalScore * 100.0) / 100.0;
        txtCalificacionFinal.setText(calificacionFinal);

        // Generar el PDF con la calificación
        try {
            generarPDF(calificacionFinal);
            Toast.makeText(this, "PDF generado correctamente", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error al generar el PDF: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private String obtenerRespuestaSeleccionada(RadioButton radioButton) {
        int index = ((RadioGroup) radioButton.getParent()).indexOfChild(radioButton);
        return new String[]{"A", "B", "C", "D"}[index];
    }

    private void generarPDF(String calificacionFinal) throws Exception {
        // Ruta para guardar el archivo
        File pdfDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "Examenes");
        if (!pdfDir.exists()) {
            pdfDir.mkdirs();
        }

        File pdfFile = new File(pdfDir, "CalificacionFinal.pdf");

        // Crear el PDF
        PdfWriter writer = new PdfWriter(new FileOutputStream(pdfFile));
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        // Agregar contenido al PDF
        document.add(new Paragraph("Resultado del Examen"));
        document.add(new Paragraph(calificacionFinal));

        // Cerrar el documento
        document.close();

        Toast.makeText(this, "PDF guardado en: " + pdfFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
    }
}