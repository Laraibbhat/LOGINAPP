package com.example.laraib.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int Counter=5;
    private TextView UserRegistration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);
        UserRegistration = (TextView)findViewById(R.id.tvRegister);

        Info.setText("Number of attempts remaining : 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                platform(Name.getText().toString(),Password.getText().toString());
            }
        });

        UserRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , RegisterActivity.class));
            }
        });

    }

    private void platform(String Username,String Password){


        if((Username.equals("Admin"))&& (Password.equals("1234"))){


            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }else{

            Counter--;
            Info.setText("Number of attempts reamaing" + String.valueOf(Counter));

            if(Counter==0){
                Login.setEnabled(false);
            }
        }
    }
}
