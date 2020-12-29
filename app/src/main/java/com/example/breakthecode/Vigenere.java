package com.example.breakthecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Vigenere{
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public char getDecodeChar(char code, char keyword){
        int indexCode = alphabet.indexOf(code);
        int indexKey = alphabet.indexOf(keyword);
        int indexDecode = (indexCode - indexKey + 26) % 26;
        return alphabet.charAt(indexDecode);
    }

    public char getEncodeChar(char code, char keyword){
        int indexCode = alphabet.indexOf(code);
        int indexKey = alphabet.indexOf(keyword);
        int indexEncode = (indexCode + indexKey) % 26;
        return alphabet.charAt(indexEncode);
    }

    public boolean isValidKeyword(String keyword){
        for (char c : keyword.toCharArray()){
            if (! (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z'))) return false;
        }
        return true;
    }
    public String decode(String code, String keyword){
        char[] keywordSeq = keyword.toLowerCase().toCharArray();
        char[] newCodeSeq = code.toCharArray();
        List<Character> needToDecode = new ArrayList<>();
        List<Character> output = new ArrayList<>();
        HashMap<Integer, Character> nonWord = new HashMap<>();
        for (int i = 0; i < newCodeSeq.length; i++) {
            char c = newCodeSeq[i];
            if (! (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z'))){
                nonWord.put(i, c);
            } else {
                needToDecode.add(c);
            }
        }
        for (int i = 0; i < needToDecode.size(); i++) {
            char curr = needToDecode.get(i);
            if (97 <= curr && curr <= 122) {
                char res = getDecodeChar(curr, keywordSeq[i % keywordSeq.length]);
                output.add(res);
            } else {
                char lower = (char) (curr + 32);
                char res = (char) (getDecodeChar(lower, keywordSeq[i % keywordSeq.length]) - 32);
                output.add(res);
            }
        }
        List<Integer> list = new ArrayList<>(nonWord.keySet());
        Collections.sort(list);
        for (Integer i : list){
            output.add(i, nonWord.get(i));
        }
        StringBuilder finalOutput = new StringBuilder();
        for (char c : output){
            finalOutput.append(c);
        }
        return finalOutput.toString();
    }

    public String encode(String code, String keyword){
        char[] keywordSeq = keyword.toLowerCase().toCharArray();
        char[] newCodeSeq = code.toCharArray();
        List<Character> needToEncode = new ArrayList<>();
        List<Character> output = new ArrayList<>();
        HashMap<Integer, Character> nonWord = new HashMap<>();
        for (int i = 0; i < newCodeSeq.length; i++) {
            char c = newCodeSeq[i];
            if (! (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z'))){
                nonWord.put(i, c);
            } else {
                needToEncode.add(c);
            }
        }
        for (int i = 0; i < needToEncode.size(); i++) {
            char curr = needToEncode.get(i);
            if (97 <= curr && curr <= 122) {
                char res = getEncodeChar(curr, keywordSeq[i % keywordSeq.length]);
                output.add(res);
            } else {
                char lower = (char) (curr + 32);
                char res = (char) (getEncodeChar(lower, keywordSeq[i % keywordSeq.length]) - 32);
                output.add(res);
            }
        }
        List<Integer> list = new ArrayList<>(nonWord.keySet());
        Collections.sort(list);
        for (Integer i : list){
            output.add(i, nonWord.get(i));
        }
        StringBuilder finalOutput = new StringBuilder();
        for (char c : output){
            finalOutput.append(c);
        }
        return finalOutput.toString();
    }
}


