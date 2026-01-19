package com.example.wonder_academy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupForm extends AppCompatActivity {

    EditText edtFirstname, edtFamilyname, edtCreateUser, edtPassword,
            edtConfirmPassword, edtPhone, edtEmail;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_main);

        edtFirstname = findViewById(R.id.edtFirstname);
        edtFamilyname = findViewById(R.id.edtFamilyname);
        edtCreateUser = findViewById(R.id.edtCreateUser);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstname = edtFirstname.getText().toString().trim();
                String familyname = edtFamilyname.getText().toString().trim();
                String username = edtCreateUser.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String confirmPass = edtConfirmPassword.getText().toString().trim();
                String phone = edtPhone.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();


                if (firstname.isEmpty()) {
                    Toast.makeText(SignupForm.this, "Enter the Firstname!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (familyname.isEmpty()) {
                    Toast.makeText(SignupForm.this, "Enter the Family name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (username.isEmpty()) {
                    Toast.makeText(SignupForm.this, "Create Username!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(SignupForm.this, "Create Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (confirmPass.isEmpty()) {
                    Toast.makeText(SignupForm.this, "Confirm Password!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (phone.isEmpty()) {
                    Toast.makeText(SignupForm.this, "Enter PhoneNumber!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.isEmpty()) {
                    Toast.makeText(SignupForm.this, "Enter Email!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (!password.equals(confirmPass)) {
                    Toast.makeText(SignupForm.this, "The Password is not Confirmed!", Toast.LENGTH_SHORT).show();
                    return;
                }


                Toast.makeText(SignupForm.this,
                        "Registration successfully completed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
