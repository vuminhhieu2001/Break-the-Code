package com.example.breakthecode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Morse implements Cryptography{
    String[] letters  = { " ", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0","b", "c","f","h", "j", "l",  "p", "q", "v", "x",
            "y", "z", "u", "w", "g", "d", "k", "o", "r", "s", "a", "i",
            "m", "n", "t", "e", ".", ",", "?", "'", "!", "/", "(", ")",
            "&", ":", ";", "=", "+", "-", "_", "$", "@"};
    String[] morse = { "/", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----",
            //b      c       f       h      j      l     p      q       v       x      y       z
            "-...","-.-.", "..-.","....",".---",".-..",".--.","--.-", "...-","-..-","-.--","--..",
            //u       w      g      d      k     o     r       s
            "..-",  ".--", "--.", "-..", "-.-","---",".-.", "...",
            //a     i     m     n
            ".-", "..", "--", "-.",
            // t  e      .         ,          ?        '          !        /
            "-", ".", ".-.-.-", "--..--", "..--..", ".----.", "-.-.--", "-..-.",
            // (        )         &       :          ;        =       +            -        _           $       @
            "-.--.", "-.--.-", ".-...", "---...", "-.-.-.", "-...-", ".-.-.", "-....-", "..--.-", "...-..-", ".--.-."};

    @Override
    public String decode(String code) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            map.put(morse[i], letters[i]);
        }
        StringBuilder output = new StringBuilder();
        String[] words = code.split(" ");
        for (String s : words) {
            if (!map.containsKey(s))
                return "0There is no letter corresponding to '" + s + "' morse code";
            else
                output.append(map.get(s));
        }
        return "1" + output.toString().toUpperCase();
    }

    public boolean checkValidCode(String s){
        for (char c : s.toCharArray()){
            if (c != '.' && c != '-' && c != ' ' && c != '/') return false;
        }
        return true;
    }

    @Override
    public String encode(String word) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            map.put(letters[i], morse[i]);
        }
        List<String> list = new ArrayList<>();
        for (char c : word.toLowerCase().toCharArray()){
            if (!map.containsKey(String.valueOf(c)))
                return "0There is no morse code for " + c;
            else
                list.add(map.get(String.valueOf(c)));
        }
        StringBuilder output = new StringBuilder();
        for (String s : list) output.append(s).append(" ");
        return "1" + output.toString();
    }
}

