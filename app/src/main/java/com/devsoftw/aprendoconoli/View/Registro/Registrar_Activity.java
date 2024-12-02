package com.devsoftw.aprendoconoli.View.Registro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.devsoftw.aprendoconoli.Controller.Administrador.Admi_Login_Activity;
import com.devsoftw.aprendoconoli.Model.Select_Activity;
import com.devsoftw.aprendoconoli.R;
import com.devsoftw.aprendoconoli.View.Login_Colegio.Student.Login_Basic_Activity;

public class Registrar_Activity extends AppCompatActivity {

    // TODO: 23/11/2024
    /**
     * edtNombre		ok
     * edtApePat		ok
     * edtApeMat		ok
     * edtDNI			ok
     * edtTelefono		no
     * edtPassword		ok
     * edtEstado		ok
     * edtAutorizado		ok    == recordar valor profe 0 alum 1
     * btnEnviarDtAlumno 	Button
     * @param savedInstanceState
     */

    // Variables Declaradas de XML activity_registrar.xml

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);


    }
}