package com.bumie.agric4good;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpBuyer extends AppCompatActivity {

    FirebaseAuth auth;
    String email, passwordId;
    EditText fN, lN, emailId, password, farmAdd, city, state, country, NIN, phoneNumber;
    Button btnSignup;
    TextView tvSignIn;
    DatabaseReference databaseReference;
    String user_email,user_password,user_fname,user_lname,user_nin,user_phone_number, user_city, user_state, user_country, user_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();

        defineView();
        addCLicklistener();
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpBuyer.this, MainActivity.class));

            }
        });

    }
    private void defineView(){
        fN = findViewById(R.id.edfname);
        lN = findViewById(R.id.edlname);
        emailId = (EditText) findViewById(R.id.edemail);
        password = findViewById(R.id.edpassword);
        farmAdd = (EditText) findViewById(R.id.edfaddress);
        NIN = findViewById(R.id.edNin);
        phoneNumber = findViewById(R.id.editTextPhone);
        btnSignup = findViewById(R.id.signup);
        tvSignIn = findViewById(R.id.login);
        city =findViewById(R.id.edCity);
        country = findViewById(R.id.edCountry);
        state=findViewById(R.id.edState);
    }

    private boolean validate(){
        boolean isValid=false;

        user_email = emailId.getText().toString();
        user_password = password.getText().toString();
        user_fname = fN.getText().toString();
        user_lname = lN.getText().toString();
        user_nin = NIN.getText().toString();
        user_phone_number = phoneNumber.getText().toString();
        user_city = city.getText().toString();
        user_country = country.getText().toString();
        user_state = state.getText().toString();
        user_location = farmAdd.getText().toString();
        if (TextUtils.isEmpty(user_email)) {
            emailId.setError("Please enter email");
            emailId.requestFocus();
        } else if (TextUtils.isEmpty(user_password)) {
            password.setError("Please enter your password");
            password.requestFocus();
        } else if (TextUtils.isEmpty(user_fname)) {
            password.setError("Please enter your full name");
            password.requestFocus();
        } else if (TextUtils.isEmpty(user_lname)) {
            password.setError("Please enter your password");
            password.requestFocus();
        } else if (TextUtils.isEmpty(user_nin)) {
            password.setError("Please enter your NIN");
            password.requestFocus();
        } else if (TextUtils.isEmpty(user_phone_number)) {
            password.setError("Please enter your phone number");
            password.requestFocus();
        } else if (TextUtils.isEmpty(user_location)) {
            password.setError("Please enter your full name");
            password.requestFocus();
        } else if (TextUtils.isEmpty(user_state)) {
            password.setError("Please enter your full name");
            password.requestFocus();
        } else if (TextUtils.isEmpty(user_city)) {
            password.setError("Please enter your full name");
            password.requestFocus();
        } else if (TextUtils.isEmpty(user_country)) {
            password.setError("Please enter your full name");
            password.requestFocus();
        }
        else
            isValid=true;
        return isValid;
    }

    private void addCLicklistener(){
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate())
                    registerUserToDatabse();
            }
        });

    }
    private void registerUserToDatabse() {

        try {
            auth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(SignUpBuyer.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Toast.makeText(SignUpBuyer.this, "Succesfully created user::email is:" + task.getResult().getUser().getEmail(), Toast.LENGTH_SHORT).show();
                    addUserInDatabse(task.getResult().getUser());
                }
            });
        } catch (Exception e) {
            Toast.makeText(SignUpBuyer.this, "Please connect to the internet", Toast.LENGTH_SHORT).show();

        }
    }
    private void addUserInDatabse(final FirebaseUser firebaseUser){

        String user_type = "farmer";
        User user=new User(user_type, user_fname, user_lname, user_email, user_phone_number, user_password, user_nin, user_location, user_city, user_state, user_country,firebaseUser.getUid());
        FirebaseDatabase.getInstance().getReference().child("all_users")
                .child(firebaseUser.getUid()).setValue(user);
        Toast.makeText(SignUpBuyer.this, "Succesfully added !", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(SignUpBuyer.this, MainActivity.class));

    }
}