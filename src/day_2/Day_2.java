package day_2;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ashkan Amiri
 * Date:  2021-01-19
 * Time:  15:54
 * Project: advent of code 2020
 * Copyright: MIT
 */
public class Day_2 {

    public void isValid() {
        List<Input> inputList = Input.splitInput();
        int matches = 0;
        int correct = 0;

        for (int i = 0; i < inputList.size(); i++) {
            Matcher matcher = Pattern.compile(inputList.get(i).getCharacter()).matcher(inputList.get(i).getPassword());
            while (matcher.find())
                matches++;

            if (inputList.get(i).getMin() <= matches && inputList.get(i).getMax() >= matches) {
                correct++;
                System.out.println("true");
                matches = 0;
            } else matches = 0;
        }
        System.out.println(correct);
    }

    public void isValid_2() {
        List<Input> inputList = Input.splitInput();
        int correct = 0;
//        if (inputList.get(0).getPassword().length() < inputList.get(0).getMin() ||
//                inputList.get(0).getPassword().length() < inputList.get(0).getMax())
        int i = 0;
        int j = 0;
        for (Input input : inputList) {
            String psw = input.getPassword();
            String first = String.valueOf(psw.charAt(input.getMin() - 1));
            String second = String.valueOf(psw.charAt(input.getMax() - 1));
            String character = input.getCharacter();
            System.out.println(i++ + "-" + character + "---" + first + "---" + second);
            if (character.equalsIgnoreCase(first) & !character.equalsIgnoreCase(second)) {
                correct++;
                System.out.println("----true----");
            } else if (character.equalsIgnoreCase(second) && !character.equalsIgnoreCase(first)) {
                correct++;
                System.out.println("----true2----");
            }  if (character.equals(first) ^ character.equals(second)){
                j++;
                System.out.println("----true3----");

            }
        }
        System.out.println(correct + " " + j);
    }


    //4-5 r: rrrjr
    public static void main(String[] args) {
        Day_2 day2 = new Day_2();
        day2.isValid_2();
    }
}
