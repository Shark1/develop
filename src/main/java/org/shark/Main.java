package org.shark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.shark.CalculateOperation.getResult;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] name = reader.readLine().split(" ");

        try {
            System.out.println(getResult(ArabicRomanNumbers.valueOf(name[0]), name[1], ArabicRomanNumbers.valueOf(name[2])));
        } catch (IllegalArgumentException e) {
            System.out.println(getResult(Integer.parseInt(name[0]), name[1], Integer.parseInt(name[2])));
        }

    }
}