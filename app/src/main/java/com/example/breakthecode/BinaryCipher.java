package com.example.breakthecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BinaryCipher extends AppCompatActivity {
    EditText etInputBinary;
    Button btnDecryptBinary, btnEncryptBinary;
    TextView tvOutputBinary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_cipher);

        etInputBinary = findViewById(R.id.etInputBinary);
        btnDecryptBinary = findViewById(R.id.btnDecryptBinary);
        btnEncryptBinary = findViewById(R.id.btnEncryptBinary);
        tvOutputBinary = findViewById(R.id.tvOutputBinary);

        btnEncryptBinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputBinary.getText().toString().trim();
                if (input.isEmpty()){
                    Toast.makeText(BinaryCipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else {
                    Binary binary = new Binary();
                    String output = binary.encode(input);
                    tvOutputBinary.setText(output);
                    tvOutputBinary.setVisibility(View.VISIBLE);
                    Toast.makeText(BinaryCipher.this, "Encode successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDecryptBinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputBinary.getText().toString().trim();
                if (input.isEmpty()){
                    Toast.makeText(BinaryCipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else {
                    Binary binary = new Binary();
                    if (!binary.checkValidCode(input)){
                        Toast.makeText(BinaryCipher.this, "The input does not satisfy the requirements!", Toast.LENGTH_SHORT).show();
                    } else {
                        String output = binary.decode(input);
                        tvOutputBinary.setText(output);
                        tvOutputBinary.setVisibility(View.VISIBLE);
                        Toast.makeText(BinaryCipher.this, "Decode successfully!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}