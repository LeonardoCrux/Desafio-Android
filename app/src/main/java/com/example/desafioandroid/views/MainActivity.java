package com.example.desafioandroid.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.desafioandroid.R;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout inputEmail, inputSenha;
    private Button botaoLogin, botaoRegisterMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validacao();
            }
        });



        botaoRegisterMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });


    }

    private void initViews(){
        inputEmail = findViewById(R.id.inputEmailMain);
        inputSenha = findViewById(R.id.inputPasswordMain);
        botaoLogin= findViewById(R.id.botaoLogin);
        botaoRegisterMain = findViewById(R.id.botaoRegisterMain);
    }

    private void validacao() {
        String password =  inputEmail.getEditText().getText().toString();
        String senha = inputSenha.getEditText().getText().toString();
        if (!senha.isEmpty() && !password.isEmpty()) {
                startActivity(new Intent(getApplicationContext(), RestaurantesActivity.class));
            }
        else {
            Toast.makeText(getApplicationContext(), "Preencha os campos", Toast.LENGTH_LONG).show();
        }

    }
}