package com.example.desafioandroid.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.desafioandroid.R;
import com.google.android.material.textfield.TextInputLayout;

public class ProfileActivity extends AppCompatActivity {
    private TextInputLayout senha, emailProfile, confirmar, nomeProfile;
    private Button botaoSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initViews();

        botaoSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RestaurantesActivity.class));

            }
        });

    }

    private void initViews(){
        senha = findViewById(R.id.senhaProfile);
        confirmar = findViewById(R.id.confirmarProfile);
        botaoSave = findViewById(R.id.botaoSave);
        nomeProfile = findViewById(R.id.nomeProfile);
        emailProfile = findViewById(R.id.emailProfile);

    }

}
