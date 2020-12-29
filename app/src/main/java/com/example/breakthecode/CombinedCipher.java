package com.example.breakthecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CombinedCipher extends AppCompatActivity {
    EditText etInputCombined;
    Button btnEncryptCombined, btnDecryptCombined;
    TextView tvOutputCombined;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combined_cipher);

        etInputCombined = findViewById(R.id.etInputCombined);
        btnDecryptCombined = findViewById(R.id.btnDecryptCombined);
        btnEncryptCombined = findViewById(R.id.btnEncryptCombined);
        tvOutputCombined = findViewById(R.id.tvOutputCombined);

        btnEncryptCombined.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputCombined.getText().toString().trim();
                if (input.isEmpty()) {
                    Toast.makeText(CombinedCipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else {
                    Combined combined = new Combined();
                    if (!combined.detectInvalidText(input)){
                        Toast.makeText(CombinedCipher.this, "The input should not contain any number!", Toast.LENGTH_SHORT).show();
                    } else {
                        String output = combined.encode(input);
                        tvOutputCombined.setText(output);
                        tvOutputCombined.setVisibility(View.VISIBLE);
                        Toast.makeText(CombinedCipher.this, "Encode successfully!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnDecryptCombined.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputCombined.getText().toString().trim();
                if (input.isEmpty()) {
                    Toast.makeText(CombinedCipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else {
                    Combined combined = new Combined();
                    if (!combined.detectInvalidCode(input)){
                        Toast.makeText(CombinedCipher.this, "The input should not contain any letter and the number should be between 1 and 26!", Toast.LENGTH_SHORT).show();
                    } else {
                        String output = combined.decode(input);
                        tvOutputCombined.setText(output);
                        tvOutputCombined.setVisibility(View.VISIBLE);
                        Toast.makeText(CombinedCipher.this, "Decode successfully!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}