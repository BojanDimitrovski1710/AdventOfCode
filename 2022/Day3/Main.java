package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Main {

    public static boolean fullyOverlaps(String s){
        String[] elves = s.split(",");
        String[] sections1 = elves[0].split("-");
        String[] sections2 = elves[1].split("-");
        int sec1start = Integer.parseInt(sections1[0]);
        int sec1end = Integer.parseInt(sections1[1]);
        int sec2start = Integer.parseInt(sections2[0]);
        int sec2end = Integer.parseInt(sections2[1]);

        if(sec1start == sec2start || sec1end == sec2end){
            return true;
        }

        if(sec1start < sec2start && sec1end > sec2end){
            return true;
        }
        if(sec2start < sec1start && sec2end > sec1end){
            return true;
        }
        return false;
    }
    public static boolean overlapsAbsolute(String s){
        String[] elves = s.split(",");
        String[] sections1 = elves[0].split("-");
        String[] sections2 = elves[1].split("-");
        int sec1start = Integer.parseInt(sections1[0]);
        int sec1end = Integer.parseInt(sections1[1]);
        int sec2start = Integer.parseInt(sections2[0]);
        int sec2end = Integer.parseInt(sections2[1]);

        if(sec1start == sec2start || sec1end == sec2end || sec1start == sec2end || sec1end == sec2start){
            return true;
        }else{
            if(sec1start < sec2start){
                if (sec1end >= sec2start){
                    return true;
                }else{
                    return false;
                }
            }else{
                if(sec2end >= sec1start){
                    return true;
                }else{
                    return false;
                }
            }
        }
    }

    public static void part1(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        int result = 0;
        while(line!=null){
            if(fullyOverlaps(line)){
                result++;
            }
            line = reader.readLine();
        }
        System.out.println(result);
    }

    public static void part2(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        int result = 0;
        while(line!=null){
            if(overlapsAbsolute(line)){
                result++;
            }
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
