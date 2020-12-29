package com.example.breakthecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class A1Z26Cipher extends AppCompatActivity {
    EditText etInputA1Z26;
    Button btnEncryptA1Z26, btnDecryptA1Z26;
    TextView tvOutputA1Z26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_z26_cipher);

        etInputA1Z26 = findViewById(R.id.etInputA1Z26);
        btnDecryptA1Z26 = findViewById(R.id.btnDecryptA1Z26);
        btnEncryptA1Z26 = findViewById(R.id.btnEncryptA1Z26);
        tvOutputA1Z26 = findViewById(R.id.tvOutputA1Z26);

        btnEncryptA1Z26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputA1Z26.getText().toString().trim();
                if (input.isEmpty()) {
                    Toast.makeText(A1Z26Cipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else {
                    A1Z26 a1Z26 = new A1Z26();
                    if (!a1Z26.detectInvalidText(input)){
                        Toast.makeText(A1Z26Cipher.this, "The input should not contain any number!", Toast.LENGTH_SHORT).show();
                    } else {
                        String output = a1Z26.encode(input);
                        tvOutputA1Z26.setText(output);
                        tvOutputA1Z26.setVisibility(View.VISIBLE);
                        Toast.makeText(A1Z26Cipher.this, "Encode successfully!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnDecryptA1Z26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputA1Z26.getText().toString().trim();
                if (input.isEmpty()) {
                    Toast.makeText(A1Z26Cipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else {
                    A1Z26 a1Z26 = new A1Z26();
                    if (!a1Z26.detectInvalidCode(input)){
                        Toast.makeText(A1Z26Cipher.this, "The input should not contain any letter and the number should be between 1 and 26!", Toast.LENGTH_SHORT).show();
                    } else {
                        String output = a1Z26.decode(input);
                        tvOutputA1Z26.setText(output);
                        tvOutputA1Z26.setVisibility(View.VISIBLE);
                        Toast.makeText(A1Z26Cipher.this, "Decode successfully!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}