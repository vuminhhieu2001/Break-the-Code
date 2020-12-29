package com.example.breakthecode;

abstract class CharToCharCipher implements Cryptography {
    abstract char getDecodeChar(char c);
    abstract char getEncodeChar(char c);
    public String decode(String code){
        StringBuilder result = new StringBuilder();
        char[] list = code.toCharArray();
        for (char c : list){
            if ('a' <= c && c <= 'z'){
                result.append(getDecodeChar(c));
            } else if ('A' <= c && c <= 'Z'){
                int lower = c + 32;
                int add =  getDecodeChar((char) lower) - 32;
                result.append((char) add);
            }
            else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public String encode(String word){
        StringBuilder result = new StringBuilder();
        char[] list = word.toCharArray();
        for (char c : list){
            if ('a' <= c && c <= 'z'){
                result.append(getEncodeChar(c));
            } else if ('A' <= c && c <= 'Z'){
                int lower = c + 32;
                int add =  getEncodeChar((char) lower) - 32;
                result.append((char) add);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
class Caesar extends CharToCharCipher{
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    int shiftAmount;

    public Caesar(int shiftAmount) {
        this.shiftAmount = shiftAmount;
    }

    @Override
    public char getDecodeChar(char c){
        int index = alphabet.indexOf(c);
        int new_index = (index - this.shiftAmount) % 26;
        if (new_index < 0){
            new_index += 26;
        }
        return alphabet.charAt(new_index);
    }

    @Override
    public char getEncodeChar(char c){
        int index = alphabet.indexOf(c);
        int new_index = (index + this.shiftAmount) % 26;
        return alphabet.charAt(new_index);
    }
}
class Atbash extends CharToCharCipher {
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public char getDecodeChar(char c){
        int index = alphabet.indexOf(c);
        int new_index = 25 - index;
        return alphabet.charAt(new_index);
    }

    @Override
    public char getEncodeChar(char c){
        int index = alphabet.indexOf(c);
        int new_index = 25 - index;
        return alphabet.charAt(new_index);
    }
}

