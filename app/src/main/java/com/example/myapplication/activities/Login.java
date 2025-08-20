package com.example.myapplication.activities;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Login extends AppCompatActivity {

    TextView signUp;
    ImageView facebook;
    ImageView gmail;
    EditText ed_email;
    EditText ed_password;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        signUp = findViewById(R.id.sign_up);
        ed_email=findViewById(R.id.ed_email);
        ed_password=findViewById(R.id.ed_password);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
        loginButton = findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_email.getText().toString().isEmpty()|| ed_password.getText().toString().isEmpty()) {
                    Toast.makeText(Login.this, "you entered a null value", Toast.LENGTH_LONG).show();
                }
                else if(!ed_email.getText().toString().contains("@")){
                    Toast.makeText(Login.this, "The email must contain @", Toast.LENGTH_LONG).show();
                }
                 else if(ed_email.getText().toString().equals("hadeel@gmail.com")&& ed_password.getText().toString().equals("123")){
                    Toast.makeText(Login.this, "email and password valid", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, ListViewActivity.class);
                    startActivity(intent);
                }
               else{
                    Toast.makeText(Login.this, "you enter invalid password or email ", Toast.LENGTH_SHORT).show();
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
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com"));
                startActivity(browserIntent);
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sign_up), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}