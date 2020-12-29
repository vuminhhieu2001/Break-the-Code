package com.example.breakthecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AtbashCipher extends AppCompatActivity {
    EditText etInputAtbash;
    Button btnEncryptAtbash, btnDecryptAtbash;
    TextView tvOutputAtbash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atbash_cipher);

        etInputAtbash = findViewById(R.id.etInputAtbash);
        btnDecryptAtbash = findViewById(R.id.btnDecryptAtbash);
        btnEncryptAtbash = findViewById(R.id.btnEncryptAtbash);
        tvOutputAtbash = findViewById(R.id.tvOutputAtbash);

        btnEncryptAtbash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputAtbash.getText().toString().trim();
                if (input.isEmpty()){
                    Toast.makeText(AtbashCipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else {
                    Atbash atbash = new Atbash();
                    String output = atbash.encode(input);
                    tvOutputAtbash.setText(output);
                    tvOutputAtbash.setVisibility(View.VISIBLE);
                    Toast.makeText(AtbashCipher.this, "Encode successfully!", Toast.LENGTH_SHORT).show();
;                }
            }
        });

        btnDecryptAtbash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputAtbash.getText().toString().trim();
                if (input.isEmpty()){
                    Toast.makeText(AtbashCipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else {
                    Atbash atbash = new Atbash();
                    String output = atbash.decode(input);
                    tvOutputAtbash.setText(output);
                    tvOutputAtbash.setVisibility(View.VISIBLE);
                    Toast.makeText(AtbashCipher.this, "Decode successfully!", Toast.LENGTH_SHORT).show();
                    ;                }
            }
        });

    }
}