package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Main {

    public static ArrayList<Integer> addIndex = new ArrayList<>();
    public static ArrayList<Character> CRTrow = new ArrayList<>();
    public static int cycle = 0;
    public static int cycle_MAX;
    public static int interesting;
    public static int X;

    public static void reset(){
        X = 1;
        addIndex = new ArrayList<>();
        for(int i=0; i<=500; i++){
            addIndex.add(0);
        }
    }

    public static char spriteVisibility(){
        int line = (cycle-1) % 40;
        //System.out.println("Line is: " + line);
        if(line == X-1 || line == X || line == X+1){
            return '#';
        }
        return '.';
    }

    public static void runSignal(BufferedReader input, int part) throws IOException {
        int result =0;
        int countdown = 0;
        if(part == 1){
            interesting = 20;
            cycle_MAX = 221;
        }else{
            interesting = 40;
            cycle_MAX = 240;
        }
        for(cycle = 1; cycle<=cycle_MAX; cycle++){
            if(countdown == 0){
                String line = input.readLine();
                String[] parts = line.split(" ");
                if(parts[0].equals("addx")){
                    int added = Integer.parseInt(parts[1]);
                    addIndex.set(cycle+2, added);
                    countdown = 1;
                }
            }else{
                countdown--;
            }

            int increment = addIndex.get(cycle);
            if(increment != 0){
                //System.out.println("Adding " + tba + " at the end of cycle " + cycle);
                X += increment;
            }

            if(part == 2){
                CRTrow.add(spriteVisibility());
            }

            if(cycle == interesting){
                if(part == 2){
                    String row = "";
                    for(int i=0; i< CRTrow.size(); i++){
                        row+=(CRTrow.get(i));
                    }
                    System.out.println(row);
                    CRTrow = new ArrayList<>();
                }else{
                    int signal_strenght = cycle * X;
                    //System.out.println("X is: " + X);
                    //System.out.println("Signal Strenght at cycle " + cycle + " is: " + signal_strenght);
                    result+=signal_strenght;
                }
                interesting+=40;
            }

        }
        if(part == 1){
            System.out.println("Result is: " + result);
        }
    }

    public static void part1(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        reset();
        runSignal(reader, 1);
        /*
        while(line!=null){
            line = reader.readLine();
        }
        int result =0;
        System.out.println(result);
        */
    }

    public static void part2(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        reset();
        runSignal(reader, 2);
        /*
        while(line!=null){
            line = reader.readLine();
        }
        System.out.println(result);
        */
    }

    public static void main(String[] args) throws IOException {;
        String path = "\\Users\\Bojan\\Desktop\\AdventOfCode\\src\\com\\company\\input.txt";
        System.out.println("Part 1:");
        part1(path);
        System.out.println("Part 2:");
        part2(path);
    }
}
