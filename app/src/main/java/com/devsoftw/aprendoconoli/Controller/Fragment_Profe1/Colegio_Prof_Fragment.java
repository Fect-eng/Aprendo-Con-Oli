package com.devsoftw.aprendoconoli.Controller.Fragment_Profe1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;

import com.devsoftw.aprendoconoli.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import de.hdodenhof.circleimageview.BuildConfig;

public class Colegio_Prof_Fragment extends Fragment {
    private static final int REQUEST_CALL_PERMISSION = 100; // Código de solicitud para permisos
    private String phoneNumber = "+51924146636"; // Número de teléfono a llamar

    public Colegio_Prof_Fragment() {
        // Constructor vacío requerido
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el diseño para este fragmento
        View view = inflater.inflate(R.layout.fragment_colegio__prof_, container, false);

        TextView Text_llamarTelefono = view.findViewById(R.id.Text_llamarTelefono);
        // Configurar el clic del botón
        Text_llamarTelefono.setOnClickListener(v -> checkPermissionAndMakeCall());
        //=====================================================================================================
        ImageView Imageview_Correo = view.findViewById(R.id.Imageview_Correo);
        Imageview_Correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Crear un Intent para enviar correo
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse("mailto:")); // Usar mailto para asegurarse de que abra un cliente de correo
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"contactanos@sacooliveros.edu.pe"}); // Dirección de correo
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Aprendo Con Oli"); // Asunto del correo
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Hola, esta es una prueba desde la aplicación Oli."); // Cuerpo del correo

                    // Abrir el cliente de correo
                    startActivity(Intent.createChooser(emailIntent, "Enviar correo con"));

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(view.getContext(), "No se pudo abrir el cliente de correo.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView TXT_EmailIntitucional = view.findViewById(R.id.TXT_EmailIntitucional);
        TXT_EmailIntitucional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Crear un Intent para enviar correo
                    //emailIntent.setPackage("com.microsoft.office.outlook");
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse("mailto:")); // Usar mailto para asegurarse de que abra un cliente de correo
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"contactanos@sacooliveros.edu.pe"}); // Dirección de correo
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Aprendo Con Oli"); // Asunto del correo
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Hola, esta es una prueba desde la aplicación Oli."); // Cuerpo del correo

                    // Especificar Outlook como aplicación para enviar el correo
                    //emailIntent.setPackage("com.microsoft.office.outlook");

                    // Abrir el cliente de correo
                   startActivity(Intent.createChooser(emailIntent, "Enviar correo con"));



                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(view.getContext(), "No se pudo abrir el cliente de correo.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView ImageMap_View = view.findViewById(R.id.ImageMap_View);
        ImageMap_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // La ubicación de Plaza Mayor de Cuzco, usando Google Maps en el navegador
                    String mapsUrl = "https://www.google.com/maps?q=-13.5167666,-71.980038";

                    // Crear una URI con la URL de Google Maps
                    Uri mapUri = Uri.parse(mapsUrl);

                    // Crear un Intent con la acción ACTION_VIEW
                    Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
                    intent.setPackage("com.android.chrome"); // Usar Google Chrome

                    // Verificar si Google Chrome está instalado
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent); // Abre en Chrome
                    } else {
                        // Si Chrome no está instalado, abrir en el navegador por defecto
                        intent.setPackage(null);
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    // En caso de error, muestra un mensaje
                    Toast.makeText(getActivity(), "Hubo un problema al intentar abrir la ubicación", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView TXT_MapsUbication = view.findViewById(R.id.TXT_MapsUbication);
        TXT_MapsUbication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // La ubicación de Plaza Mayor de Cuzco, usando Google Maps en el navegador
                    String mapsUrl = "https://www.google.com/maps?q=-13.5167666,-71.980038";

                    // Crear una URI con la URL de Google Maps
                    Uri mapUri = Uri.parse(mapsUrl);

                    // Crear un Intent con la acción ACTION_VIEW
                    Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
                    intent.setPackage("com.android.chrome"); // Usar Google Chrome

                    // Verificar si Google Chrome está instalado
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent); // Abre en Chrome
                    } else {
                        // Si Chrome no está instalado, abrir en el navegador por defecto
                        intent.setPackage(null);
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    // En caso de error, muestra un mensaje
                    Toast.makeText(getActivity(), "Hubo un problema al intentar abrir la ubicación", Toast.LENGTH_SHORT).show();
                }
            }
        });


/**
 * =============================================================================================================
 * =============================================================================================================
 * =============================================================================================================
 * =============================================================================================================
 */
        ImageView imageViewLeft = view.findViewById(R.id.imageViewLeft);
        imageViewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Aprendo Con Oli");
                    String shareMessage= "\nAplicacion Oli.\n\n";
                    shareMessage = shareMessage + "https://pe.computrabajo.com/empleos-en-tacna" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "Compartir Por"));
                } catch(Exception e) {
                    //e.toString();
                }
            }

        });

        // Configurar el clic en el ImageView
       // imageViewLeft.setOnClickListener(v -> openWhatsAppWithText());

        return view; // Retornar la vista
    }

    private void checkPermissionAndMakeCall() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            // Permiso ya concedido, realizar la llamada
            makePhoneCall();
        } else {
            // Solicitar el permiso
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
        }
    }

    // Método para realizar la llamada
    private void makePhoneCall() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));

        // Verificar nuevamente si el permiso está concedido antes de iniciar la llamada
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(callIntent);
        } else {
            Toast.makeText(requireContext(), "Permiso no concedido para realizar la llamada", Toast.LENGTH_SHORT).show();
        }
    }

    // Manejo del resultado de la solicitud de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, realizar la llamada
                makePhoneCall();
            } else {
                // Permiso denegado, mostrar mensaje
                Toast.makeText(requireContext(), "Permiso denegado para realizar llamadas", Toast.LENGTH_SHORT).show();
            }
        }
    }
}