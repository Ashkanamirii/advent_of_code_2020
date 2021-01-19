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

    public void isValid_1() {
        List<Input> inputList = Input.splitInput();
        int matches = 0;
        int correct = 0;

        for (Input input : inputList) {
            Matcher matcher = Pattern.compile(input.getCharacter()).matcher(input.getPassword());
            while (matcher.find())
                matches++;

            if (input.getMin() <= matches && input.getMax() >= matches) {
                correct++;
                System.out.println("true");
                matches = 0;
            } else matches = 0;
        }
        System.out.println(correct);
    }

    public void isValid_2() {
        List<Input> inputList = Input.splitInput();
        int i = 0;
        int j = 0;
        for (Input input : inputList) {
            String psw = input.getPassword();
            String first = String.valueOf(psw.charAt(input.getMin() - 1));
            String second = String.valueOf(psw.charAt(input.getMax() - 1));
            String character = input.getCharacter();
            System.out.println(i++ + "-" + character + "---" + first + "---" + second);
              if (character.equals(first) ^ character.equals(second)){
                j++;
                System.out.println("----true----");
            }
        }
        System.out.println(j);
    }
    public static void main(String[] args) {
        Day_2 day2 = new Day_2();
        day2.isValid_1();//398
        day2.isValid_2();//562
    }
}
