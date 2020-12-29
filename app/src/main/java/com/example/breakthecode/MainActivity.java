package com.example.breakthecode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CipherAdapter.ItemClicked {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ImageView logo, billWheel;
    TextView additional;

    ArrayList<CipherType> ciphers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.GFLogo);
        billWheel = findViewById(R.id.billWheel);
        additional = findViewById(R.id.additional);
        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ciphers = new ArrayList<>();
        ciphers.add(new CipherType("Caesar"));
        ciphers.add(new CipherType("Atbash"));
        ciphers.add(new CipherType("A1Z26"));
        ciphers.add(new CipherType("Combined"));
        ciphers.add(new CipherType("Vigenere"));
        ciphers.add(new CipherType("Binary"));
        ciphers.add(new CipherType("Hex"));
        ciphers.add(new CipherType("Morse"));

        myAdapter = new CipherAdapter(this, ciphers);
        recyclerView.setAdapter(myAdapter);

        billWheel.setVisibility(View.GONE);
        additional.setVisibility(View.GONE);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billWheel.setVisibility(View.VISIBLE);
                additional.setVisibility(View.VISIBLE);
            }
        });

        billWheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdditionalInformation.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClicked(int index) {
        String type = ciphers.get(index).getCipherType();
        if (type.equals("Caesar")){
            Intent intent = new Intent(MainActivity.this, CaesarCipher.class);
            startActivity(intent);
        } else if (type.equals("Atbash")) {
            Intent intent = new Intent(MainActivity.this, AtbashCipher.class);
            startActivity(intent);
        } else if (type.equals("A1Z26")) {
            Intent intent = new Intent(MainActivity.this, A1Z26Cipher.class);
            startActivity(intent);
        } else if (type.equals("Combined")) {
            Intent intent = new Intent(MainActivity.this, CombinedCipher.class);
            startActivity(intent);
        } else if (type.equals("Vigenere")) {
            Intent intent = new Intent(MainActivity.this, VigenereCipher.class);
            startActivity(intent);
        } else if (type.equals("Binary")) {
            Intent intent = new Intent(MainActivity.this, BinaryCipher.class);
            startActivity(intent);
        } else if (type.equals("Hex")) {
            Intent intent = new Intent(MainActivity.this, HexCipher.class);
            startActivity(intent);
        } else if (type.equals("Morse")){
            Intent intent = new Intent(MainActivity.this, MorseCipher.class);
            startActivity(intent);
        }
        billWheel.setVisibility(View.GONE);
        additional.setVisibility(View.GONE);
    }
}