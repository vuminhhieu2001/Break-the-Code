package com.example.breakthecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MorseCipher extends AppCompatActivity {
    EditText etInputMorse;
    Button btnDecryptMorse, btnEncryptMorse;
    TextView tvOutputMorse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse_cipher);

        etInputMorse = findViewById(R.id.etInputMorse);
        btnDecryptMorse = findViewById(R.id.btnDecryptMorse);
        btnEncryptMorse = findViewById(R.id.btnEncryptMorse);
        tvOutputMorse = findViewById(R.id.tvOutputMorse);

        btnEncryptMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputMorse.getText().toString().trim();
                if (input.isEmpty()){
                    Toast.makeText(MorseCipher.this, "Please enter the input!", Toast.LENGTH_SHORT).show();
                } else {
                    Morse morse = new Morse();
                    String output = morse.encode(input);
                    if (output.charAt(0) == '0'){
                        Toast.makeText(MorseCipher.this, output.substring(1), Toast.LENGTH_SHORT).show();
                    } else {
                        tvOutputMorse.setText(output.substring(1));
                        tvOutputMorse.setVisibility(View.VISIBLE);
                        Toast.makeText(MorseCipher.this, "Encode successfully!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnDecryptMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputMorse.getText().toString().trim();
                if (input.isEmpty()){
                    Toast.makeText(MorseCipher.this, "Please enter the input!", Toast.LENGTH_SHORT).show();
                } else {
                    Morse morse = new Morse();
                    if (!morse.checkValidCode(input)){
                        Toast.makeText(MorseCipher.this, "The input should only contain ., -, / and space character", Toast.LENGTH_SHORT).show();
                    }
                    String output = morse.decode(input);
                    if (output.charAt(0) == '0'){
                        Toast.makeText(MorseCipher.this, output.substring(1), Toast.LENGTH_SHORT).show();
                    } else {
                        tvOutputMorse.setText(output.substring(1));
                        tvOutputMorse.setVisibility(View.VISIBLE);
                        Toast.makeText(MorseCipher.this, "Decode successfully!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}