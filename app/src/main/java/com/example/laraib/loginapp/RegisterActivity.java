package com.example.laraib.loginapp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText newUser,userPassword,Email;
    private Button Register;
    private TextView UserLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        newUser = (EditText)findViewById(R.id.etUserName);
        userPassword =(EditText)findViewById(R.id.etUserPassword);
        Email =(EditText)findViewById(R.id.etUserEmail);
        Register = (Button)findViewById(R.id.btnRegister);
        UserLogin = (TextView)findViewById(R.id.tvUserLogin);

        firebaseAuth = FirebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate() )
                {

                    String User_email = Email.getText().toString().trim();
                    String User_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(User_email,User_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                Toast.makeText(RegisterActivity.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                            }else {
                                Toast.makeText(RegisterActivity.this, "Registration UnSuccessfull", Toast.LENGTH_SHORT).show();
                                }
                            }

                    });
                }
            }
        });


        UserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });

    }

    private Boolean validate(){

        Boolean result = false;

        String name = newUser.getText().toString();
        String password = userPassword.getText().toString();
        String email = Email.getText().toString();

        if(name.isEmpty() || password.isEmpty() || email.isEmpty()){

            Toast.makeText(this,"please enter all the details",Toast.LENGTH_SHORT).show();
        }else
        {

            result = true;
        }
        return result;


    }

}
