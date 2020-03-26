package com.example.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private  EditText password;
    private TextView info;
    private Button login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.etUsername);
        password = (EditText)findViewById((R.id.etPassword));
        info = (TextView)findViewById(R.id.etAttempts);
        login = (Button) findViewById(R.id.btnLogin);

        info.setText("Number of attempts remaining: 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(name.getText().toString(), password.getText().toString());
            }
        });

    }

    private void Validate(String username, String password){
        if((username == "admin") && (password== "password")){
            Intent intent = new Intent(MainActivity.this, secondAvtivity.class);
            startActivity(intent);
        } else {
            counter--;

            info.setText("Number of attempts remaining:  "+String.valueOf(counter));

            if (counter==0){
                login.setEnabled(false);
            }
        }
    }
}
