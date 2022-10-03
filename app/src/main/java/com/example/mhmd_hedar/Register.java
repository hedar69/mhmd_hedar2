package com.example.mhmd_hedar;



import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        btcancel = findViewById(R.id.button2);

        preferences = getSharedPreferences("userinfo", 0);


    }


    public void register(View view){
        String etMail = etmail.getText().toString();
        String etPass = etpassword.getText().toString();
        //saves the email value in the prefrences and commits the file
        preferences.edit().putString("email",etMail).commit();
        preferences.edit().putString("password",etPass).commit();

    }

}