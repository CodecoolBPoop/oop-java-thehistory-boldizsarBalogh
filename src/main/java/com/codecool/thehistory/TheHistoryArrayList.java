package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
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
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        wordsArrayList = Arrays.asList(text.split("\\s+"));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        ListIterator iterator = wordsArrayList.listIterator();
        while(iterator.hasNext()){
            String word = (String)iterator.next();
            if(wordToBeRemoved.equals(word)) {
                iterator.set("");
            }
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        final int size = wordsArrayList.size();
        return size;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList = new ArrayList<>();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
       for(int i =  0; i < wordsArrayList.size();i++){
            if(wordsArrayList.get(i).equals(from)){
                wordsArrayList.set(i,to);
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
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
