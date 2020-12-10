package com.bumie.agric4good;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email2, password2;
    Button btnLogin;
    TextView tvSignup, fPwd;
    FirebaseAuth loginAuth;
    String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginAuth = FirebaseAuth.getInstance();
        if (loginAuth.getCurrentUser().getUid() != null) {
            startActivity(new Intent(MainActivity.this, UserSelection.class));
        }

        email2 = (EditText) findViewById(R.id.email);
        password2 = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnSignin);
        tvSignup = findViewById(R.id.signup);
        fPwd = findViewById(R.id.fpass);
        addClickListener();
    }
    private void addClickListener(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid())
                    login();
            }
        });
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent=new Intent(MainActivity.this,UserSelection.class);
                startActivity(signupIntent);
            }
        });
    }
    private boolean isValid(){
        boolean isValid=false;

        email = email2.getText().toString();
        password = password2.getText().toString();

        if (TextUtils.isEmpty(email)) {
            email2.setError("Please enter email");
            email2.requestFocus();
        }
        else if (TextUtils.isEmpty(password)) {
            password2.setError("Please enter your password");
            password2.requestFocus();
        }
        else
            isValid=true;
        return isValid;
    }

    private void login(){
        loginAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    //  String options = getIntent().getExtras().get("Choice").toString();
                    Toast.makeText(MainActivity.this, "Main Activity", Toast.LENGTH_SHORT).show();
                    Intent mainIntent=new Intent(MainActivity.this,UserSelection.class);
                    startActivity(mainIntent);
                }else{
                    Toast.makeText(MainActivity.this, "error:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

}