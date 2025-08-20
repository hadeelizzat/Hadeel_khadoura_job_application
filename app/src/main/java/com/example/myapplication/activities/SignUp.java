package com.example.myapplication.activities;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class SignUp extends AppCompatActivity {

    TextView login;
    EditText ed_email;
    EditText ed_password;
    EditText edConfirm_password;
    Button sign_up;
    ImageView facebook;
    ImageView gmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        login = findViewById(R.id.login);
        sign_up = findViewById(R.id.sign_up);
        ed_email=findViewById(R.id.ed_email);
        ed_password=findViewById(R.id.ed_password);
        edConfirm_password=findViewById(R.id.edConfirm_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed_email.getText().toString().isEmpty()|| ed_password.getText().toString().isEmpty()||ed_password.getText().toString().isEmpty()){
                    Toast.makeText(SignUp.this, "there a null values", Toast.LENGTH_LONG).show();
                }
                if(!ed_email.getText().toString().contains("@")){
                    Toast.makeText(SignUp.this, "The email must contain @", Toast.LENGTH_LONG).show();
                }
                if(ed_email.getText().toString().contains("@") && ed_password.getText().toString().equals(edConfirm_password.getText().toString())){
                    Toast.makeText(SignUp.this, "your enter a correct values", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUp.this, Registration_completed.class);
                startActivity(intent);
            }
             if(!(ed_password.getText().toString().equals(edConfirm_password.getText().toString()))){
                 Toast.makeText(SignUp.this, "password not the same", Toast.LENGTH_SHORT).show();
             }
            }
        });
        facebook =findViewById(R.id.facebook);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                startActivity(browserIntent);
            }
        });
        gmail =findViewById(R.id.gmail);

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                startActivity(browserIntent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}