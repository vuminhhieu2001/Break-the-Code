package com.example.breakthecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VigenereCipher extends AppCompatActivity {
    EditText etInputVigenere, etKeyword;
    Button btnDecryptVigenere, btnEncryptVigenere;
    TextView tvOutputVigenere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigenere_cipher);

        etInputVigenere = findViewById(R.id.etInputVigenere);
        etKeyword = findViewById(R.id.etKeyword);
        btnDecryptVigenere = findViewById(R.id.btnDecryptVigenere);
        btnEncryptVigenere = findViewById(R.id.btnEncryptVigenere);
        tvOutputVigenere = findViewById(R.id.tvOutputVigenere);

        btnEncryptVigenere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputVigenere.getText().toString().trim();
                String keyword = etKeyword.getText().toString().trim().replace(" ", "");
                if (input.isEmpty()){
                    Toast.makeText(VigenereCipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else if (keyword.isEmpty()){
                    Toast.makeText(VigenereCipher.this, "Please enter the keyword!", Toast.LENGTH_SHORT).show();
                } else {
                    Vigenere vigenere = new Vigenere();
                    if (!vigenere.isValidKeyword(keyword)){
                        Toast.makeText(VigenereCipher.this, "The keyword is not valid. Please enter it again!", Toast.LENGTH_SHORT).show();
                    } else {
                        String output = vigenere.encode(input, keyword);
                        tvOutputVigenere.setText(output);
                        tvOutputVigenere.setVisibility(View.VISIBLE);
                        Toast.makeText(VigenereCipher.this, "Encode successfully!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnDecryptVigenere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputVigenere.getText().toString().trim();
                String keyword = etKeyword.getText().toString().trim().replace(" ", "");
                if (input.isEmpty()){
                    Toast.makeText(VigenereCipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else if (keyword.isEmpty()){
                    Toast.makeText(VigenereCipher.this, "Please enter the keyword!", Toast.LENGTH_SHORT).show();
                } else {
                    Vigenere vigenere = new Vigenere();
                    if (!vigenere.isValidKeyword(keyword)){
                        Toast.makeText(VigenereCipher.this, "The keyword is not valid. Please enter it again!", Toast.LENGTH_SHORT).show();
                    } else {
                        String output = vigenere.decode(input, keyword);
                        tvOutputVigenere.setText(output);
                        tvOutputVigenere.setVisibility(View.VISIBLE);
                        Toast.makeText(VigenereCipher.this, "Decode successfully!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}