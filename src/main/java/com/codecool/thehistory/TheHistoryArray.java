package com.codecool.thehistory;

import java.util.Arrays;
import java.util.regex.Pattern;

public class TheHistoryArray implements TheHistory {
    private String format(String[] arr){
        StringBuilder builder = new StringBuilder();
        for (String value : arr) {
            builder.append(value);
            builder.append(" ");
        }
        if (builder.length() > 0) builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }
    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information

        wordsArray = text.split("\\s+");



    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        for(int i = 0; i < wordsArray.length;i++){
            if(wordsArray[i].equals(wordToBeRemoved)){
                wordsArray[i] = "";
            }
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for(int i = 0; i <wordsArray.length;i++){
            if(wordsArray[i].equals(from)){
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String fromString = format(fromWords);
        String toString = format(toWords);
        String text = toString();
        String regex = "\\b" + fromString + "\\b";
        String result = text.replaceAll(regex, toString);
        add(result);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
