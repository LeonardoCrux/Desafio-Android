package com.example.desafioandroid.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.desafioandroid.R;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout inputNome, inputPassword, inputEmail, inputRepeat;
    private Button botaoRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        botaoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RestaurantesActivity.class));

            }
        });

    }

    private void initViews() {
        inputNome = findViewById(R.id.inputNomeRegister);
        inputEmail = findViewById(R.id.inputEmailRegister);
        inputPassword = findViewById(R.id.inputPasswordRegister);
        inputRepeat = findViewById(R.id.inputRepeatPassword);
        botaoRegister = findViewById(R.id.botaoRegister);
    }

    }
