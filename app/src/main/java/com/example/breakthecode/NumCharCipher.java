package com.example.breakthecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class NumCharCipher implements Cryptography {
    abstract char getDecodeChar(int num);
    abstract Integer getEncodeChar(char c);
    public List<List<String>> split_code(String code){
        List<List<String>> output = new ArrayList<>();
        String[] split1 = code.split(" ");
        for (String s : split1){
            List<String> out = Arrays.asList(s.split("-"));
            output.add(out);
        }
        return output;
    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public boolean detectInvalidCode(String code){
        StringBuilder curr = new StringBuilder();
        for (char c : code.toLowerCase().toCharArray()){
            if (97 <= c && c <= 122) return false;
        }
        for (char c : code.toCharArray()){
            String convert = String.valueOf(c);
            if (isNumeric(convert)) curr.append(convert);
            else {
                if (curr.length() > 0){
                    int num = Integer.parseInt(curr.toString());
                    if (num < 1 || num > 26) return false;
                    curr = new StringBuilder();
                }
            }
        }
        return true;
    }
    public String decode(String code){
        List<String> words = new ArrayList<>();
        List<List<String>> split = split_code(code);
        for (List<String> list : split){
            StringBuilder word = new StringBuilder();
            for (String s : list){
                if (s.length() < 3){
                    if (isNumeric(s)){
                        word.append(getDecodeChar(Integer.parseInt(s)));
                    } else if (isNumeric(s.substring(0, 1))) {
                        word.append(getDecodeChar(Integer.parseInt(s.substring(0, 1)))).append(s.substring(1));
                    } else {
                        word.append(s.substring(0, 1)).append(getDecodeChar(Integer.parseInt(s.substring(1))));
                    }
                } else if (s.length() == 3){
                    if (isNumeric(s.substring(2))){
                        word.append(getDecodeChar(Integer.parseInt(s.substring(0, 1)))).append(s.substring(1, 2)).append(getDecodeChar(Integer.parseInt(s.substring(2))));
                    } else if (isNumeric(s.substring(1, 2))) {
                        word.append(getDecodeChar(Integer.parseInt(s.substring(0, 2)))).append(s.substring(2));
                    } else {
                        word.append(getDecodeChar(Integer.parseInt(s.substring(0, 1)))).append(s.substring(1));
                    }
                } else if (s.length() == 4){
                    if (isNumeric(s.substring(1, 2))){
                        word.append(getDecodeChar(Integer.parseInt(s.substring(0, 2)))).append(s.substring(2, 3)).append(getDecodeChar(Integer.parseInt(s.substring(3))));
                    } else if (isNumeric(s.substring(2, 3))) {
                        word.append(getDecodeChar(Integer.parseInt(s.substring(0, 1)))).append(s.substring(1, 2)).append(getDecodeChar(Integer.parseInt(s.substring(2))));
                    } else {
                        word.append(getDecodeChar(Integer.parseInt(s.substring(0, 1)))).append(s.substring(1));
                    }
                } else {
                    word.append(getDecodeChar(Integer.parseInt(s.substring(0, 2)))).append(s.substring(2, 3)).append(getDecodeChar(Integer.parseInt(s.substring(3))));
                }
            }
            words.add(word.toString());
        }
        StringBuilder output = new StringBuilder();
        for (String s : words) output.append(s).append(" ");
        return output.toString().toUpperCase();
    }

    public boolean detectInvalidText(String word){
        for (char c : word.toCharArray()){
            if (isNumeric(String.valueOf(c))) return false;
        }
        return true;
    }

    public String encode(String word){
        String[] lower = word.toLowerCase().split(" ");
        List<String> result = new ArrayList<>();
        for (String s : lower){
            char[] arr = s.toCharArray();
            String[] new_arr = new String[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if ('a' <= arr[i] && arr[i] <= 'z'){
                    new_arr[i] = getEncodeChar(arr[i]).toString();
                } else {
                    new_arr[i] = String.valueOf(arr[i]);
                }
            }
            StringBuilder numString = new StringBuilder(new_arr[0]);
            for (int i = 0; i < arr.length - 1; i++) {
                if (isNumeric(new_arr[i]) && isNumeric(new_arr[i + 1])){
                    numString.append("-").append(new_arr[i + 1]);
                } else {
                    numString.append(new_arr[i + 1]);
                }
            }
            result.add(numString.toString());
        }
        StringBuilder output = new StringBuilder();
        for (String s : result) output.append(s).append(" ");
        return output.toString().toUpperCase();
    }
}
class A1Z26 extends NumCharCipher {
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public char getDecodeChar(int num){
        return alphabet.charAt(num - 1);
    }
    public Integer getEncodeChar(char c){
        return alphabet.indexOf(c) + 1;
    }
}
class Combined extends NumCharCipher {
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    @Override
    public char getDecodeChar(int num) {
        int newIndex1 = 26 - num;
        int newIndex2 = (newIndex1 + 23) % 26;
        return alphabet.charAt(newIndex2);
    }

    @Override
    public Integer getEncodeChar(char c) {
        if (c == 'x'){
            return 26;
        } else if (c == 'y'){
            return 25;
        } else if (c == 'z'){
            return 24;
        } else {
            return 23 - alphabet.indexOf(c);
        }
    }
}



