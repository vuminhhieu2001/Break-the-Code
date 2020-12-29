package com.example.breakthecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CaesarCipher extends AppCompatActivity {
    EditText etInputCaesar, etShiftAmount;
    Button btnEncryptCaesar, btnDecryptCaesar;
    TextView tvOutputCaesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar_cipher);

        etInputCaesar = findViewById(R.id.etInputCaesar);
        etShiftAmount = findViewById(R.id.etShiftAmount);
        btnEncryptCaesar = findViewById(R.id.btnEncryptCaesar);
        btnDecryptCaesar = findViewById(R.id.btnDecryptCaesar);
        tvOutputCaesar = findViewById(R.id.tvOutputCaesar);


        btnEncryptCaesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputCaesar.getText().toString().trim();
                String shift = etShiftAmount.getText().toString().trim();
                if (input.isEmpty()){
                    Toast.makeText(CaesarCipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else if (shift.isEmpty()){
                    Toast.makeText(CaesarCipher.this, "Please enter a number (1 - 25)!", Toast.LENGTH_SHORT).show();
                } else {
                    int amt = Integer.parseInt(shift);
                    if (amt < 1 || amt > 25){
                        Toast.makeText(CaesarCipher.this, "Please enter a number (1 - 25)!", Toast.LENGTH_SHORT).show();
                    }
                    Caesar caesar = new Caesar(amt);
                    String output = caesar.encode(input);
                    tvOutputCaesar.setText(output);
                    tvOutputCaesar.setVisibility(View.VISIBLE);
                    Toast.makeText(CaesarCipher.this, "Encode successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDecryptCaesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInputCaesar.getText().toString().trim();
                String shift = etShiftAmount.getText().toString().trim();
                if (input.isEmpty()){
                    Toast.makeText(CaesarCipher.this, "Please enter the input text!", Toast.LENGTH_SHORT).show();
                } else if (shift.isEmpty()){
                    Toast.makeText(CaesarCipher.this, "Please enter a number (1 - 25)!", Toast.LENGTH_SHORT).show();
                } else {
                    int amt = Integer.parseInt(shift);
                    if (amt < 1 || amt > 25){
                        Toast.makeText(CaesarCipher.this, "Please enter a number (1 - 25)!", Toast.LENGTH_SHORT).show();
                    }
                    Caesar caesar = new Caesar(amt);
                    String output = caesar.decode(input);
                    tvOutputCaesar.setText(output);
                    tvOutputCaesar.setVisibility(View.VISIBLE);
                    Toast.makeText(CaesarCipher.this, "Decode successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}