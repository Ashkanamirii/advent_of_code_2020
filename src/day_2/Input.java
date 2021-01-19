package day_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ashkan Amiri
 * Date:  2021-01-19
 * Time:  17:07
 * Project: advent of code 2020
 * Copyright: MIT
 */
public class Input {
    private String character ;
    private String password ;
    private int min;
    private int max;


    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }


    public static List<String> readFile() {
        List<String> input = new ArrayList<>();
        File myObj = new File("src/day_2/day2.txt");
        File myObjTest = new File("src/day_2/day2Test.txt");
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                input.add(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return input;
    }

    public static List<Input> splitInput() {
        List<String> s = readFile();
        List<Input> inputList = new ArrayList<>(1000);
        for (int i = 0; i < s.size(); i++) {
            Input input = new Input();
            String in = s.get(i);
            String[] dash = in.split("-");
            String[] m = dash[1].split(" ");
            input.setMin( Integer.parseInt(dash[0]));
            input.setMax(Integer.parseInt(m[0]));
            input.setCharacter(m[1].substring(0, 1));
            input.setPassword( m[2]);
            inputList.add(input);
        }
        return inputList;
    }

    public static void main(String[] args) {
        splitInput();
    }

}
