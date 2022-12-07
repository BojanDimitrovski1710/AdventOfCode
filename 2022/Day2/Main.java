package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Main {

    public static int basePoints(String s){
        switch (s){
            case "A":
            case "X":
                return 1;
            case "B":
            case "Y":
                return 2;
            case "C":
            case "Z":
                return 3;
        }
        return 0;
    }

    public static int result(String[] s){
        switch (s[0]){
            case "A":
                switch (s[1]){
                    case "X":
                        return 0;
                    case "Y":
                        return 1;
                    case "Z":
                        return -1;
                }
            case "B":
                switch (s[1]){
                    case "X":
                        return -1;
                    case "Y":
                        return 0;
                    case "Z":
                        return 1;
                }
            case "C":
                switch (s[1]){
                    case "X":
                        return 1;
                    case "Y":
                        return -1;
                    case "Z":
                        return 0;
                }
        }
        return -5;
    }

    public static void part1(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        int p1Points=0;
        int p2Points=0;
        while(line!=null){
            String[] players = line.split(" ");
            p1Points += basePoints(players[0]);
            p2Points += basePoints(players[1]);
            switch (result(players)){
                case -1:
                    p1Points += 6;
                    break;
                case 0:
                    p1Points += 3;
                    p2Points += 3;
                    break;
                case 1:
                    p2Points += 6;
                    break;
            }
            line = reader.readLine();
        }
        System.out.println("Your points are: " + p2Points);
    }

    public static int calcRound(String enemy, String result){
        int points = 0;
        switch (result){
            case "X":
                points += 0;
                switch (enemy){
                    case "A":
                        points += 3;
                        break;
                    case "B":
                        points += 1;
                        break;
                    case "C":
                        points += 2;
                        break;
                }
                break;
            case "Y":
                points += 3;
                switch (enemy){
                    case "A":
                        points += 1;
                        break;
                    case "B":
                        points += 2;
                        break;
                    case "C":
                        points += 3;
                        break;
                }
                break;
            case "Z":
                points += 6;
                switch (enemy){
                    case "A":
                        points += 2;
                        break;
                    case "B":
                        points += 3;
                        break;
                    case "C":
                        points += 1;
                        break;
                }
                break;
        }
        return points;
    }

    public static void part2(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        int points = 0;
        while(line!=null){
            String[] round = line.split(" ");
            points += calcRound(round[0], round[1]);
            line = reader.readLine();
        }

        System.out.println("Your points are: " + points);
    }

    public static void main(String[] args) throws IOException {;
        String path = "\\Users\\Bojan\\Desktop\\AdventOfCode\\src\\com\\company\\input.txt";
        System.out.println("Part 1:");
        part1(path);
        System.out.println("Part 2:");
        part2(path);
    }
}
