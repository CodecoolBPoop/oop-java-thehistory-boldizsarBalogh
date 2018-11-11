package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
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
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList = Arrays.asList(text.split("\\s+"));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        ListIterator iterator = wordsLinkedList.listIterator();
        while(iterator.hasNext()){
            String word = (String)iterator.next();
            if(word.equals(wordToBeRemoved)){
                iterator.set("");
            }
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        int size = wordsLinkedList.size();
        return size;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList = new LinkedList<>();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        ListIterator iterator = wordsLinkedList.listIterator();
        while(iterator.hasNext()){
            String word = (String)iterator.next();
            if(word.equals(from)){
                iterator.set(to);
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
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
