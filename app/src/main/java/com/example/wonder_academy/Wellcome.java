package com.example.wonder_academy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wonder_academy.Loginform;
import com.example.wonder_academy.R;
import com.example.wonder_academy.SignupForm;

public class Wellcome extends AppCompatActivity {

    Button btnLogin, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellcome_main);

        btnLogin = findViewById(R.id.button);
        btnSignup = findViewById(R.id.button2);

        // LOGIN BUTTON → LoginActivity
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellcome.this, Loginform.class);
                startActivity(intent);
            }
        });

        // SIGN UP BUTTON → SignUpActivity
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wellcome.this, SignupForm.class);
                startActivity(intent);
            }
        });
    }
}
