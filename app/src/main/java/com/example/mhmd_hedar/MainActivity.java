package com.example.mhmd_hedar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    Button buttonLogin, buttonSignUp;
    TextView textView1;

    private final String valid_mail = "admin";
    private final String valid_password = "1";
    SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPasword);

        buttonLogin = findViewById(R.id.buttonLogin);


        buttonSignUp = findViewById(R.id.buttonSignUp);
        preferences = getSharedPreferences("userinfo", 0);

    }


    // this method loods the menu design into this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // in case user chose about menu
        if (item.getItemId() == R.id.settings_menu){
            //open the about activity when the settings menu item selected
            //this is from where  , and the second paramater is to where
            Intent i = new Intent(this, CameraActivity.class);
            startActivity(i);
    }else if (item.getItemId() == R.id.help_menu) {
            Intent i = new Intent(this, ListActivity.class);
            startActivity(i);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("back button was pressed!");
        dialog.setMessage("Are you sure you want to Exit");
        //in case the user chose No , nothing Happens, the
        dialog.setNegativeButton("No", null);
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        dialog.setIcon(R.drawable.ic_baseline_clean_hands_24);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();



    }
    public void login(View view) {
        String email = preferences.getString("email", "");
        String password = preferences
                .getString("password", "");

        String etEmail = editTextEmail.getText().toString();
        String etPass = editTextPassword.getText().toString();
        if (email != null && password != null) {
            if (email.equals(etEmail) && password.equals(etPass)) {
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
            } else
                Toast.makeText(this, "Error! wrong email or password", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Error! email and password are empty", Toast.LENGTH_SHORT).show();
    }

    public void register(View view) {
        Intent i_register = new Intent(this, Register.class);
        startActivity(i_register);
    }

}