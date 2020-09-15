package com.leonestudios.puppiesgram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.AsyncTaskLoader;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactoActivity extends AppCompatActivity {
    EditText etTextPersonName, etTextEmailAddress, etTextMultiLine;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarComentario(view);
            }
        });
    }
    public void enviarComentario(View view){
        etTextPersonName = findViewById(R.id.etTextPersonName);
        etTextEmailAddress = findViewById(R.id.etTextEmailAddress);
        etTextMultiLine = findViewById(R.id.etTextMultiline);

        String nombre = etTextPersonName.getText().toString();
        String toEmails = etTextEmailAddress.getText().toString();
        String mensaje = etTextMultiLine.getText().toString();

        String emailbody = "Enviado por: " + nombre + "Mensaje: " + mensaje;

        final String fromEmail = "";
        final String fromPassword = "";
        final String emailPort = "";
        final String smtAuth = "true";
        final String starttls = "true";
        final String emailHost = "";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", smtAuth);
        properties.put("mail.smtp.starttls.enable", starttls);
        properties.put("mail.smtp.host", emailHost);
        properties.put("mail.smtp.port", emailPort);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, fromPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmails.trim()));
            message.setSubject(nombre.trim());
            message.setText(emailbody.trim());
            new SendMail().execute(message);

            etTextPersonName.setText("");
            etTextEmailAddress.setText("");
            etTextMultiLine.setText("");
            Log.i("Mensaje", "enviado2");

        } catch (MessagingException e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ContactoActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
    private class SendMail extends AsyncTask<Message,String,String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();

            progressDialog = ProgressDialog.show(ContactoActivity.this, "Por favor espere", "Enviando mensaje...", true, false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return "Success";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            if (s.equals("Success")){
                AlertDialog.Builder builder = new AlertDialog.Builder(ContactoActivity.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<front color='#509324'>Success</font>"));
                builder.setMessage("correo enviado con éxito.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                builder.show();
            }else{

                Toast.makeText(getApplicationContext(),"Algo salió mal ?",Toast.LENGTH_SHORT).show();
            }
        }
    }
}