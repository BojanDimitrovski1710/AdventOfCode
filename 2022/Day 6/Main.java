package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Main {

    public static int findMarker(String s, int depth){
        for(int i=depth+1; i<s.length(); i++){
            ArrayList<Character> seenCharacters = new ArrayList<>();
            boolean ready = true;
            for(int j=i; j>=i-depth+1; j--){
                Character currChar = s.charAt(j);
                if(!seenCharacters.contains(currChar)){
                    seenCharacters.add(currChar);
                }else{
                    ready = false;
                }
            }
            if(ready){
                return i+1;
            }
        }
        return -1;
    }

    public static void part1(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        int result = 0;
        while(line!=null){
            result = findMarker(line, 4);
            line = reader.readLine();
        }
        System.out.println(result);
    }

    public static void part2(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        int result = 0;
        while(line!=null){
            result = findMarker(line, 14);
            line = reader.readLine();
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {;
        String path = "\\Users\\Bojan\\Desktop\\AdventOfCode\\src\\com\\company\\input.txt";
        System.out.println("Part 1:");
        part1(path);
        System.out.println("Part 2:");
        part2(path);
    }
}
