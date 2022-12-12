package com.example.mhmd_hedar;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.PreferenceChangeEvent;


public class Register extends AppCompatActivity {

    private EditText etmail, etpassword;
    private Button btnRegister, btcancel;
    private TextView tvwelcome;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etmail = findViewById(R.id.editTextTextEmailAddress);
        etpassword = findViewById(R.id.editTextNumberPassword);
        btnRegister = findViewById(R.id.buttonRegister);


        preferences = getSharedPreferences("userinfo", 0);


    }


    public void register(View view) {

        String input_mail = etmail.getText().toString();
        String input_password = etpassword.getText().toString();
        if (input_mail.length() > 0) {
            //open preferences file
            SharedPreferences.Editor editor = preferences.edit();
            //save key,value data
            editor.putString("username", input_mail);
            editor.putString("password", input_password);

            editor.apply();

            Toast.makeText(this, "User registered", Toast.LENGTH_SHORT).show();
            Intent intent_main = new Intent(this, MainActivity.class);
            startActivity(intent_main);
        } else {
            Toast.makeText(this, "Empty values, please insert!", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancel(View view) {
        Intent intent_main = new Intent(this, MainActivity.class);
        startActivity(intent_main);
    }
}