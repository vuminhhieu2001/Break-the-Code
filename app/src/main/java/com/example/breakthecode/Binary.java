package com.example.breakthecode;

public class Binary implements Cryptography{
    public String decToBin(int num){
        String output = Integer.toBinaryString(num);
        int need = 8 - output.length();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < need; i++) {
            s.append(0);
        }
        s.append(output);
        return s.toString();
    }

    @Override
    public String encode(String s){
        StringBuilder output = new StringBuilder();
        for (char c : s.toCharArray()){
            output.append(decToBin(c));
        }
        return output.toString();
    }

    public boolean checkValidCode(String s){
        if (s.length() % 8 != 0) return false;
        for (char c : s.toCharArray()){
            if (c != '0' && c != '1') return false;
        }
        return true;
    }

    @Override
    public String decode(String s){
        int letter = s.length() / 8;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < letter; i++) {
            output.append((char) Integer.parseInt(s.substring(8 * i, 8 * i + 8), 2));
        }
        return output.toString();
    }
}
