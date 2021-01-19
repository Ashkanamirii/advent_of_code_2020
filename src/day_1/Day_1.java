package day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ashkan Amiri
 * Date:  2021-01-19
 * Time:  14:32
 * Project: advent of code 2020
 * Copyright: MIT
 */
public class Day_1 {
    List<Integer> importList = new ArrayList<>();
    File myObj = new File("src/day_1/day1.txt");

    public Integer task_A(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == 2020) {
                    System.out.println("I-->" + list.get(i) + " " + "J-->" + list.get(j));
                    return list.get(i) * list.get(j);
                }
            }
        }
        return 0;
    }

    public Integer task_B(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    if (list.get(i) + list.get(j) + list.get(k) == 2020) {
                        System.out.println("I-->" + list.get(i) +" J-->" + list.get(j)+ " K-->" + list.get(k));
                        return list.get(i) * list.get(j) * list.get(k);
                    }
                }
            }
        }
        return 0;
    }

    public List<Integer> readFile() {
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                Integer data = Integer.parseInt(myReader.nextLine());
                importList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return importList;
    }

    public static void main(String[] args) {
        Day_1 day_1 = new Day_1();
        System.out.println(day_1.task_A(day_1.readFile()));
        System.out.println("----------------------------------");
        System.out.println(day_1.task_B(day_1.readFile()));
    }
}
