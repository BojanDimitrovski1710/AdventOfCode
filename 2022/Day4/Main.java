package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Main {

    public static ArrayList<Character> repeats = new ArrayList<>();
    public static ArrayList<Character> badges = new ArrayList<>();
    public static int lowercaseCoef = 96;
    public static int uppercaseCoef = 38;

    public static char checkGroup(String p1, String p2, String p3){
        for(int i=0; i<p1.length(); i++){
            Character currChar = p1.charAt(i);
            if(p2.contains(String.valueOf(currChar)) && p3.contains(String.valueOf(currChar))){
                return currChar;
            }
        }
        return '.';
    }

    public static void checkPack(String pack){
        ArrayList<Character> part1 = new ArrayList<>();
        ArrayList<Character> part2 = new ArrayList<>();
        ArrayList<Character> localRepeats = new ArrayList<>();
        for(int i=0; i< pack.length(); i++){
            if(i<pack.length()/2){
                part1.add(pack.charAt(i));
            }else{
                part2.add(pack.charAt(i));
            }
        }
        for(int i=0; i< part1.size(); i++){
            Character currChar = part1.get(i);
            if(part2.contains(currChar) && !localRepeats.contains(currChar)){
                repeats.add(currChar);
                localRepeats.add(currChar);
            }
        }
    }
    
    public static void part1(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        int j=0;
        while(line!=null){
            checkPack(line);
            line = reader.readLine();
        }
        int result =0;
        for(int i=0; i<repeats.size(); i++){
            Character currChar = repeats.get(i);
            //System.out.println("Repeat in " + i + " : " + currChar);
            if(Character.isUpperCase(currChar)){
                result+= (int) currChar - uppercaseCoef;
            }else{
                result+= (int) currChar - lowercaseCoef;
            }
        }
        System.out.println(result);
    }

    public static void part2(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        int result = 0;
        while(line!=null){
            String part1 = line;
            String part2 = reader.readLine();
            String part3 = reader.readLine();
            line = reader.readLine();
            Character badge = checkGroup(part1, part2, part3);
            badges.add(badge);
        }
        for(int i=0; i<badges.size(); i++){
            Character currChar = badges.get(i);
            System.out.println("Badges in " + i + " : " + currChar);
            if(Character.isUpperCase(currChar)){
                result+= (int) currChar - uppercaseCoef;
            }else{
                result+= (int) currChar - lowercaseCoef;
            }
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
