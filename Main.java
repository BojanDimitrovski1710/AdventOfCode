package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Main {

    public static int part1(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        int largest=0;
        int total=0;
        while(line!=null){
            if(line.equals("")){
                if(total>largest) {
                    largest = total;
                }
                total = 0;
            }else{
                total += Integer.parseInt(line);
            }
            line = reader.readLine();
        }
        return largest;
    }

    public static int part2(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        ArrayList<Integer> totals = new ArrayList<>();
        int total = 0;
        while(line!=null){
            if(line.equals("")){
                totals.add(total);
                total = 0;
            }else{
              total += Integer.parseInt(line);
            }
            line = reader.readLine();
        }
        Collections.sort(totals, Collections.reverseOrder());
        int result = 0;
        for(int i=0; i<3; i++){
            result += totals.get(i);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {;
        String path = "\\Users\\Bojan\\Desktop\\AdventOfCode\\src\\com\\company\\input.txt";
        int p1 = part1(path);
        System.out.println(p1);
        int p2 = part2(path);
        System.out.println(p2);
    }
}
