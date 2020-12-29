package com.example.breakthecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HexCipher extends AppCompatActivity {
    EditText etInputHex;
    Button btnDecryptHex, btnEncryptHex;
    TextView tvOutputHex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex_cipher);

        etInputHex = findViewById(R.id.etInputHex);
        btnDecryptHex = findViewById(R.id.btnDecryptHex);
        btnEncryptHex = findViewById(R.id.btnEncryptHex);
        tvOutputHex = findViewById(R.id.tvOutputHex);

        btnEncryptHex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputHex.getText().toString().trim();
                if (input.isEmpty()){
                    Toast.makeText(HexCipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else {
                    Hex hex = new Hex();
                    String output = hex.encode(input);
                    tvOutputHex.setText(output);
                    tvOutputHex.setVisibility(View.VISIBLE);
                    Toast.makeText(HexCipher.this, "Encode successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDecryptHex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputHex.getText().toString().trim();
                if (input.isEmpty()){
                    Toast.makeText(HexCipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else {
                    Hex hex = new Hex();
                    if (!hex.checkValidCode(input)) {
                        Toast.makeText(HexCipher.this, "The input does not satisfy the requirements!", Toast.LENGTH_SHORT).show();
                    } else {
                        String output = hex.encode(input);
                        tvOutputHex.setText(output);
                        tvOutputHex.setVisibility(View.VISIBLE);
                        Toast.makeText(HexCipher.this, "Encode successfully!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}