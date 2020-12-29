package com.example.breakthecode;
import java.util.HashSet;

public class Hex implements Cryptography{
    String hexCode = "0123456789abcdef";
    public boolean checkValidCode(String code){
        if (code.length() % 2 != 0) return false;
        HashSet<Character> set = new HashSet<>();
        for (char c : hexCode.toCharArray()) set.add(c);
        for (char c : code.toLowerCase().toCharArray()){
            if (!set.contains(c)) return false;
        }
        return true;
    }

    @Override
    public String decode(String code) {
        StringBuilder output = new StringBuilder();
        int letter = code.length() / 2;
        for (int i = 0; i < letter; i++) {
            output.append((char) Integer.parseInt(code.substring(2 * i, 2 * i + 2), 16));
        }
        return output.toString();
    }

    @Override
    public String encode(String word) {
        StringBuilder output = new StringBuilder();
        for (char c : word.toLowerCase().toCharArray()){
            String hex = Integer.toHexString(c);
            if (hex.length() == 1) output.append(0).append(hex);
            else output.append(hex);
        }
        return output.toString();
    }
}
