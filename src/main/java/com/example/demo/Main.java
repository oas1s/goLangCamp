package com.example.demo;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("\"data\": [\n" +
                "        {\"key1\": \"value1\"},\n" +
                "        {\"key2\": \"value2\"}\n" +
                "    ]");
        stringBuilder.setCharAt(0,'{');
        stringBuilder.setCharAt(stringBuilder.length()-1, '}');
        System.out.println(stringBuilder);
    }
}
